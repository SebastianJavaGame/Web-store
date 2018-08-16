package com.store.scislak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.scislak.encje.Client;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "login";
 	}
	
	@RequestMapping(value="/sing", method = RequestMethod.GET)
	public String getSingUpForm(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		
		return "sing";
	}
	
	@RequestMapping(value="/sing", method = RequestMethod.POST)
	public String processSingUpForm(@ModelAttribute("client") Client client) {
		System.out.println(client.getAddress());
		System.out.println(client.getEmail());
		System.out.println(client.getName());
		System.out.println(client.getLast_name());
		System.out.println(client.getPostcode());
		
		return "redirect:/login";
	}
}
