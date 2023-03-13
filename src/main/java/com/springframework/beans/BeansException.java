package com.springframework.beans;

/**
 * @author G
 * @create 2023-03-09 6:57 PM
 */


public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
