package com.sunbeaminfo.dac.spmvc03.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Customer")
public class Customer_Details {
	
	@GenericGenerator(name = "gen", strategy = "native")
	@GeneratedValue(generator = "gen")
	@Id
	@Column(name="Customer_Id")
	private int Customer_Id;
	@Column(name="Name")
	private String Name ;
	@Column(name="Email")
	private String Email;
	@Column(name="Address")
	private String Address;
	@Column(name="Mobile_No")
	private String Mobile_No ;
	@Column(name="Password")
	private String Password ;
	
	@OneToMany(mappedBy="Connection_Id",fetch=FetchType.EAGER,cascade={CascadeType.PERSIST})
	private List<Connection> connectionList;
	
	
	public Customer_Details() {
		//super();
		this(0,"","","","","");
	}


	public Customer_Details(int customer_Id, String name, String email, String address, String mobile_No,
			String password) {
		//super();
		Customer_Id = customer_Id;
		Name = name;
		Email = email;
		Address = address;
		Mobile_No = mobile_No;
		Password = password;
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
	//return the list of connection 
	public List<Connection> getConnectionList()
	{
		return connectionList;
	}
	
	
	public void setConnectionList(List<Connection> list)
	{
      this.connectionList=list;		
	}
	
	@Override
	public String toString() {
		return "Customer_Details [Customer_Id=" + Customer_Id + ", Name=" + Name + ", Email=" + Email + ", Address="
				+ Address + ", Mobile_No=" + Mobile_No + ", Password=" + Password + "]";
	}

	
	

}
