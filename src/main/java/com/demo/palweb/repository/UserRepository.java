package com.demo.palweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.palweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	public UserEntity findByUserEmail(String email);
	public UserEntity findByUserMobile(String mobile);
	public UserEntity findByUserId(Integer id);
	

}

