package com.sunbeaminfo.dac.spmvc03.entities;

import java.io.Serializable;

public class Login implements Serializable {

	public int id;
	public int password;
	 
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(int id, int password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + "]";
	}
	
	
	
	
	
}
