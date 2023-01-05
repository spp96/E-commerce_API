package com.masai.service;


import com.masai.exceptions.AdminException;
import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Cart;
import com.masai.model.Customer;

public interface CustomerServices {
	
	public Customer RegisterNewCustomer(Customer customer) throws CustomerException;
	
	public Customer UpdateCustomer(String key,Integer custId,String fname,String lname,String email,String mobile,String password) throws CustomerException, LoginException;
	
	public Cart addProductToCart(String key, Integer productId, Integer quantity)
				throws CartException, ProductException, CustomerException, LoginException;


}
