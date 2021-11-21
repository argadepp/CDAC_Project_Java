package com.sunbeaminfo.dac.spmvc03.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank {
	@Id
	@Column
private int debit_card;
	@Column
private int Customer_id;
	@Column
private String bank_name;

	@Column
private int balance;
	
public Bank() {
	// TODO Auto-generated constructor stub
}

public int getDebit_card() {
	return debit_card;
}

public void setDebit_card(int debit_card) {
	this.debit_card = debit_card;
}

public int getCust_id() {
	return Customer_id;
}

public void setCust_id(int cust_id) {
	this.Customer_id = cust_id;
}

public String getBank_name() {
	return bank_name;
}

public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public Bank(int debit_card, int cust_id, String bank_name, int balance) {
	this.debit_card = debit_card;
	this.Customer_id = cust_id;
	this.bank_name = bank_name;

	this.balance = balance;
}

@Override
public String toString() {
	return "Bank [debit_card=" + debit_card + ", bank_name=" + bank_name +
			 ", balance=" + balance + "]";
}


}
