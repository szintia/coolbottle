package org.cintia.cbottle.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.cintia.cbottle.web.database.dao.BottleDAO;
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
	BottleDAO bottleDAO;
	
	@RequestMapping(value = BOTTLES_MAPPING, method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView(BOTTLES_VIEW);
		List<Bottle> bottles = bottleDAO.getAll();
		mv.addObject("bottles", bottles);
		return mv;
	}

	@RequestMapping(value = BOTTLES_MAPPING, method = RequestMethod.GET)
	public String addBottle(@ModelAttribute @Valid Bottle bottle) {
		bottleDAO.insert(bottle);
		return "redirect:/" + BOTTLES_VIEW;
	}
}
