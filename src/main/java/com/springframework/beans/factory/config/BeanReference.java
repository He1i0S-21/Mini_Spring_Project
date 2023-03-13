package com.springframework.beans.factory.config;

/**
 * @author G
 * @create 2023-03-10 1:54 AM
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName){
        this.beanName=beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
