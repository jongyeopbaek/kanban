package controllers.works;

import static commons.ScriptUtils.*;
import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SaveController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String URI = req.getRequestURI();
            String mode = URI.indexOf("edit") != -1 ? "edit" : "add";

            Work work = null;

            if (mode.equals("edit")) {
                InfoService infoService = WorkServiceManager.getInstance().infoService();
                 work = infoService.get(getWorkNo(req));
                if (work == null) {
                    throw new WorkNotFoundException();
                }
            }else {
                work = new Work();
            }

            req.setAttribute("work", work);

            String[] addScript = {"ckeditor/ckeditor", "work/form"};
            req.setAttribute("addScript", addScript);

            ViewUtils.load(req, resp, "works", mode);
        }catch (Exception e){
            alertError(resp, e, -1); // 에러 메세지 alert로 출력 , history.go(-1)
        }
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {
        SaveService saveService = WorkServiceManager.getInstance().saveService();
        try {
            saveService.save(req);

            go(resp, req.getContextPath() + "/works", "parent");

        } catch (Exception e) {
            alertError(resp, e);
            e.printStackTrace();
        }


    }


    private long getWorkNo(HttpServletRequest req){
        String URI = req.getRequestURI();
        String pattern = "edit/(\\d*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher= p.matcher(URI);
        if(matcher.find()){
            return Long.parseLong(matcher.group(1));

        }

        return 0L;
    }


}