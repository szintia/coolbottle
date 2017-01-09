package org.cintia.cbottle.web.database.dao;

import java.util.List;

import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.database.query.CustomerQuery;
import org.cintia.cbottle.web.database.query.Query;
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
		String insertCustomer = CustomerQuery.INSERT.sql();
		Object[] paramValues = CustomerQuery.mapInsertParams(customer);
		jdbcTemplate.update(insertCustomer, paramValues);
	}

	@Override
	public void delete(String id) {
		String deleteCustomer = CustomerQuery.DELETE.sql();
		jdbcTemplate.update(deleteCustomer, id);
		
	}

	@Override
	public Customer findById(String email) {
		String findCustomerById = CustomerQuery.SELECT_BY_EMAIL.sql();
		return jdbcTemplate.queryForObject(findCustomerById, customerRowMapper, email);
	}
	
	@Override
	public List<Customer> getAll() {
		String getCustomers = CustomerQuery.SELECT_ALL.sql();
		return jdbcTemplate.query(getCustomers, customerRowMapper);
	}

	@Override
	public List<Customer> query(Query query, Object... paramValues) {
		String sql = 
		return null;
	}
}
