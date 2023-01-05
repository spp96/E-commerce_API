package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.service.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServices aService;
	
	@PostMapping("/register-admin")
	public ResponseEntity<Admin> registerNewAdmin(@RequestBody Admin ad) throws AdminException {
		
		Admin nadmin = aService.RegisterNewAdmin(ad);
		return new ResponseEntity<Admin>(nadmin,HttpStatus.CREATED);
		
	}
	@PutMapping("/update-admin")
	public ResponseEntity<Admin> update_admin(@RequestParam(required = false) String key,@RequestParam Integer adminId,
			@RequestParam String name,@RequestParam String email,@RequestParam String mobile,@RequestParam String password) throws AdminException, LoginException {

		Admin newadmin = aService.UpdateAdmin(key, adminId, name, email, mobile, password);

		return new ResponseEntity<Admin>(newadmin, HttpStatus.CREATED);
	}
	
	@GetMapping("/all-products/")
	public ResponseEntity<List<Product>> get_all_products(@RequestParam(required = false) String key) throws ProductException, LoginException{
		List<Product> productList = aService.getAllProducts(key);
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}

	@PostMapping("/add-product")
	public ResponseEntity<Product> add_new_Product(@RequestBody Product product, @RequestParam String key)
			throws ProductException, LoginException {
		Product productList = aService.addNewProduct(key, product);
		return new ResponseEntity<Product>(productList, HttpStatus.CREATED);
	}

	@PutMapping("/update-product")
	public ResponseEntity<Product> update_product(@RequestParam(required = false) String key, @RequestParam Integer productId,
			@RequestParam String name, @RequestParam String des, @RequestParam String brand,
			@RequestParam Double rating, @RequestParam Double mPrice, @RequestParam Double sPrice,
			@RequestParam Integer stock) throws LoginException, ProductException {

		Product product1 = aService.updateProduct(key, productId, name, des, brand, rating, mPrice, sPrice, stock);

		return new ResponseEntity<Product>(product1, HttpStatus.ACCEPTED);
	}
	@GetMapping("all-customers")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String key) throws CustomerException {
		List<Customer> customerList = aService.getAllCustomers(key);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.FOUND);
	}
}
