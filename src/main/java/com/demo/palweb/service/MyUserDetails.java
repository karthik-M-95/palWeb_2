package com.demo.palweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.palweb.entity.UserEntity;
import com.demo.palweb.repository.UserRepository;

@Service
public class MyUserDetails implements UserDetailsService {

	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user= userRepo.findByUserEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("No user found with username: "+ username);
		}
		// TODO Auto-generated method stub
		 return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), 
	             true, true, true, true, getGrantedAuthorities(user));

//		 return new UserDetailsImpl(user);
	
	}
	
	 private List<GrantedAuthority> getGrantedAuthorities(UserEntity user){
		    List<GrantedAuthority> authorities = new ArrayList<>();

		    authorities.add(new SimpleGrantedAuthority("user"));
		    authorities.add(new SimpleGrantedAuthority("admin"));

		    System.out.print("authorities :"+authorities);
		    return authorities;
		
}
}
