package com.store.scislak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.scislak.dataBase.SaveableDataBase;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.LoginDate;

@Controller
public class LoginController {

	@Autowired
	public SaveableDataBase saveableDataBase;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/login";
	}
	
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
		LoginDate loginDate = new LoginDate();
		
		client.setLoginDate(loginDate);
		model.addAttribute("client", client);
		
		return "sing";
	}
	
	@RequestMapping(value="/sing", method = RequestMethod.POST)
	public String processSingUpForm(@ModelAttribute("client") @Valid Client client, BindingResult result) {
		if(result.hasErrors())
			return "sing";
		
		client.getLoginDate().setAccess("USER");
		client.getLoginDate().setEmail(client.getEmail());
		
		saveableDataBase.save(client);
		
		return "redirect:/login";
	}
}
