package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;


/**
 * @author G
 * @create 2023-03-09 10:15 PM
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{


    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {

        //TODO
        throw new UnsupportedOperationException("CGLIB instantiation strategy is not supported");
    }
}
