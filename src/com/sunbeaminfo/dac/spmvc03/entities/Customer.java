package com.sunbeaminfo.dac.spmvc03.entities;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	private int Customer_Id;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private String Address;
	@Column
	private String Mobile_No;
	@Column
	private String Password;
	@OneToMany(mappedBy="Customer_Id", fetch=FetchType.EAGER) 
	private List<Connection> conList;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_Id, String name, String email, String address, String mobile_No, String password,
			List<Connection> conList) {
		super();
		Customer_Id = customer_Id;
		Name = name;
		Email = email;
		Address = address;
		Mobile_No= mobile_No;
		Password = password;
		this.conList = conList;
	}

	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile_No() {
		return Mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Connection> getConList() {
		return conList;
	}

	public void setConList(List<Connection> conList) {
		this.conList = conList;
	}

	@Override
	public String toString() {
		return "Customer [Customer_Id=" + Customer_Id + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address
				+ ", Mobile_Id=" + Mobile_No + ", Password=" + Password + "]";
	}
	
	
	
	
	
	
	
}
