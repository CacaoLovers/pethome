package ru.itis.pethome.controller.rest;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

@Controller
@RequestMapping("/image")
public class ImageController {

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {

        String path = new File(".").getCanonicalFile() + File.separator + "images" + File.separator;

        File file = new File(path + imageName);
        byte[] content = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(content);
    }

    @PostMapping
    public UUID addImage(HttpServletRequest request) throws IOException, ServletException {

        String path = new File(".").getCanonicalFile() + File.separator + "images" + File.separator;
        String fileName = null;
        String extension = null;

        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }


        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            if (fileName.equals("")){
                throw new RuntimeException();
            }
            extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            UUID uuid = UUID.randomUUID();
            fileName = uuid.toString().substring(0, 8) + extension;
            part.write(path + File.separator + fileName);
            break;
        }

        return UUID.randomUUID();
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";

    }
}
