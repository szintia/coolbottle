package org.cintia.cbottle.web.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cintia.cbottle.web.domain.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setEmail(rs.getString("email"));
		customer.setPassword(rs.getString("password"));
		customer.setName(rs.getString("customer_name"));
		customer.setMobileNumber(rs.getString("mobile"));
		customer.setAccountBalance(rs.getBigDecimal("balance"));
		customer.setLoyalty(rs.getString("loyalty"));
		return customer;
	}

}
