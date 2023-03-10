package com.springframework.test.ioc.service;

import com.springframework.context.support.ClassPathXmlApplicationContext;
import com.springframework.test.ioc.bean.Car;
import com.springframework.test.ioc.bean.Person;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public class ApplicationContextTest {

	@Test
	public void testApplicationContext() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

		Person person = applicationContext.getBean("person", Person.class);
		System.out.println(person);
		//name属性在CustomBeanFactoryPostProcessor中被修改为ivy
		assertThat(person.getName()).isEqualTo("ivy");

		Car car = applicationContext.getBean("car", Car.class);
		System.out.println(car);
		//brand属性在CustomerBeanPostProcessor中被修改为lamborghini
		assertThat(car.getBrand()).isEqualTo("lamborghini");
	}
}
