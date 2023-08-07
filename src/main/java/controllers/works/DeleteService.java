package controllers.works;

import models.works.WorkDao;

public class DeleteService {
    WorkDao workDao = new WorkDao();

    public void delete(long workNo){

        boolean result = workDao.delete(workNo);
    }
}
