package com.lqh.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lqh.entity.User;
import com.lqh.service.UserService;

public class Test {
	@SuppressWarnings("resource")
	@org.junit.Test
	public void add()  throws Exception{
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) app.getBean("userService");
		User user=userService.getLoginUser(new User("admin","123"));
		System.out.println(user);
	}
	
	@SuppressWarnings("resource")
	@org.junit.Test
	public void addq()  throws Exception{
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) app.getBean("userService");
		List<User> user=userService.getUserList("", 1, 0, 10);
		System.out.println(user);
	}
}
