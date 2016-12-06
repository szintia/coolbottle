package org.cintia.cbottle.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private static final String HOME_MAPPING = "/home";
	private static final String HOME_VIEW = "home";
	private static final String ROOT_MAPPING = "/";
	
	@RequestMapping(value = HOME_MAPPING, method = RequestMethod.GET)
	public String getHomePage(Model model, HttpServletRequest request) {
		Principal user = request.getUserPrincipal();
		if(user != null) {
			model.addAttribute("customerName", user.getName());
		}
		return HOME_VIEW;
	}
	
	@RequestMapping(value = ROOT_MAPPING, method = RequestMethod.GET)
	public String root() {
		return HOME_VIEW; 
	}
}
