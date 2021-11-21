package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="Addmin")
public class Addmin {

	@Id
	@Column
	private int id;

	@Column
	private int password;
	
	public Addmin() {
		// TODO Auto-generated constructor stub
	}

	public Addmin(int id, String password) {
		super();
		id = id;
		
		password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}



	public int getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}

	@Override
	public String toString() {
		return "AddminDetails [Id=" + id+" Password=" + password + "]";
	}
	
	
	
}
