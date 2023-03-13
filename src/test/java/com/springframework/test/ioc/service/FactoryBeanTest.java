package com.springframework.test.ioc.service;

import com.springframework.context.support.ClassPathXmlApplicationContext;
import com.springframework.test.ioc.bean.Car;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public class FactoryBeanTest {

	@Test
	public void testFactoryBean() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

		Car car = applicationContext.getBean("car", Car.class);
		assertThat(car.getBrand()).isEqualTo("porsche");
	}
}
