package com.sunbeaminfo.dac.spmvc03.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
import com.sunbeaminfo.dac.spmvc03.services.CustomerServiceImpl;

@CrossOrigin
@EnableWebMvc
@RestController
public class AddminController {

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value = "/customerList", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = service.getCustomers();
		// System.out.println(customerList);
		return customerList;
	}
	/*
	 * 
	 * @GetMapping(value = "/customer/{Connection_Id}", headers
	 * ="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public Customer getAllConnectionDetailsOfCustomer(@PathVariable int
	 * Connection_Id) { return service.getCustomerOnConnectionId(Connection_Id);
	 * 
	 * }
	 */

	@RequestMapping(value = "connection/{Cust_Id}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Connection> getConList(@PathVariable int Cust_Id) {
		List<Connection> conList = this.service.getConList(Cust_Id);
		return conList;
	}

	@DeleteMapping(value = "deleteCust/{Cust_Id}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCustomer(@PathVariable int Cust_Id) {

		this.service.deleteCustomer(Cust_Id);

	}

	@RequestMapping(value = "callList", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Call_Details> getCallList() {
		List<Call_Details> callList = this.service.getCallDetails();
		return callList;

	}

	@RequestMapping(value = "tarrifList", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TarrifPlan> getTarrifList() {
		List<TarrifPlan> tList = this.service.getTarrifPlan();
		return tList;

	}
	/*
	 * @RequestMapping(value = "/loginAddmin", headers =
	 * "Accept=application/json") public AddminDetails
	 * doLoginMethod(@RequestBody User cred) {
	 * 
	 * AddminDetails c = this.service.checkAddmin(cred);
	 * 
	 * if (c != null) { System.out.println("valid admin"); return c; } else {
	 * System.out.println("invalid"); }
	 * 
	 * return null; }
	 */

	@RequestMapping(value = "callList/{Con_Id}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Call_Details> getCallList(@PathVariable int Con_Id) {
		List<Call_Details> callList = this.service.getCallDetailsByCon_Id(Con_Id);
		return callList;

	}

	@RequestMapping(value = "billList", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BillDetails> getBillList() {
		List<BillDetails> billList = this.service.getBillList();
		return billList;

	}

	@RequestMapping(value = "billList/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BillDetails> getBillListByConId(@PathVariable int conId) {
		List<BillDetails> billList = this.service.getBillListByConId(conId);
		return billList;

	}

	@GetMapping(value = "smsList", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SmsDetails> getSmsList() {
		List<SmsDetails> smsList = service.getSmsList();
		return smsList;
	}

	@GetMapping(value = "smsList/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SmsDetails> getSmsListByConId(@PathVariable int conId) {
		List<SmsDetails> smsList = service.getSmsListByConId(conId);
		return smsList;
	}

	@GetMapping(value = "payment/{billId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaymentDetails> getPaymentDetails(@PathVariable int billId) {
		List<PaymentDetails> paymentList = service.getPaymentList(billId);
		return paymentList;
	}

	@RequestMapping(value = "profileCust/{custId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerProfile(@PathVariable int custId) {
		Customer cust = this.service.getCustomerProfile(custId);
		return cust;
	}

	@RequestMapping(value = "ad", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Addmin getAddmin(@RequestBody Login l) {
		Addmin ad = this.service.getAddmin(l);
		return ad;

	}

	@RequestMapping(value = "getCallCharges/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public double getCallCharges(@PathVariable int conId) {
		double row = this.service.getCharges(conId);
		return row;

	}

	@RequestMapping(value = "getSmsCharges/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public double getSmsCharges(@PathVariable int conId) {
		double row = this.service.getSmsCharges(conId);
		return row;

	}

	@RequestMapping(value = "getBillCharges/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public double getUpdateBill(@PathVariable int conId) {
		double row = this.service.updateBill(conId);
		return row;

	}

	@RequestMapping(value = "getTotalBill/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public double getTotalCharges(@PathVariable int conId) {
		double row = this.service.getBillCharges(conId);
		return row;

	}
	
	@PostMapping(value="/payment", headers="Accept=application/json")
	public Boolean payment(@RequestBody CashmodeSelect b) {
		return this.service.payment(b);
		
	}	
	
}
