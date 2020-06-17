package com.demo.palweb.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.palweb.repository.UserRepository;
import com.demo.palweb.entity.UserEntity;
import com.demo.palweb.model.UserModel;

@Service
public class SignInUser {
	
	@Autowired
	UserRepository userRepository;
	

	
	@Bean
	public PasswordEncoder passwordEncoder1(){
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	return encoder;
		}
	
	public Integer addUser(UserModel user) {
		
		Integer id=null;
//		return 10400;
		
		if(userRepository.findByUserEmail(user.getUserName())== null  && userRepository.findByUserMobile(user.getMobileNo()) == null) {
			
		UserEntity userEntity=new UserEntity();
		userEntity.setUserName(user.getUserName());
		userEntity.setUserEmail(user.getUserEmail());
		userEntity.setUserPassword(passwordEncoder1().encode(user.getUserPassword()));
		userEntity.setUserMobile(user.getMobileNo());
		userEntity.setUserDOB(user.getDateOfBirth());
		userEntity.setUser_role("user");
		userEntity.setEnable(1);
		UserEntity user2= userRepository.save(userEntity);
		id= user2.getUserId();
		
	}
//	 return some error based on validation
		return id;
	}
	
	
	public UserModel getUser(String userEmail) {
		UserEntity userEntity=new UserEntity();
		userEntity=userRepository.findByUserEmail(userEmail);
		if(userEntity != null) {
			return entityToModel(userEntity);
		}
		return null;
	}
	
	public UserModel getUserById(Integer userId) {
		UserEntity userEntity=new UserEntity();
		userEntity=userRepository.findByUserId(userId);
		if(userEntity != null) {
			return entityToModel(userEntity);
		}
		return null;
	}
	
	
	public UserEntity modelToEntity(UserModel model) {
		
		if(model!=null && model.getUserEmail().length()>0) {
			UserEntity entity=new UserEntity();
			entity.setUserName(model.getUserName());
			entity.setUserEmail(model.getUserEmail());
			entity.setUserPassword(model.getUserPassword());
			entity.setUserMobile(model.getMobileNo());
			entity.setUserId(model.getUserId());
			entity.setUser_role(model.getUserRole());
			entity.setUserDOB(model.getDateOfBirth());
			return entity;
		}
		return null;
	}
	
	
	public UserModel entityToModel(UserEntity user1) {
		if(user1 != null && user1.getUserEmail().length()>0  ) {
			SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
			
			UserModel model=new UserModel();
			model.setUserName(user1.getUserName());
			model.setUserEmail(user1.getUserEmail());
//			model.setUserPassword(user1.getUserPassword());
//			
			String dateString = sdfr.format( user1.getUserDOB() );
			model.setMobileNo(user1.getUserMobile());
			model.setDateOfBirth(user1.getUserDOB());
//			model.setUserRole(user1.getUser_role());
//			model.setUserId(user1.getUserId());
			return model;
			
			
		}
		return null;
	
	}
	
}
