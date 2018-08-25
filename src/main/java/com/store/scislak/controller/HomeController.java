package com.store.scislak.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/clients")
	public String list(Model model) {
		model.addAttribute("clients", readableDataBase.read());
		return "clientsView";
	}
	
	@RequestMapping(value="/clientHome")
	public String clientHome(Model model) {
		userDetails.init();
		String userName = userDetails.getUserName();
		Client client = readableDataBase.readClient(userName);
		client.setName(client.getName() + " " + client.getLast_name());
		
		model.addAttribute("client", client);
		
		return "clientHome";
	}
	
}
