package com.example.onlinebookstore.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.example.onlinebookstore.servlets.BookRegistrationServlet.*(..))")
    public void bookRegistrationMethods() {}

    @Before("bookRegistrationMethods()")
    public void logBefore() {
        System.out.println("Method execution started in BookRegistrationServlet.");
    }

    @After("bookRegistrationMethods()")
    public void logAfter() {
        System.out.println("Method execution completed in BookRegistrationServlet.");
    }
}
