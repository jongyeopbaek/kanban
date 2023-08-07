package controllers.works;

import controllers.Controller;
import controllers.URLRouter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 작업관리 컨트롤러
 - 작업 목록 - /works
 - 작업 등록 - /works/add
 - 작업 조회 - /works/작업 번호
 - 작업 수정 - /works/edit/등록번호
 - 작업 삭제 - /works/등록번호/delete
 */
public class WorksURLRouter implements URLRouter {
    @Override
    public void route(HttpServletRequest req, HttpServletResponse resp, String location) {

        String mode = getMode(req.getRequestURI(), location);
        mode = mode == null || mode.isBlank() ? "list" : mode;
        if(mode.matches("\\d")){ //작업 조회 모드
            mode = "view";
        }
        Controller controller = null;
        if(mode.equals("list")){
            controller = new ListController();
        }else if(mode.equals("view")){
            controller = new ViewController();
        } else if (mode.equals("add") || mode.equals("edit")) {
            controller = new SaveController();

        } else if (mode.equals("delete")) {
            controller = new DeleteController();
        }

        if (controller == null) return;


        String method = req.getMethod().toUpperCase(); //요청 메서드
        if (method.equals("POST")){
            controller.post(req,resp);
        }else {
            controller.get(req, resp);
        }
    }
}