package com.practice.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + "Calling get Name method of AccountDAO");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "Calling set Name method of AccountDAO");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "Calling get Service method of AccountDAO");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "Calling set Service method of AccountDAO");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean var) {
		System.out.println(getClass() + "Add Account using DB Call");
	}

	public List<Account> findAllAccounts(boolean result) {
		if (result == true) {
			throw new RuntimeException("Here is ur Output");
		}
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account("Akshay", "Gold");
		Account account2 = new Account("Sagar", "silver");
		accounts.add(account1);
		accounts.add(account2);
		return accounts;

	}
}
