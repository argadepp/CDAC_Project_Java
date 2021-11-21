package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;;

@Entity
@Table(name="BillDetails")
public class BillDetails {

	@Id
	private int Id;
	@Column
	private int Connection_Id;
	//@Column
	//private int Call_Id;
	//@Column
	//private int Sms_Id;
	@Column
	private double Charges;
	
	public BillDetails() {
		// TODO Auto-generated constructor stub
	}

	public BillDetails(int id, int connection_Id,int callId, double charges) {
		super();
		Id = id;
		Connection_Id = connection_Id;
		//Call_Id = callId;
		Charges = charges;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getConnection_Id() {
		return Connection_Id;
	}

	public void setConnection_Id(int connection_Id) {
		Connection_Id = connection_Id;
	}

	/*public int getCall_Id() {
		return Call_Id;
	}

	public void setSms_Id(int sms_Id) {
		Sms_Id = sms_Id;
	}*/
	/*
	public int getSms_Id() {
		return Sms_Id;
	}
	
	public void setCall_Id(int call_Id) {
		Call_Id = call_Id;
	}*/

	public double getCharges() {
		return Charges;
	}

	public void setCharges(double charges) {
		Charges = charges;
	}

	@Override
	public String toString() {
		return "BillDetails [Id=" + Id + ", Connection_Id=" + Connection_Id + " Charges="
				+ Charges + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
