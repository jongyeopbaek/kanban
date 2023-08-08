package models.works;

import Vaildators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class SaveService {
    private WorkDao workDao;

    private Validator<Work> validator;
    public SaveService(WorkDao workDao, Validator<Work> validator){
        this.workDao = workDao;
        this.validator = validator;
    }



    public void save(Work work) {
        // work 데이터 검증 (유효성 검사)
    validator.check(work);


        boolean result = workDao.save(work); // 의존
        if (!result){//등록 실패시
            throw new WorkSaveException();
             }

    }

    public  void save(HttpServletRequest req){
        Work work = new Work();
        work.setSubject(req.getParameter("subject"));
        work.setContent(req.getParameter("content"));

        String status = req.getParameter("status");
        work.setStatus(status == null || status.isBlank() ? Status.READY : Status.valueOf(status));

        String workNo = req.getParameter("workNo");
        if (workNo != null && !workNo.isBlank()){
            work.setWorkNo(Long.parseLong(workNo));

            save(work);
        }
    }

}