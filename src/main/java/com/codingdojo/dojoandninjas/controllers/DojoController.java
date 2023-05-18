package com.codingdojo.dojoandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dService;

	@GetMapping("/")
	public String rDojos(Model model) {
		List<Dojo> dojos = dService.allItems();
	    model.addAttribute("dojos", dojos);
		return "dojos.jsp";
	}
	
	@GetMapping("/home/{id}")
	public String rFullDojo(@PathVariable("id") Long id, Model model) {
			model.addAttribute("dojo", dService.findDojoById(id));
		return "home.jsp";
	}

	@GetMapping("/createDojo")
	public String rCreateDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {

		return "newDojo.jsp";
	}

	@PostMapping("/createDojo")
	public String pCreateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult results, Model model) {

		if (results.hasErrors()) {
			model.addAttribute("BindingResult", results);
			return "newDojo.jsp";
		} else {
			
			dService.createOrUpdate(dojo);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		dService.deleteItem(id);
		return "redirect:/";
	}

}
