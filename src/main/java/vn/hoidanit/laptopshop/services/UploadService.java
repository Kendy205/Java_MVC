package vn.hoidanit.laptopshop.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletConnection;
import jakarta.servlet.ServletContext;

@Service
public class UploadService {

    private final ServletContext servletContext;

    public UploadService(ServletContext _servletContext) {
        this.servletContext = _servletContext;
    }

    public String handleUpload(MultipartFile file, String targetFolder) {
        // lấy r a đường link thực tế dẫn tới
        // /resources/images(D:hoctap/..../resources/images)
        String rootPath = this.servletContext.getRealPath("/resources/img");
        try {
            // chuyển thành byte
            byte[] bytes = file.getBytes();
            // File.separator = /
            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();
            // Create the file on server
            long currentTime = System.currentTimeMillis();
            File serverFile = new File(dir.getAbsolutePath() + File.separator +
                    +currentTime + "-" + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            String filePath = currentTime + "-" + file.getOriginalFilename();
            return filePath;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
