package com.ROIIM.Assignment.service;

import com.ROIIM.Assignment.entity.Customer;
import com.ROIIM.Assignment.entity.CustomerToken;
import com.ROIIM.Assignment.entity.Payment;

public interface CheckoutService {
  
	public CustomerToken creatSingleUserCustomerToken( String emailId );
	 public Customer createCustomer( String emailId );
	  public Payment makePayment( Payment payment );
}
