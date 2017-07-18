package org.cintia.cbottle.web.service;

import org.cintia.cbottle.web.database.dao.CustomerDAO;
import org.cintia.cbottle.web.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void save(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		dao.insert(customer);
	}
}
