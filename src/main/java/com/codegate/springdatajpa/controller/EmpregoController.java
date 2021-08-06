package com.codegate.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegate.springdatajpa.model.Emprego;
import com.codegate.springdatajpa.repository.EmpregoRepository;

@Controller
public class EmpregoController {
	
	@Autowired
	EmpregoRepository empregoRepository;
	
	
	
	@RequestMapping("/")
	public String listaEmpregos(Model model) {
		model.addAttribute("empregos",empregoRepository.findAll());
		return "lista";		
	}
	
	@GetMapping("/add")
	public String empregoForm(Model model) {
		model.addAttribute("emprego", new Emprego());
		return "empregoForm";
	}
	
	@PostMapping("/process")
	public String processForm(@Validated Emprego emprego, BindingResult result) {
		if (result.hasErrors()) {
			return "empregoForm";
		}
		empregoRepository.save(emprego);
		return "redirect:/";
	}
		


}
