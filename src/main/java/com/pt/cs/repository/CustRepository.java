package com.pt.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.cs.entity.Customer;

@Repository
public interface CustRepository  extends JpaRepository<Customer, Long>{

}
