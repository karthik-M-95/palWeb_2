package com.demo.palweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(schema="pal_demo1", name="user_table")
@SequenceGenerator(name="seq", initialValue=100003, allocationSize=1)
public class UserEntity {
//Generate the Id 
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")	
	@Id
	@Column(name="user_id",unique = true,nullable=false)
	private Integer userId;
	
	@Column(name="user_name", nullable=false)
	private String userName;
	
	@Column(name="user_email",nullable=false)
	private String userEmail;
	@Column(name="user_password",nullable=false)
	private String UserPassword;
	@Column(name="user_mobile",nullable=false)
	private String userMobile;
	@Column(name="user_dob",nullable=false)
	private Date userDOB;
	@Column(name="user_role")
	private String user_role;

	@Column(name="enable")
	private Integer enable;


	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", UserPassword=" + UserPassword + ", userMobile=" + userMobile + ", userDOB=" + userDOB
				+ ", user_role=" + user_role + ", enable=" + enable + "]";
	}


	
	
	
	
	

}
