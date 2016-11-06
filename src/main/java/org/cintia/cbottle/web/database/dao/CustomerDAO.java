package org.cintia.cbottle.web.database.dao;

import java.util.List;

import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.database.query.CustomerQuery;
import org.cintia.cbottle.web.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO implements DataAccess<Customer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RowMapper<Customer> customerRowMapper;
	
	@Override
	public void insert(Customer customer) {
		
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public Customer findById(String id) {
		return null;
	}
	
	@Override
	public List<Customer> getAll() {
		return null;
	}
}
