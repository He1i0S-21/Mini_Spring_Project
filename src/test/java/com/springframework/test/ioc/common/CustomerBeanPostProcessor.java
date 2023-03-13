package com.springframework.test.ioc.common;


import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanPostProcessor;
import com.springframework.test.ioc.bean.Car;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization, beanName: " + beanName);
		//换兰博基尼
		if ("car".equals(beanName)) {
			((Car) bean).setBrand("lamborghini");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization, beanName: " + beanName);
		return bean;
	}
}
