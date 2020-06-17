package com.demo.palweb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.demo.palweb.dao.PersistentTokenRepositoryImpl;
import com.demo.palweb.service.MyUserDetails;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private MyUserDetails userDetailsService;
	
	@Autowired
	PersistentTokenRepositoryImpl tokenRepo;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		}
	
	

//	@Bean 	
//	public AuthenticationProvider authProvider(){
//		
//		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userDetailsService);
//		auth.setPasswordEncoder(passwordEncoder());
//		return auth;
//		
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
//	 auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(NoOpPasswordEncoder.getInstance())
//		.usersByUsernameQuery("select user_email,user_password,enable from user_table where username=?")
//		.authoritiesByUsernameQuery("select user_email, user_role from user_table where username=?");		
		
}
	
	
	private PasswordEncoder NoOpPasswordEncoder() {	
		// TODO Auto-generated method stub
		return null;
	}

	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable();
		
		http
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers("/AboutUs").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/ContactUs").permitAll()
		.antMatchers("/Login").permitAll()
		.antMatchers("/user/loginError").permitAll()
		.antMatchers("/user/addNewUser").permitAll()
		.antMatchers("/forgotPassword").permitAll()
		.antMatchers("/css/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/Login").permitAll()
		.usernameParameter("username").passwordParameter("password")
		.loginProcessingUrl("/LoginUser")
//		.successForwardUrl("/LoginUser")
		.defaultSuccessUrl("/Home",true)
		.failureUrl("/user/loginError").permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessDenied")
		.and()
	    .rememberMe().rememberMeParameter("rememberMe").tokenRepository(tokenRepo).tokenValiditySeconds(86400)
		.and()
		.logout().logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID")
		//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home").permitAll();
	}
	
	
	 @Bean
	  public PersistentTokenRepository tokenRepository() {
	    JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
	    jdbcTokenRepositoryImpl.setDataSource(dataSource);
	    System.out.println(jdbcTokenRepositoryImpl);
	    return jdbcTokenRepositoryImpl;
	  }
	
}


//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		String encoded = encoder.encode("Password");
//		System.out.println("encoded::: "+encoded);
//		
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
//        .usersByUsernameQuery(
//    			"select username,password,enabled from users where username=?")
//    		.authoritiesByUsernameQuery(
//    			"select username, role from user_roles where username=?");       
//	}
