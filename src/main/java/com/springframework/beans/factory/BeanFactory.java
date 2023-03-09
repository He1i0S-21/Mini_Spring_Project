package com.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author G
 * @create 2023-03-09 6:05 PM
 */
public class BeanFactory {
        //1. 定义一个Map用来存储bean，用HashMap查找速度快
       private Map<String, Object> BeanMap = new  HashMap<>();
        //2. 存储bean
        public void registerBean(String name,Object bean){
                BeanMap.put(name,bean);
        }
        //3. 获取bean
        public Object getBean(String name){
               return  BeanMap.get(name);
        }
}
