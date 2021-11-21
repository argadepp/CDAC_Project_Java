package com.sunbeaminfo.dac.spmvc03.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sunbeaminfo.dac.spmvc03.entities.Addmin;
import com.sunbeaminfo.dac.spmvc03.entities.Customer;
import com.sunbeaminfo.dac.spmvc03.entities.Login;
import com.sunbeaminfo.dac.spmvc03.entities.TarrifPlan;
import com.sunbeaminfo.dac.spmvc03.entities.User;
import com.sunbeaminfo.dac.spmvc03.services.CustomerServiceImpl;

@EnableWebMvc
@CrossOrigin
@RestController
public class Customer_Controller {

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value = "/login", headers = "Accept=application/json")
	public Customer doLoginMethod(@RequestBody User cred) {

		Customer c = this.service.checkLogin(cred);

		if (c != null) {

			System.out.println("valid user");
			return c;
		} else {
			System.out.println("invalid");
		}

		return null;
	}

	

	
	@PostMapping(value = "/register", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addCustomer(@RequestBody Customer c) {
		try {
			service.addCustomer(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@RequestMapping(value = "/update/{custId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public int updateCustomer(@PathVariable int custId,@RequestBody Customer c ) {
   int r=service.updateCustomer(custId,c.getName(),c.getEmail(),c.getAddress(),c.getPassword());
		System.out.println(c);
		return r;
	}

	
	@GetMapping(value = "/plans", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TarrifPlan> getPlans()
	{
		List<TarrifPlan> plans=this.service.getPlans();
		return plans;
	}

	
	@RequestMapping(value = "/doPayment/{conId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public int doPayment(@PathVariable int conId  )
	{
		int row=service.doPayment(conId);
		return row;
	}
	
	
}
