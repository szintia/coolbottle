package org.cintia.cbottle.web.database.query;

import org.cintia.cbottle.web.domain.Customer;

public enum CustomerQuery implements Query {
	
	INSERT("INSERT INTO customer (email, password, customer_name, mobile, balance, loyalty) VALUES (?, ?, ?, ?, ?, ?)"),
	SELECT_BY_EMAIL("SELECT * FROM customer WHERE email = ? "),
	SELECT_ALL("SELECT * FROM customer"),
	DELETE("DELETE FROM customer WHERE email = ?");
	
	private String query;
	
	private CustomerQuery(String query) {
		this.query = query;
	}

	@Override
	public String sql() {
		return query;
	}
	
	//private static BigDecimal accountBalance = BigDecimal.ZERO;
	private static String loyalty = "N";
	
	// TODO hashing password using Spring Security, use this one: BCryptPasswordEncoder
	public static Object[] mapInsertParams(Customer customer) {
		Object[] params = {customer.getEmail(), customer.getPassword(), customer.getName(), customer.getMobileNumber(), customer.getAccountBalance(), loyalty};
		return params;
	}
}
