package com.pt.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.cs.entity.Customer;
import com.pt.cs.repository.CustRepository;

@Service
public class CustServiceImpl implements CustService{

	@Autowired
	CustRepository CustRepository;
	
	@Override
	public Customer saveCust(Customer c) {
		c=CustRepository.save(c);
		return c;
	}

	@Override
	public Customer findById(long custId) {
		 return CustRepository.findById(custId).get();
		
	}

	@Override
	public String deleteCust(long custId) {
		Customer c = CustRepository.findById(custId).get();
		CustRepository.delete(c);
		return "customer is deleted ";
	}

	@Override
	public Customer updateCust(Customer c) {
		Customer existingCust =this.findById(c.getId());
		if(existingCust==null) {
			return null;
		}
		else {
			existingCust.setName(c.getName());
			existingCust.setPan(c.getPan());
			CustRepository.save(existingCust);
			return existingCust;
		}
		
	}

	@Override
	public List<Customer> getAll() {
		return CustRepository.findAll();
	}
	
	
	

}
