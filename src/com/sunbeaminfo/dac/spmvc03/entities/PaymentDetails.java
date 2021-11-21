package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaymentDetails {

	@Id
	private int Payment_Id;
@Column
    private float Ammount;
	
	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}


	public PaymentDetails(int payment_Id, float ammount) {
		super();
		Payment_Id = payment_Id;
	//	Bill_Id = bill_Id;
		Ammount = ammount;
	}


	public int getPayment_Id() {
		return Payment_Id;
	}


	public void setPayment_Id(int payment_Id) {
		Payment_Id = payment_Id;
	}



	public float getAmmount() {
		return Ammount;
	}


	public void setAmmount(float ammount) {
		Ammount = ammount;
	}


	@Override
	public String toString() {
		return "PaymentDetails [Payment_Id=" + Payment_Id +  ", Ammount=" + Ammount + "]";
	}
	
	
	
	
}
