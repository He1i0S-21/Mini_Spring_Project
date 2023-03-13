package com.springframework.test.ioc.service;

import com.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author derekyi
 * @date 2020/11/29
 */
public class InitAndDestoryMethodTest {

	@Test
	public void testInitAndDestroyMethod() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
		applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
	}
}
