package com.springframework.context.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanPostProcessor;
import com.springframework.context.ApplicationContentAware;
import com.springframework.context.ApplicationContext;

/**
 * @author G
 * @create 2023-03-12 3:58 PM
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private  final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContentAware){
            ((ApplicationContentAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
