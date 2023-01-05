package com.masai.service;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Product;

public interface AdminServices {
	public Admin RegisterNewAdmin(Admin admin) throws AdminException;
	public Admin UpdateAdmin(String key,Integer adminId,String name,String email,String mobile,String password) throws LoginException,AdminException;
	public Product addNewProduct(String key, Product product) throws ProductException, LoginException;
	public List<Product> getAllProducts(String key) throws ProductException, LoginException;
	public Product updateProduct(String key, Integer productId, String name, String des, String brand, Double rating,
			Double mPrice,
			Double sPrice, Integer stock) throws ProductException,LoginException;
	public List<Customer> getAllCustomers(String key) throws CustomerException;
}
