package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Cart;
import com.masai.service.CustomerServices;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerServices customerService;

	@PostMapping("/add-to-cart")
	public ResponseEntity<Cart> add_product_to_cart(@RequestParam String key, @RequestParam Integer prodId,
			@RequestParam Integer qty) throws ProductException, CartException, CustomerException, LoginException {
		Cart cart = customerService.addProductToCart(key, prodId, qty);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
	}
}
