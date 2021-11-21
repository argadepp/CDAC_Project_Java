package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Bill_Details")
public class Bill_Details {

	@GenericGenerator(name = "gen", strategy = "native")
	@GeneratedValue(generator = "gen")
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="Connetion_Id")
	private int connection_Id;
	@Column(name="Call_Id")
	private int call_Id;
	@Column(name="Charges")
	private double charges;
	
	
	
	
	
	public Bill_Details() {
		super();
	}





	public Bill_Details(int id, int customer_Id, int connection_Id, int call_Id, double charges) {
		super();
		this.id = id;
		
		this.connection_Id = connection_Id;
		this.call_Id = call_Id;
		this.charges = charges;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}









	public int getConnection_Id() {
		return connection_Id;
	}





	public void setConnection_Id(int connection_Id) {
		this.connection_Id = connection_Id;
	}





	public int getCall_Id() {
		return call_Id;
	}


	public void setCall_Id(int call_Id) {
		this.call_Id = call_Id;
	}


	public double getCharges() {
		return charges;
	}


	public void setCharges(double charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Bill_Details [id=" + id  + ", connection_Id=" + connection_Id
				+ ", call_Id=" + call_Id + ", charges=" + charges + "]";
	}
	
	
	
	
	
	
}
