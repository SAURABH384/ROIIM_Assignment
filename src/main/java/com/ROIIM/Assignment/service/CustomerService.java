package com.ROIIM.Assignment.service;

import com.ROIIM.Assignment.entity.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer cust);
	public Customer findUserByEmail(String email);

}