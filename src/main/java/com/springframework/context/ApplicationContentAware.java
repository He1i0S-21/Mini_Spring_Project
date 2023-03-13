package com.springframework.context;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.Aware;

/**
 * @author G
 * @create 2023-03-12 3:56 PM
 */
public interface ApplicationContentAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
