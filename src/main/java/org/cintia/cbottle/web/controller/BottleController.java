package org.cintia.cbottle.web.controller;

import javax.validation.Valid;

import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.domain.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BottleController {
	
	private static final String BOTTLES_MAPPING = "/bottles";
	private static final String BOTTLES_VIEW = "bottles";
	
	@Autowired
	DataAccess<Bottle> bottleDAO;
	
	@RequestMapping(value = BOTTLES_MAPPING, method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView(BOTTLES_VIEW);
		mv.addObject("bottles", bottleDAO.getAll());
		return mv;
	}
	
	@RequestMapping(value = BOTTLES_MAPPING, method = RequestMethod.GET)
	public String addBottle(@ModelAttribute @Valid Bottle bottle) {
		bottleDAO.insert(bottle);
		return "redirect:/" + BOTTLES_VIEW;
	}
}
