package org.cintia.cbottle.web.database.query;

import java.math.BigDecimal;

import org.cintia.cbottle.web.domain.Customer;

public enum CustomerQuery implements Query {
	
	INSERT("INSERT INTO customer (email, password, customer_name, mobile, balance, loyalty) VALUES (?, ?, ?, ?, ?, ?)"),
	SELECT_BY_EMAIL("SELECT * FROM customer WHERE email = ? "),
	SELECT_ALL("SELECT * FROM customer");
	
	private String query;
	
	private CustomerQuery(String query) {
		this.query = query;
	}

	@Override
	public String sql() {
		return query;
	}
	
	private static BigDecimal accountBalance = BigDecimal.ZERO;
	private static boolean loyalty = false;
	
	// TODO hashing password using Spring Security, use this one: BCryptPasswordEncoder
	public static Object[] mapInsertParams(Customer customer) {
		Object[] params = {customer.getEmail(), customer.getName(), customer.getMobileNumber(), accountBalance, loyalty};
		return params;
	}
}
