package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author G
 * @create 2023-03-09 6:05 PM
 */
public interface BeanFactory {
   Object getBean(String name)throws BeansException;

   /**
    * 根据名称和类型查找bean
    *
    * @param name
    * @param requiredType
    * @param <T>
    * @return
    * @throws BeansException
    */
   <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
