package controllers.files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletDiskFileUpload;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@WebServlet("/file/upload")
public class FileUploadController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = req.getServletContext().getRealPath("/static/uploads");

        JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload();
        upload.setSizeMax(1024 * 1024 * 20); // 20mb

        List<DiskFileItem> items = upload.parseRequest(req);
        for (DiskFileItem item : items) {
            if (!item.isFormField()) { // 파일 데이터
                String fileName = item.getName();
                Path path = Path.of(uploadPath, fileName);
                item.write(path);
            }
        }
    }
}