package com.bangvan.AOPdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Executing @Before advice con addAccount()");
    }

    @After("execution (public void addAccount())")
    public void afterAddAccountAdvice(){
        System.out.println("Done!");
    }
}
