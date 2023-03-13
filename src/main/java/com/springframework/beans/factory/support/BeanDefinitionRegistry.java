package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;

/**
 * @author G
 * @create 2023-03-09 7:36 PM
 */
public interface BeanDefinitionRegistry {



    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();
}
