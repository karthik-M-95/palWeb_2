package com.demo.palweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loggedController {

	@GetMapping(value="/AboutUs")
	public String aboutUs() {
		System.out.println("");
		return "preFiles/fp";
	}
	
	@GetMapping(value="/ContactUs")
	public String contactUs() {
		
		return "preFiles/sp";
	}
	
	
	// pages after logging In
	@GetMapping(value="/Contactus")
	public String contactUsLog() {
		
		return "logInFiles/contactUs1";
	}
	
	// pages after logging In
	@GetMapping(value="/Aboutus")
	public String AboutUsLog() {
		
		return "logInFiles/aboutUs1";
	}
	
}
