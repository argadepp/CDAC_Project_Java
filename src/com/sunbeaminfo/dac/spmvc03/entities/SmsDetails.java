package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SmsDetails")
public class SmsDetails {

	@Id
	private int Sms_Id;
	@Column
	private int Connection_Id;
	@Column
	private int SmsMadeNo;
	@Column
	private double Charges;
	
	public SmsDetails() {
		// TODO Auto-generated constructor stub
	}

	public SmsDetails(int sms_Id, int connection_Id, int smsMadeNo, double charges) {
		super();
		Sms_Id = sms_Id;
		Connection_Id = connection_Id;
		SmsMadeNo = smsMadeNo;
		Charges = charges;
	}

	public int getSms_Id() {
		return Sms_Id;
	}

	public void setSms_Id(int sms_Id) {
		Sms_Id = sms_Id;
	}

	public int getConnection_Id() {
		return Connection_Id;
	}

	public void setConnection_Id(int connection_Id) {
		Connection_Id = connection_Id;
	}

	public int getSmsMadeNo() {
		return SmsMadeNo;
	}

	public void setSmsMadeNo(int smsMadeNo) {
		SmsMadeNo = smsMadeNo;
	}

	public double getCharges() {
		return Charges;
	}

	public void setCharges(double charges) {
		Charges = charges;
	}

	@Override
	public String toString() {
		return "SmsDetails [Sms_Id=" + Sms_Id + ", Connection_Id=" + Connection_Id + ", SmsMadeNo=" + SmsMadeNo
				+ ", Charges=" + Charges + "]";
	}
	
	
	
}
