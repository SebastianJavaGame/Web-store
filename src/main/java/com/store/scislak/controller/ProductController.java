package com.store.scislak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.scislak.auth.ClientDetails;
import com.store.scislak.auth.ClientDetails.UserStatus;
import com.store.scislak.dataBase.ReadableDataBase;

@Controller
public class ProductController {

	@Autowired
	private ReadableDataBase readableDataBase;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listAdmin(Model model) {
		model.addAttribute("products", readableDataBase.read("Product"));
		
		if(ClientDetails.getUserStatus() == UserStatus.ADMIN)
			model.addAttribute("admin", true);
		else
			model.addAttribute("admin", false);
		
		return "productsView";
	}
}
