package org.cintia.cbottle.web.database.dao;

import java.util.List;

import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.domain.Customer;

public class CustomerDAO implements DataAccess<Customer> {

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
