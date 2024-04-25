package com.bangvan.buoi2.buoi2demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Buoi2demoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Buoi2demoApplication.class, args);
		Phone phone = context.getBean(Phone.class);
		System.out.println(phone.getName());
	}

}
