package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.BeanFactory;
import com.springframework.beans.factory.FactoryBean;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.factory.config.BeanPostProcessor;
import com.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author G
 * @create 2023-03-09 8:36 PM
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

private final List<BeanPostProcessor> beanPostProcessors =new ArrayList<>();
private final Map<String,Object> factoryBeanObjectCache  = new HashMap<>();

    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if(sharedInstance !=null){
            //如果是FactoryBean,从FactoryBean#getObject中创建Bean
            return  getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name,beanDefinition);
        return getObjectForBeanInstance(bean, name);
    }


    protected Object getObjectForBeanInstance(Object beanInstance, String beanName){
        Object object = beanInstance;
        try{
        if(beanInstance instanceof FactoryBean) {
            FactoryBean factoryBean = ((FactoryBean) beanInstance);
            if (factoryBean.isSingleton()) {
                //Singleton作用域bean在缓存中获取
                object = this.factoryBeanObjectCache.get(beanName);
            }
            if (object == null) {
                object = factoryBean.getObject();
                this.factoryBeanObjectCache.put(beanName, object);
            } else {
                //prototype作用域bean，新创建bean
                object = factoryBean.getObject();
            }
        }
        }catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
        return object;
    }
    @Override
    public <T> T getBean(String name,Class<T> requirdTypep) throws BeansException{
        return ((T)getBean(name));
    }
    protected  abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
    protected abstract  BeanDefinition getBeanDefinition(String beanName) throws  BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors(){
        return this.beanPostProcessors;
    }
}
