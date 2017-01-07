package org.cintia.cbottle.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BottleController {
	
	public ModelAndView getAll() {
		
	}
	
	public String addBottle(@ModelAttribute @Valid BottleQuery bottle) {
		
	}
}
