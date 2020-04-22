package com.practice.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class CloudLoggingAspect {

	@Before("com.practice.springaop.aspect.AspectLogging.getter()")
	public void afterAddAccountAdvice() {
		System.out.println("\n====>>> Executing Cloud Logging");
	}
}
