package org.cintia.cbottle.web.domain;

import java.math.BigInteger;

public class Customer {
	
	private String email;
	private String password;
	private String name;
	private String mobileNumber;
	private BigInteger balance;
	private boolean loyalty;
	
	public Customer(String email, String name, String mobileNumber, BigInteger balance, boolean loyalty) {
		this.email = email;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
		this.loyalty = loyalty;
	}
	
	public String getName() {
		return name;
	}
	
	public BigInteger getBalance() {
		return balance;
	}
	
	public boolean isLoyalty() {
		return loyalty;
	}
}
