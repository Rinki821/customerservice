package com.pt.cs.service;

import java.util.List;

import com.pt.cs.entity.Customer;

public interface CustService {
	Customer saveCust(Customer c);
	Customer findById(long custId);
	String deleteCust(long custId);
	Customer updateCust(Customer c);
	List<Customer> getAll();
	
}
