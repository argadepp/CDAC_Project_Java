package com.sunbeaminfo.dac.spmvc03.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Call_Details")
public class Call_Details {

	

/*	@GenericGenerator(name = "gen", strategy = "native")
	@GeneratedValue(generator = "gen")
*/	@Id
	@Column(name="Call_Id")
	private int Call_Id;
	@Column(name="Connection_Id")
	private int Connection_id;
	@Column(name="Date_Of_Call")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfCall;
	@Column(name="CallMadeNo")
	private String callMadeNo;
	@Column(name="Duration")
	private String duration;
	@Column(name="Charges")
	private double Charges;
	//@OneToMany(mappedBy="Call_Id", fetch=FetchType.EAGER) 
	//private List<BillDetails> billList;
	public Call_Details(int call_Id, int connection_id, Date dateOfCall, String callMadeNo, String duration,double charges) {
		super();
		Call_Id = call_Id;
		Connection_id = connection_id;
		this.dateOfCall = dateOfCall;
		this.callMadeNo = callMadeNo;
		this.duration = duration;
		this.Charges=charges;
	
		
	}


	public Call_Details() {
		super();
	}

	
	public void setCharges(double charges) {
		Charges = charges;
	}
	
	
	
	public double getCharges() {
		return Charges;
	}

	public int getCall_Id() {
		return Call_Id;
	}


	public void setCall_Id(int call_Id) {
		Call_Id = call_Id;
	}


	public int getConnection_id() {
		return Connection_id;
	}


	public void setConnection_id(int connection_id) {
		Connection_id = connection_id;
	}


	public Date getDateOfCall() {
		return dateOfCall;
	}


	public void setDateOfCall(Date dateOfCall) {
		this.dateOfCall = dateOfCall;
	}


	public String getCallMadeNo() {
		return callMadeNo;
	}


	public void setCallMadeNo(String callMadeNo) {
		this.callMadeNo = callMadeNo;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}

  /*
	public List<BillDetails> getBillList() {
		return billList;
	}
	
	public void setBillList(List<BillDetails> billList) {
		this.billList = billList;
	}*/
	
	
	
	@Override
	public String toString() {
		return "Call_Details [Call_Id=" + Call_Id + ", Connection_id=" + Connection_id + ", dateOfCall=" + dateOfCall
				+ ", callMadeNo=" + callMadeNo + ", duration=" + duration + ", Charges=" + Charges +"]";
	}
	
	
	
	
	
	
	
}
