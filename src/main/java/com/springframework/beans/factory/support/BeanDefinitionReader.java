package com.springframework.beans.factory.support;


import com.springframework.beans.BeansException;
import com.springframework.core.io.Resource;
import com.springframework.core.io.ResourceLoader;

/**
 * @author G
 * @create 2023-03-10 4:42 PM
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegister();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String[] locations) throws BeansException;

}
