package com.store.scislak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.scislak.auth.ClientDetails;
import com.store.scislak.auth.UserDetails;
import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.Reserve;

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
		model.addAttribute("clients", readableDataBase.readAll("Client"));
		return "clientsView";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/clientHome")
	public String clientHome(Model model) {
		userDetails.init();
		String userName = userDetails.getUserName();
		Client client = (Client) readableDataBase.readClient(userName, "Client");
		client.setName(client.getName() + " " + client.getLast_name());
		ClientDetails.setUserId(client.getId());
		
		List<Object> objects = readableDataBase.readList(ClientDetails.getUserId(), "client_id", "Reserve");
		List<Reserve> orders = new ArrayList<Reserve>();
		for(Object obj: objects) {
			orders.add((Reserve)obj);
		}
		
		System.out.println(orders.size());
		
		model.addAttribute("orders", orders);
		model.addAttribute("client", client);
		
		return "clientHome";
	}
}
