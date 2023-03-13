package com.springframework.beans.factory.config;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.BeanFactory;

import java.beans.Beans;

/**
 * @author G
 * @create 2023-03-10 3:26 PM
 */
public interface AutowireCapableBeanFactory extends BeanFactory {


    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)  throws BeansException;
}

