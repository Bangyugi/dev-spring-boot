package com.bangvan.AOPdemo;

import com.bangvan.AOPdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
		return  runner ->{
			demoTheBeforeAdvice(accountDAO);
		};
	}


	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();

		System.out.println("\n let's call it again!");
		accountDAO.addAccount();
	}
}
