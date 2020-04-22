package com.practice.springaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.springaop.dao.Account;
import com.practice.springaop.dao.AccountDAO;

public class AfterThrowingAOPMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class,
				MyLoggerConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;
		try {
			boolean result = true;
			accounts = accountDAO.findAllAccounts(result);
		} catch (Exception e) {

			System.out.println("Throwing Exception:" + e);
		}

		System.out.println("All Accounts:" + accounts);

		context.close();
	}

}
