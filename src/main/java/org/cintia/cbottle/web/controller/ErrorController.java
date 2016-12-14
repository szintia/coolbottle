package org.cintia.cbottle.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	private static final String ACCESS_DENIED_VIEW = "error/403";
	private static final String ACCESS_DENIED_MAPPING = "/403";
	private static final String PAGE_NOT_FOUND_VIEW = "error/404";
	private static final String PAGE_NOT_FOUND_MAPPING = "/404";

	@RequestMapping(value = ACCESS_DENIED_MAPPING, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView(ACCESS_DENIED_VIEW);
		
		Authentication authenticatedPrincipal = SecurityContextHolder.getContext().getAuthentication();
		
		//null check is not is not needed, if auth is null instanceof returns false
		if(!(authenticatedPrincipal instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) authenticatedPrincipal.getPrincipal();
			mv.addObject("username", userDetail.getUsername());
		}
		return mv;
	}
	
	@RequestMapping(value = PAGE_NOT_FOUND_MAPPING, method = RequestMethod.GET)
	public String pageNotFound() {
		return PAGE_NOT_FOUND_VIEW;
	}
}
