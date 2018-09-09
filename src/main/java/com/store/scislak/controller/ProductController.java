package com.store.scislak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.scislak.auth.ClientDetails;
import com.store.scislak.auth.ClientDetails.UserStatus;
import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.dataBase.SaveableDataBase;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.Reserve;
import com.store.scislak.encje.Product;

@Controller
public class ProductController {

	@Autowired
	private ReadableDataBase readableDataBase;
	
	@Autowired 
	private SaveableDataBase saveableDataBase;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listOfProducts(Model model) {
		model.addAttribute("products", readableDataBase.readAll("Product"));
		
		if(ClientDetails.getUserStatus() == UserStatus.ADMIN)
			model.addAttribute("admin", true);
		else
			model.addAttribute("admin", false);
		
		return "productsView";
	}
	
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public String listOfProductsAdded(@RequestParam("count") int count, @RequestParam("index") int index) {
		Client client = (Client) readableDataBase.read(ClientDetails.getUserId(), "Client");
		Product product = (Product) readableDataBase.read(index, "Product");
		Reserve order = new Reserve();
		
		order.setClient(client);
		order.setProduct(product);
		order.setCount(count);
		
		saveableDataBase.save(order);
		
		return "redirect:/products";
	}
}
