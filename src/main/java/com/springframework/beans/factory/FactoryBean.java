package com.springframework.beans.factory;

/**
 * @author G
 * @create 2023-03-13 9:27 PM
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
