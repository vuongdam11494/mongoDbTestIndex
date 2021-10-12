package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLogTimeConfig {
	
	
	long startTime = 0;

	@Before("execution(* com.example.demo.servic.UserServic.*(..))")
	public void LogBeginTime() {
		startTime = System.currentTimeMillis();
	}
	
	@After("execution(* com.example.demo.servic.UserServic.*(..))")
	public void LogEndTime() {
		System.out.println("method done with :"+(System.currentTimeMillis()-startTime)+" milliseconds");
	}
}
