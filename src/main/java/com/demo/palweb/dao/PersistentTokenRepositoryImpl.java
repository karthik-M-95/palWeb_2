package com.demo.palweb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import com.demo.palweb.entity.RememberMeTokens;
import com.demo.palweb.repository.RememberTokenRepository;


@Repository
public class PersistentTokenRepositoryImpl implements PersistentTokenRepository{

	
	
	@Autowired
	private RememberTokenRepository rememberMeTokenRepository;
	
	

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		
		System.out.println("Inside the create PersistentTokenRepository");
		
		List<RememberMeTokens > token1 = this.rememberMeTokenRepository.findByUsername(token.getUsername());
		
	    if(token1.size() < 1 ) {
	    RememberMeTokens newToken = new RememberMeTokens(token);
	    this.rememberMeTokenRepository.save(newToken);
	    }
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {

		System.out.println("Inside the update PersistentTokenRepository");
	    RememberMeTokens token = this.rememberMeTokenRepository.findBySeries(series);
	    if(token != null)
	    {
	        token.setToken(tokenValue);
	        token.setDate(lastUsed);
	    }
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String series) {

		System.out.println("Inside the getToken PersistentTokenRepository");
	    RememberMeTokens token = this.rememberMeTokenRepository.findBySeries(series);
	    return new PersistentRememberMeToken(token.getUsername(),token.getSeries(),token.getToken(),token.getDate());        
	}

	@Override
	public void removeUserTokens(String username) {
		
		System.out.println("Inside the remove PersistentTokenRepository");
	    Iterable<RememberMeTokens> tokens = this.rememberMeTokenRepository.findByUsername(username);
	    this.rememberMeTokenRepository.deleteAll(tokens); 
	    
	}

	
	
}
