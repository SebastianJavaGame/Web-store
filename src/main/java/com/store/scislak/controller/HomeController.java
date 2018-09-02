package com.store.scislak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.scislak.auth.UserDetails;
import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ReadableDataBase readableDataBase;
	
	@Autowired 
	private UserDetails userDetails;
	
	@RequestMapping(value="/clients")
	public String list(Model model) {
		model.addAttribute("clients", readableDataBase.read("Client"));
		return "clientsView";
	}
	
	@RequestMapping(value="/clientHome")
	public String clientHome(Model model) {
		userDetails.init();
		String userName = userDetails.getUserName();
		Client client = (Client) readableDataBase.readClient(userName, "Client");
		client.setName(client.getName() + " " + client.getLast_name());
		
		model.addAttribute("client", client);
		
		return "clientHome";
	}
}
