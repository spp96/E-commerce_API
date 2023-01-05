package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.service.CustomerServices;
import com.masai.service.LoginService;


@RestController
@RequestMapping("/customer")
public class CustomerAuthController {
	
	@Autowired
	@Qualifier(value = "customer")
	private LoginService loginService;

	@Autowired
	private CustomerServices cService;

	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginIntoAccountHandler(@RequestBody LoginDTO login)
			throws LoginException, CustomerException {
		CurrentUserSession str = loginService.LoginIntoAccount(login);
		return new ResponseEntity<CurrentUserSession>(str, HttpStatus.OK);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logoutFromAccountHandler(@RequestParam(required = false) String key)
			throws LoginException, CustomerException {
		String str = loginService.LogoutFromAccount(key);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> registerAccountHandler(@RequestBody Customer customer) throws LoginException, CustomerException {
		Customer cus = cService.RegisterNewCustomer(customer);
		return new ResponseEntity<Customer>(cus, HttpStatus.OK);
	}

	@PutMapping("/update-customer")
	public ResponseEntity<Customer> update_customer(@RequestParam(required = false) String key,@RequestParam Integer custId,@RequestParam String fname,
			@RequestParam String lname,@RequestParam String email,@RequestParam String mobile,@RequestParam String password) throws CustomerException, LoginException {

		Customer cust = cService.UpdateCustomer(key, custId, fname, lname, email, mobile, password);

		return new ResponseEntity<Customer>(cust, HttpStatus.FOUND);
	}
}
