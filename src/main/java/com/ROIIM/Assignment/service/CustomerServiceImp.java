package com.ROIIM.Assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ROIIM.Assignment.entity.Customer;
import com.ROIIM.Assignment.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	public CustomerRepository customerRepo;
	public Customer createCustomer(Customer cust) {
		 customerRepo.save(cust);
		 return customerRepo.findByEmail(cust.getEmail());
		
	}

	public Customer findUserByEmail(String email) {
		return customerRepo.findByEmail(email);
	}

}
