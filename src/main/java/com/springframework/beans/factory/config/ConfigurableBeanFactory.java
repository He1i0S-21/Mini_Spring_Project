package com.springframework.beans.factory.config;

import com.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author G
 * @create 2023-03-10 3:27 PM
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry{

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
