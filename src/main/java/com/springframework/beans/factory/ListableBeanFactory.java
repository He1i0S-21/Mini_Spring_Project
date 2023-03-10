package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author G
 * @create 2023-03-10 3:30 PM
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
 * 返回指定类型的所有实例
 *
 * @param type
 * @param <T>
 * @return
 * @throws BeansException
 */
<T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();

}
