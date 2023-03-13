package com.springframework.beans.factory;

/**
 * @author G
 * @create 2023-03-11 11:25 PM
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
