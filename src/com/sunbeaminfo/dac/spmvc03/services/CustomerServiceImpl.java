package com.sunbeaminfo.dac.spmvc03.services;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeaminfo.dac.spmvc03.daos.CustomerDaoImpl;
import com.sunbeaminfo.dac.spmvc03.entities.Addmin;
import com.sunbeaminfo.dac.spmvc03.entities.BillDetails;
import com.sunbeaminfo.dac.spmvc03.entities.Call_Details;
import com.sunbeaminfo.dac.spmvc03.entities.CashmodeSelect;
import com.sunbeaminfo.dac.spmvc03.entities.Connection;
import com.sunbeaminfo.dac.spmvc03.entities.Customer;
import com.sunbeaminfo.dac.spmvc03.entities.Login;
import com.sunbeaminfo.dac.spmvc03.entities.PaymentDetails;
import com.sunbeaminfo.dac.spmvc03.entities.SmsDetails;
import com.sunbeaminfo.dac.spmvc03.entities.TarrifPlan;
import com.sunbeaminfo.dac.spmvc03.entities.User;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDaoImpl dao;

	// validation and login of customer
	public List<Customer> getData() {
		List<Customer> list = this.dao.getAllCustomers();
		return list;

	}
	

	@Transactional
	public Customer checkLogin(User u)
	{
		List<Customer> clist=this.getData();
				
		for (Customer clogin :clist) {
			
			if(clogin.getEmail().equals(u.getEmail())  && clogin.getPassword().equals(u.getPassword()))
			{
				return clogin;
			}
		
		}
		return null;
	}
	

   @Transactional
   public Addmin getAddmin(Login l)
   {
	   Addmin ad=dao.getAdmin(l.getId(), l.getPassword());
	   return ad;
   }
	
	
	@Transactional
	public List<TarrifPlan> getPlans()
	{
		List<TarrifPlan> plans=dao.selectPlan();
		return plans;
	}
	
	


	
	// add customer data
	@Transactional
	public void addCustomer(Customer c) {
		dao.add(c);
	}


	
	@Transactional
	public List<Connection> getConList(int id)
	{
		List<Connection> conList=this.dao.getConList(id);
		System.out.println(conList);
		return conList;
	}
	
	
	@Transactional
	public List<Call_Details> getCallDetails()
	{
		List<Call_Details> callList=this.dao.getAllCallList();
		System.out.println(callList);
	    return callList;
	}
	 
	

	@Transactional
	public List<Call_Details> getCallDetailsByCon_Id(int con_Id)
	{
		List<Call_Details> callList=this.dao.getCallDetailsOfPerticularConnection(con_Id);
		System.out.println(callList);
	    return callList;
	}
	 
	
	@Transactional
	public int deleteCustomer(int c_Id)
	{
		int rowAffect=this.dao.deleteCustomer(c_Id);
		return rowAffect;
	}
	
	
	
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> customerList = dao.getAllCustomers();
		System.out.println(customerList);
		return customerList;
	}

	@Transactional
	public List<BillDetails> getBillList()
	{
		List<BillDetails> billList=dao.getBillList();
		System.out.println(billList);
		return billList;
	}
	
	@Transactional
	public List<BillDetails> getBillListByConId(int conId)
	{
		List<BillDetails> billList=dao.getBillListByConnectionId(conId);
		System.out.println(billList);
		return billList;
	}
	
	@Transactional
	public List<BillDetails> getBillListByCustId(int custId)
	{
		List<BillDetails> billList=dao.getBillListByCustomerId(custId);
		System.out.println(billList);
		return billList;
	}
	
	
	
	@Transactional
	public Customer getCustomerProfile(int custId)
	{
		Customer cust=dao.getCustomerProfile(custId);
		return cust;
	}
	
	@Transactional
	public int updateCustomer(int custId,String name,String email,String address,String password)
	{
		int rowAffect=dao.udateCustomer(custId, name, email,address,password);
		return rowAffect;
	}
	
	
	
	
	
	@Transactional
	public List<TarrifPlan> getTarrifPlan()
	{
		List<TarrifPlan> list=dao.getTarrifPlan();
		return list;
	}
	
	@Transactional
	public List<SmsDetails> getSmsList()
	{
		List<SmsDetails> smsList=dao.getSmsList();
		return smsList;
	}
	
	@Transactional
	public List<SmsDetails> getSmsListByConId(int conId)
	{
		List<SmsDetails> smsList=dao.getSmsListByConId(conId);
		return smsList;
	}
	
	
	
	@Transactional
	public List<PaymentDetails> getPaymentList(int billId)
	{
		List<PaymentDetails> paymentList=dao.getPaymentDetails(billId);
		return paymentList;
	}
	
	@Transactional
	public int doPayment(int conId)
	{
		int row=dao.doPayment(conId);
		return row;
		
	}
	
	
	@Transactional
	public double getCharges(int conId)
	{
		double res=dao.getCallCharges(conId);
		return res;
	}
	
	@Transactional
	public double getSmsCharges(int conId)
	{
		double res=dao.getSmsCharges(conId);
		return res;
	}
	
	@Transactional
	public double getBillCharges(int conId)
	{
		double res=dao.getTotalBill(conId);
		return res;
	}
	
	@Transactional
	public int updateBill(int conId)
	{
		int row=dao.getBillPayment(conId);
		return row;
	}
	
	@Transactional
	public boolean payment(CashmodeSelect c) {
	return this.dao.payment(c);
	}
}
