package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDao;
import com.niit.collaboration.model.User;

public class UserTest {
	public static void main(String ar[])
	{
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		System.out.println("e1");
		context.scan("com.niit.collaboration");
		context.refresh();
		System.out.println("e2");
		
	   UserDao userDAO = 	(UserDao) context.getBean("userDAO");
		
		
	   User user = 	(User) context.getBean("User");
	   user.setUsername("sw123");
	   user.setName("sweta");
	   user.setEmail("abc@gmail.com");
	   user.setActive(true);
	   user.setPassword("password");
	  
	   //user.setAdmin(false);
	 
	   
	   
	   System.out.println("e3");

	   
	   userDAO.save(user);
	   //userDAO.saveOrUpdate(user);
	   
	   
	}


}
