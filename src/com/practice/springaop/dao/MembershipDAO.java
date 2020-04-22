package com.practice.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount(Account account) {
		System.out.println(getClass() + "Creating a membership account");
		return true;
	}
}
