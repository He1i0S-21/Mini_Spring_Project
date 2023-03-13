package com.springframework.core.io;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Files;

/**
 * @author G
 * @create 2023-03-10 2:36 AM
 */
public class FileSystemResource implements Resource{
    private final String filepath;

    public FileSystemResource(String filepath) {
        this.filepath = filepath;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        try {
            Path path = new File(filepath).toPath();
            return Files.newInputStream(path);
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
