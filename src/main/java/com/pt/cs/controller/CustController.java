package com.pt.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// why we import everytym import entity class
import com.pt.cs.entity.Customer;
import com.pt.cs.service.CustService;

@RestController
public class CustController {

	@Autowired
	CustService custservice;
	
	@PostMapping(value="/cust/save" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer saveCust(@RequestBody Customer c) {
		 c=custservice.saveCust(c);
		return c;
	}
	
	@GetMapping(value= "/cust/findById/{custId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findbyId(@PathVariable long custId) {
		Customer c= custservice.findById(custId);
		return c;
		
	}
	
	@DeleteMapping(value="/cust/delete/{custId}")
	public String deleteCust(@PathVariable long custId) {
		String msg= custservice.deleteCust(custId);
		return msg;
	}
	
	@PutMapping(value="/cust/updateCustomer" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer c) {
		return custservice.updateCust(c);
	}
	
	@GetMapping(value="/cust/all",produces = MediaType.APPLICATION_JSON_VALUE)
	List<Customer> getAll()
	{
		return custservice.getAll();
	}

}

	
	


