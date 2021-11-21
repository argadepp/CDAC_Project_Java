package com.sunbeaminfo.dac.spmvc03.entities;

import java.io.Serializable;

public class User implements Serializable {
public String email;
public String password;
public String id;
public User() {
	// TODO Auto-generated constructor stub
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [email=" + email + ", password=" + password + "]";
}

public void setId(String id) {
	this.id = id;
}


public String getId() {
	return id;
}
public User(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
}
