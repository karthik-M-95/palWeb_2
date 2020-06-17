package com.demo.palweb.controller;

import java.util.Date;



import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.palweb.model.UserModel;
import com.demo.palweb.service.SignInUser;

@Controller
@RequestMapping("/user")
public class SignInController {

	@Autowired
	SignInUser userService;
	
	@GetMapping(value="/loginError")
	public ResponseEntity<String> loginError(){
	
				System.out.println("ur in loginError controller");
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/addUser")
	public String addUser( @RequestParam("uname11") String username, @RequestParam("email11") String userEmail, @RequestParam("psw11") String userPassword,
			@RequestParam("psw-repeat11") String passCheck,@RequestParam("dob") String userdob, @RequestParam("mob1") Long mobNo) {
		
		RestTemplate restTemplate= new RestTemplate(); 
		System.out.println("hello got the user");
		System.out.println(username);
		System.out.println(userEmail);
		System.out.println(userPassword);
		System.out.println(passCheck);
		System.out.println(userdob);
		System.out.println(mobNo);
		
		
		
		return "login";
	}
	
	@GetMapping(value="/getUser", produces="application/json")
	public com.demo.palweb.model.UserModel getUser() {
		
		
		return null;
//		userService.find
	}
	
	
	@PostMapping(value="/addNewUser", consumes="application/json")
	public ResponseEntity<?> addnewUser(@RequestBody UserModel user) {
		
		Integer id= userService.addUser(user);
//		Integer id= null;
		System.out.println("Hello new user object");
		System.out.println(user);
		System.out.println(user.getUserName());
		System.out.println(user.getUserEmail());
		System.out.println(user.getUserPassword());
		System.out.println(user.getMobileNo());
		System.out.println(user.getDateOfBirth()); 
//		
//		Integer id= userService.addUser(user);
		user.setUserId(id);
		if(id!=null) {
			 return new ResponseEntity<UserModel>(user, HttpStatus.OK);
				}else {
				return new ResponseEntity<String>("Some error", HttpStatus.BAD_REQUEST);
				}
//	
	}
	
}
