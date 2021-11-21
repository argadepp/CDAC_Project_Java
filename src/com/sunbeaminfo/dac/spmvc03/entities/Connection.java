package com.sunbeaminfo.dac.spmvc03.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Connection {

	
	@Id
	private int Connection_Id;
	@Column
	private int Customer_Id;
	@Column
	private String Status;

	//@OneToOne
	//@PrimaryKeyJoinColumn
	private String Tarrif_Plan;
	
	
	
	public Connection() {
		// TODO Auto-generated constructor stub
	}

	public Connection(int connection_Id, int customer_Id, String status, String tarrif_Plan) {
		super();
		Connection_Id = connection_Id;
		Customer_Id = customer_Id;
		Status = status;
		Tarrif_Plan = tarrif_Plan;
	}

	public int getConnection_Id() {
		return Connection_Id;
	}

	public void setConnection_Id(int connection_Id) {
		Connection_Id = connection_Id;
	}

	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getTarrif_Plan() {
		return Tarrif_Plan;
	}

	public void setTarrif_Plan(String tarrif_Plan) {
		Tarrif_Plan = tarrif_Plan;
	}

	@Override
	public String toString() {
		return "Connection [Connection_Id=" + Connection_Id + ", Customer_Id=" + Customer_Id + ", Status=" + Status
				+ ", Tarrif_Plan=" + Tarrif_Plan + "]";
	}
	
	
	
	
	
}
