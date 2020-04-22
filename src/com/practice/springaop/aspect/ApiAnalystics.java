package com.practice.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.practice.springaop.dao.Account;

@Component
@Aspect
@Order(2)
public class ApiAnalystics {

	@Before("com.practice.springaop.aspect.AspectLogging.setter()")
	public void afterAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n====>>> Executing Api Analystics");

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method Signature:" + signature);

		Object[] objects = joinPoint.getArgs();

		for (Object tempObject : objects) {
			System.out.println(tempObject);

			if (tempObject instanceof Account) {

				System.out.println(((Account) tempObject).getName());
				System.out.println(((Account) tempObject).getLevel());
			}
		}
	}
}
