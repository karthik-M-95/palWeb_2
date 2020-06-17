package com.demo.palweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.palweb.entity.RememberMeTokens;

@Repository
public interface RememberTokenRepository extends JpaRepository<RememberMeTokens, String>{

	
	public RememberMeTokens findBySeries(String series);
	public List<RememberMeTokens> findByUsername(String userName);
	
	
	
}
