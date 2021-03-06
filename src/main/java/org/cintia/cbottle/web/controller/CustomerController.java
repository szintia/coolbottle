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
	private static final String REGISTER_FORM_VIEW = "registration";
	private static final String REGISTER_FORM_MAPPING = "registrationForm";
	private static final String REGISTER_MAPPING = "/registerCustomer";
	private static final String DELETE_CUSTOMER_MAPPING = "/deleteCustomer";
	private static final String CUSTOMER_VIEW = "/home";
	private static final String ADMIN_HOME_MAPPING = "/admin/home";
	private static final String ADMIN_HOME_VIEW = "admin/home";
	
	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping(value = CUSTOMER_MAPPING, method = RequestMethod.GET)
	public ModelAndView getCustomerPage() {
		ModelAndView mv = new ModelAndView("customers");
		List<Customer> customers = customerDAO.getAll();
		mv.addObject("customers", customers);
		return mv;
	}
	
	@RequestMapping(value = ADMIN_HOME_MAPPING, method = RequestMethod.GET)
	public String getAdminHome() {
		return ADMIN_HOME_VIEW;
	}
	
	@RequestMapping(value = REGISTER_FORM_MAPPING, method = RequestMethod.GET)
	public String getRegistrationForm() {
		return REGISTER_FORM_VIEW;
	}
	
	@RequestMapping(value = REGISTER_MAPPING, method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute(value = "customer") @Valid Customer customer) {
		customerDAO.insert(customer);
		return CUSTOMER_VIEW;
	}
	
	@RequestMapping(value = DELETE_CUSTOMER_MAPPING, method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value = "email") String email) {
		customerDAO.delete(email);
		return CUSTOMER_VIEW;
	}
}
