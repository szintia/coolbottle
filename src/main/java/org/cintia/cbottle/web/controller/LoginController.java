package org.cintia.cbottle.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final String LOGIN_MAPPING = "/login";
	private static final String LOGIN_VIEW = "login";
	private static final String ROLE_MAPPING = "/roleIndex";
	private static final String HOME_VIEW = "home";
	private static final String ADMIN_VIEW = "admin/home";

	@RequestMapping(value = LOGIN_MAPPING, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		if (error != null) {
			model.addObject("error", "Invalid username and/or password!");
		} else if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		return model;
	}
	
	@RequestMapping(value = ROLE_MAPPING, method = RequestMethod.GET)
	public String roleBaseRedirection(HttpServletRequest request, HttpServletResponse response) {
		String url = HOME_VIEW;
		//other case is the "ROLE_USER"
		if (request.isUserInRole("ROLE_ADMIN")) {
			url = ADMIN_VIEW;
		}
		return "redirect:/" + url;
	}
}
