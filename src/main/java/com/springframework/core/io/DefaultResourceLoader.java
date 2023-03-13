package com.springframework.core.io;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author G
 * @create 2023-03-10 2:41 AM
 */
public class DefaultResourceLoader implements ResourceLoader{

//    定义path前缀
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
//        1. 是否为Classpath下的资源
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else{
//            2.其他情况，先当作url处理
            URL url = null;
            try {
                url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //3.当作文件系统下的资源处理
                return new FileSystemResource(location);
            }

        }
    }
}
