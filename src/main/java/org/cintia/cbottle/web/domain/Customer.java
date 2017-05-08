package org.cintia.cbottle.web.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Customer {
	
	private String email;
	private String name;
	// TODO hash and salt password
	private String password;
	private String mobileNumber;
	private BigDecimal accountBalance;
	//use 'I' or 'N'
	private String loyalty;
	
	public Customer() {
		
	}
	
	public Customer(String email, String name, String password, String mobileNumber, BigDecimal accountBalance, String loyalty) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.accountBalance = accountBalance;
		this.loyalty = loyalty;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	public String isLoyalty() {
		return loyalty;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Customer)) {
			return false;
		}
		Customer c = (Customer) o;
		return Objects.equals(email, c.email)
				&& Objects.equals(name, c.name)
				&& Objects.equals(loyalty, c.loyalty)
				&& Objects.equals(mobileNumber, c.mobileNumber)
				&& Objects.equals(password, c.password)
				&& Objects.equals(accountBalance, c.accountBalance);
	}

}
