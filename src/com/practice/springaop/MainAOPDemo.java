package com.practice.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.springaop.dao.Account;
import com.practice.springaop.dao.AccountDAO;
import com.practice.springaop.dao.MembershipDAO;

public class MainAOPDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class,
				MyLoggerConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO ao = context.getBean("membershipDAO", MembershipDAO.class);

		accountDAO.addAccount(new Account(), true);

		accountDAO.setName("Akshay");
		accountDAO.getName();

		accountDAO.setServiceCode("Express");
		accountDAO.getServiceCode();

		ao.addAccount(new Account());

		context.close();
	}

}
