package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

/**
 * @author G
 * @create 2023-03-12 3:53 PM
 */
public interface BeanFactoryAware extends Aware{


        void setBeanFactory(BeanFactory beanFactory) throws BeansException;


}
