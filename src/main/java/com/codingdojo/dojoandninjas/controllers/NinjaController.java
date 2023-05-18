package com.codingdojo.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.DojoService;
import com.codingdojo.dojoandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService nService;
	
	@Autowired
	private DojoService dService;

	@GetMapping("/createNinja")
	public String rCreateNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		
		model.addAttribute("dojos", dService.allItems());
		return "newNinja.jsp";
	}

	@PostMapping("/createNinja")
	public String pCreateDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult results, Model model) {

		if (results.hasErrors()) {
			model.addAttribute("dojos", dService.allItems());
			model.addAttribute("BindingResult", results);
			return "newNinja.jsp";
		} else {
			
			nService.createOrUpdate(ninja);
			return "redirect:/";
		}
	}

}