package com.practice.springaop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.practice.springaop.dao.Account;

@Aspect
@Component
@Order(1)
public class AspectLogging {

	@Pointcut("execution(* com.practice.springaop.dao.*.*(..))")
	public void forDAOPackages() {

	}

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.practice.springaop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(com.practice.springaop.dao.Account))")
	// @Before("execution(* add*(com.practice.springaop.dao.Account,..))")
	// @Before("execution(* add*(..))")
	@Before("forDAOPackages()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}

	@Before("forDAOPackagesNotForGetterSetter()")
	public void afterAddAccountAdvice() {
		System.out.println("\n====>>> Executing Api Analystics");
	}

	@Pointcut("execution(* com.practice.springaop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.practice.springaop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDAOPackages() && !(getter()||setter())")
	public void forDAOPackagesNotForGetterSetter() {

	}

	@AfterReturning(pointcut = "execution(* com.practice.springaop.dao.AccountDAO.findAllAccounts(..))", returning = "account")
	public void afterReturningtheOutput(JoinPoint joinPoint, List<Account> account) {

		String string = joinPoint.getSignature().toShortString();

		System.out.println("--->>>>Executing the Joint Cut:" + string);

		System.out.println("Output of return Value:" + account);
	}

	@AfterThrowing(pointcut = "execution(* com.practice.springaop.dao.AccountDAO.findAllAccounts(..))", throwing = "exc")
	public void afterthrowingExp(JoinPoint joinPoint, Throwable exc) {

		String string = joinPoint.getSignature().toShortString();

		System.out.println("--->>>>Executing the Joint Cut for Exception:" + string);

		System.out.println("Output of return Value:" + exc);
	}
}
