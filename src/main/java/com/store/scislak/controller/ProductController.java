package com.store.scislak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.scislak.auth.ClientDetails;
import com.store.scislak.auth.ClientDetails.UserStatus;
import com.store.scislak.dataBase.SaveableDataBase;
import com.store.scislak.dataBase.impl.ReadExtraDate;
import com.store.scislak.encje.Category;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.Product;
import com.store.scislak.encje.Reserve;

@Controller
public class ProductController {	
	@Autowired 
	private SaveableDataBase saveableDataBase;
	
	@Autowired
	private ReadExtraDate readCategory;
	
	@Autowired
	private Category category;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listOfProducts(Model model) {		
		addFilters(model);
		model.addAttribute("products", readCategory.readProductWithCategory("Product", ""));
		
		if(ClientDetails.getUserStatus() == UserStatus.ADMIN)
			model.addAttribute("admin", true);
		else
			model.addAttribute("admin", false);
		
		return "productsView";
	}
	
	@RequestMapping(params="addFilter", method = RequestMethod.POST)
	public String filterCategory(Model model, @ModelAttribute("objectCategory") Category category, BindingResult bindingResult) {
		addFilters(model);
		String categoryName = category.getCategory();
		this.category.setCategory(categoryName);
		
		model.addAttribute("products", readCategory.readProductWithCategory("Product", categoryName));
		
		if(ClientDetails.getUserStatus() == UserStatus.ADMIN)
			model.addAttribute("admin", true);
		else
			model.addAttribute("admin", false);
		
		return "productsView";
	}
	
	@RequestMapping(params="addProduct", method = RequestMethod.POST)
	public String listOfProductsAdded(@RequestParam("count") int count, @RequestParam("index") int index) {
		Client client = (Client) readCategory.read(ClientDetails.getUserId(), "Client");
		Product product = (Product) readCategory.read(index, "Product");
		Reserve order = new Reserve();
		
		order.setClient(client);
		order.setProduct(product);
		order.setCount(count);
		
		saveableDataBase.save(order);
		
		return "redirect:/products";
	}
	
	private void addFilters(Model model) {
		model.addAttribute("objectCategory", category);
		
		List<String> list = new ArrayList<String>();
		list.add("Laptop");
		list.add("Hobby");
		list.add("Food");
		model.addAttribute("listOfCategory", list);
	}
}
