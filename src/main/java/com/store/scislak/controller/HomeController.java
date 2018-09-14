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
import com.store.scislak.dataBase.impl.ReadExtraDate;
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
	
	//@Autowired
	//private ReadExtraDate readExtraDate;
	
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
		
		model.addAttribute("totalCount", (int)total(orders)[0]);
		model.addAttribute("totalPrice", String.format("%.2f", total(orders)[1]));
		model.addAttribute("orders", orders);
		model.addAttribute("client", client);
		
		return "clientHome";
	}
	
	@SuppressWarnings("unused")
	private double[] total(List<Reserve> orders) {
		double[] result = new double[2];
		
		for(int index = orders.size()-1; index >= 0; index--) {
			result[0]+= orders.get(index).getCount();
			result[1]+= (orders.get(index).getProduct().getBrutto() * orders.get(index).getCount());
		}
		return result;
	}
}
