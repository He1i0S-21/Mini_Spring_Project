package com.springframework.test.ioc;

import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import com.springframework.test.ioc.service.HelloService;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		beanFactory.registerBeanDefinition("helloService", beanDefinition);

		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}
