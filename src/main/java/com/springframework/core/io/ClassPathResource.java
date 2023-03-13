package com.springframework.core.io;

import com.springframework.beans.BeansException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author G
 * @create 2023-03-10 2:21 AM
 */
public class ClassPathResource implements Resource{

    private  final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        //Todo
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if(is == null){
            throw  new FileNotFoundException(this.path+ "cannot to opened because it does not exist");
        }
        return is;
    }
}
