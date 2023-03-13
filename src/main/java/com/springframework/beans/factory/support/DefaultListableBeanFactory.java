package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author G
 * @create 2023-03-09 8:19 PM
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements  BeanDefinitionRegistry, ConfigurableListableBeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition==null){
            throw new BeansException("No bean named"+ beanName +" is defined");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        //TODO this在这里是什么意思
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }


    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        HashMap<String, T> result = new HashMap<>();
        //java8 map的foreach
        beanDefinitionMap.forEach((beanName,beanDefinition)->{
            Class beanClass = beanDefinition.getBeanClass();

            //判断是否类相同或者是父子关系，A为父
            if(type.isAssignableFrom(beanClass)){
               T bean =  ((T) getBean(beanName));
               result.put(beanName,bean);
            }
        });
    return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        Set<String> beanName = beanDefinitionMap.keySet();
        return beanName.toArray(new String[beanName.size()]);

    }



}
