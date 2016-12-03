package org.cintia.cbottle.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final String LOGIN_MAPPING = "/login";
	private static final String LOGIN_VIEW = "login";

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
}
