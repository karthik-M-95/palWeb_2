package com.demo.palweb.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.demo.palweb.model.UserModel;
import com.demo.palweb.service.SignInUser;

@RestController
public class UserController {

	@Autowired
	private SignInUser userService;
	
	//login default
	@GetMapping(value="/Home")
	public ModelAndView defaultLoginSuccess(HttpServletResponse response, Authentication authentication, HttpServletRequest request) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		System.out.println("User has authorities: " + userDetails.getUsername());
		String email=userDetails.getUsername();
		UserModel userModel=userService.getUser(email);
		
		Cookie cookie = new Cookie("_sathdh12",userModel.getUserEmail() );
		cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//		cookie.setSecure(true);			only for https secure line
		cookie.setHttpOnly(true);
		cookie.setPath("/pal1");
//		cookie.setDomain("/pal1");
		response.addCookie(cookie);
	
		HttpSession session = request.getSession();
		session.setAttribute("userId1", userModel.getUserId());
		
		ModelAndView model=new ModelAndView();
		model.setViewName("logInFiles/suc124");
		return model;
	}
	
	@GetMapping(value="/profile")
	public ModelAndView viewProfile(HttpServletRequest request) {
			
		ModelAndView model=new ModelAndView();
		model.setViewName("logInFiles/profile");
		return model;
	}
	
	@GetMapping(value="/getProfile", produces="application/json")
	public UserModel getProfile(HttpServletRequest request) {
		
		UserModel user= new UserModel();
		Cookie name = WebUtils.getCookie(request, "_sathdh12");
		String email= name.getValue();
		if(email == null)
			System.out.println("user not found");
		user=userService.getUser(email);
		return user;
		
	}
}
