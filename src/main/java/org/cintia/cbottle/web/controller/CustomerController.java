package org.cintia.cbottle.web.controller;

import java.util.List;

import org.cintia.cbottle.web.database.dao.CustomerDAO;
import org.cintia.cbottle.web.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView getCustomerPage() {
		ModelAndView mv = new ModelAndView("customers");
		List<Customer> customers = customerDAO.getAll();
		mv.addObject("customers", customers);
		return mv;
	}

}
