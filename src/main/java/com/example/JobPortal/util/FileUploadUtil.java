package com.example.JobPortal.util;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
public class FileUploadUtil {

    public static void saveFile(String uploadDir, String filename, MultipartFile multipartFile) throws IOException {

        // Prevent path traversal attacks
        String safeFilename = Paths.get(filename).getFileName().toString();

        if (safeFilename.isEmpty()) {
            throw new IOException("Invalid file name.");
        }

        Path uploadPath = Paths.get(uploadDir);

        // Ensure the directory exists
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(safeFilename);
            log.info("Saving file to: {}", filePath);

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            log.error("Could not save file: {}", safeFilename, ioe);
            throw new IOException("Could not save file: " + safeFilename, ioe);
        }
    }
}
