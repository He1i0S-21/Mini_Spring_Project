package com.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author G
 * @create 2023-03-10 2:27 AM
 */
public class UrlResource implements Resource{
    private  final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();

        try {
            return urlConnection.getInputStream();
        } catch (IOException ex) {
            throw ex;
        }
    }
}
