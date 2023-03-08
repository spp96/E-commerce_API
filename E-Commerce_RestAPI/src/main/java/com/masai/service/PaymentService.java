package com.masai.service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Payment;

public interface PaymentService {
	
	public Payment paymentStatus(String key) throws CustomerException, CartException;

}
