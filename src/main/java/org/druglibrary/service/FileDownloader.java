package org.druglibrary.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileDownloader {

    public void downloadFile(String fileUrl, String storePath) throws IOException {
        try (InputStream in = URI.create(fileUrl).toURL().openStream()) {
            Files.copy(in, Paths.get(storePath), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
