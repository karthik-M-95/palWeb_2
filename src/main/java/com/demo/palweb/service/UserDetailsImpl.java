//package com.demo.palweb.service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.demo.palweb.entity.UserEntity;
//
//public class UserDetailsImpl implements UserDetails {
//	
//	private UserEntity user;
//	
//	public UserDetailsImpl(UserEntity user) {
//		super();
//		this.user=user;
//		
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		
//		 List<GrantedAuthority> authorities = new ArrayList<>();
//
//		    authorities.add(new SimpleGrantedAuthority("user"));
////		    authorities.add(new SimpleGrantedAuthority("admin"));
//
//		    System.out.print("authorities :"+authorities);
//		    return authorities;
////		return Collections.singleton(new SimpleGrantedAuthority("user"));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getUserPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getUserEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		System.out.println(("user enable="+ user.getEnable()));
//		if(user.getEnable()==1)
//			return true;
//		return false;
//	}
//
//}
