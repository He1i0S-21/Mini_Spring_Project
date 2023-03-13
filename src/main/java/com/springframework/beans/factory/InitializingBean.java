package com.springframework.beans.factory;

/**
 * @author G
 * @create 2023-03-11 11:23 PM
 */
public interface InitializingBean {
    void afterPropertiesSet() throws  Exception;
}
