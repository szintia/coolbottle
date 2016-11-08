package org.cintia.cbottle.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.cintia.cbottle.web.database.dao.CustomerDAO;
import org.cintia.cbottle.web.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	private static final String CUSTOMER_MAPPING = "/customers";
	private static final String REGISTER_FORM_MAPPING = "/registerCustomer";
	private static final String DELETE_CUSTOMER_MAPPING = "/deleteCustomer";
	private static final String CUSTOMER_VIEW = "/home";
	
	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping(value = CUSTOMER_MAPPING, method = RequestMethod.GET)
	public ModelAndView getCustomerPage() {
		ModelAndView mv = new ModelAndView("customers");
		List<Customer> customers = customerDAO.getAll();
		mv.addObject("customers", customers);
		return mv;
	}
	
	@RequestMapping(value = REGISTER_FORM_MAPPING)
	public String registerCustomer(@ModelAttribute(value = "customer") @Valid Customer customer) {
		customerDAO.insert(customer);
		return CUSTOMER_VIEW;
	}
	
	@RequestMapping(value = DELETE_CUSTOMER_MAPPING, method = RequestMethod.GET)
	public String getDeleteCustomer(@RequestParam(value = "email") String email) {
		customerDAO.delete(email);
		return CUSTOMER_VIEW;
	}
}
