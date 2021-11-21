package com.sunbeaminfo.dac.spmvc03.entities;

import java.io.Serializable;

public class CashmodeSelect implements Serializable {
private String bank_name;
private int debit_card;

private int cust_id;
private int amount;
public CashmodeSelect() { }
public CashmodeSelect(String bank_name, int debit_card, int cust_id, int amount) {
	super();
	this.bank_name = bank_name;
	this.debit_card = debit_card;

	this.cust_id = cust_id;
	this.amount = amount;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public int getDebit_card() {
	return debit_card;
}
public void setDebit_card(int debit_card) {
	this.debit_card = debit_card;
}

public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
@Override
public String toString() {
	return "CashmodeSelect [bank_name=" + bank_name + ", debit_card=" + debit_card +  ", cust_id="
			+ cust_id + ", amount=" + amount + "]";
}
 
}
