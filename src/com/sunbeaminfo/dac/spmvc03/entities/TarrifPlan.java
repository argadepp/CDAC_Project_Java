package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TarrifPlan")
public class TarrifPlan {

	@Id
	@Column
	private String Plan_Name;
	@Column
	private float Call_Charges;
	@Column
	private float SMS_Charges;
	
	public TarrifPlan() {
		// TODO Auto-generated constructor stub
	}

	public TarrifPlan(String plan_Name, float call_Charges, float sMS_Charges) {
		super();
		Plan_Name = plan_Name;
		Call_Charges = call_Charges;
		SMS_Charges = sMS_Charges;
	}

	public String getPlan_Name() {
		return Plan_Name;
	}

	public void setPlan_Name(String plan_Name) {
		Plan_Name = plan_Name;
	}

	public float getCall_Charges() {
		return Call_Charges;
	}

	public void setCall_Charges(float call_Charges) {
		Call_Charges = call_Charges;
	}

	public float getSMS_Charges() {
		return SMS_Charges;
	}

	public void setSMS_Charges(float sMS_Charges) {
		SMS_Charges = sMS_Charges;
	}

	@Override
	public String toString() {
		return "TarrifPlan [Plan_Name=" + Plan_Name + ", Call_Charges=" + Call_Charges + ", SMS_Charges=" + SMS_Charges
				+ "]";
	}
	
	
}
