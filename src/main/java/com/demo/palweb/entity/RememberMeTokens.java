package com.demo.palweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

@Entity
@Table(name = "persistent_logins")

public class RememberMeTokens {


@Column(name = "username")
private String username;

@Id
@Column(name = "series")
private String series;

@Column(name = "token")
private String token;

@Column(name = "last_used")
@Temporal(javax.persistence.TemporalType.DATE)
private Date date;

public RememberMeTokens(){
}

public RememberMeTokens(PersistentRememberMeToken token)
{
    this.username = token.getUsername();
    this.series = token.getSeries();
    this.token = token.getTokenValue();
    this.date = token.getDate();
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getSeries() {
    return series;
}

public void setSeries(String series) {
    this.series = series;
}

public String getToken() {
    return token;
}

public void setToken(String token) {
    this.token = token;
}

public Date getDate() {
    return date;
}

public void setDate(Date date) {
    this.date = date;
}

}
