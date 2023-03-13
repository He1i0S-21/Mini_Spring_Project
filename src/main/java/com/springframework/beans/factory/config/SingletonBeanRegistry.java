package com.springframework.beans.factory.config;

/**
 * @author G
 * @create 2023-03-09 8:17 PM
 */
public interface SingletonBeanRegistry {


    Object getSingleton(String beanName);
}
