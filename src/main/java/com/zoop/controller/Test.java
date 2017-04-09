package com.zoop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoop.service.TestService;

public class Test {

	public static void main(String[]args){
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService testService = (TestService)application.getBean("testService");
		testService.test();
	}
	
}
