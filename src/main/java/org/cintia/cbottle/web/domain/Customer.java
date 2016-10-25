package org.cintia.cbottle.web.domain;

import java.math.BigDecimal;

public class Customer {
	
	private String email;
	private String name;
	private String mobileNumber;
	private BigDecimal accountBalance;
	private boolean loyalty;
	
	public Customer(String email, String name, String mobileNumber, BigDecimal accountBalance, boolean loyalty) {
		this.email = email;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.accountBalance = accountBalance;
		this.loyalty = loyalty;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	public boolean isLoyalty() {
		return loyalty;
	}
}
