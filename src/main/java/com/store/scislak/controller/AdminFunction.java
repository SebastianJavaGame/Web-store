package com.store.scislak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.scislak.auth.UserDetails;
import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.dataBase.SaveableDataBase;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.Product;

@Controller
public class AdminFunction{
	
	@Autowired
	private ReadableDataBase readableDataBase;
	
	@Autowired 
	private UserDetails userDetails;
	
	@Autowired
	public SaveableDataBase saveableDataBase;
	
	@RequestMapping(value="/adminHome", method=RequestMethod.GET)
	public String getAddProduct(Model model) {
		userDetails.init();
		String userName = userDetails.getUserName();
		Client client = (Client) readableDataBase.readClient(userName, "Client");
		client.setName(client.getName() + " " + client.getLast_name());
		
		Product product = new Product();
		
		model.addAttribute("client", client);
		model.addAttribute("product", product);
		return "adminHome";
	}
	
	@RequestMapping(value="/adminHome", method=RequestMethod.POST)
	public String proccessAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		if(result.hasErrors())
			return "adminHome";
		
		saveableDataBase.save(product);
		
		return "redirect:/login";
	}
}
