package com.springframework.core.io;

/**
 * @author G
 * @create 2023-03-10 2:23 AM
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
