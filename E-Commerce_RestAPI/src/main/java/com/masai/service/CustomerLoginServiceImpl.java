package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;import lombok.val;
import net.bytebuddy.utility.RandomString;

@Service(value = "customer")
public class CustomerLoginServiceImpl implements LoginService{
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private SessionRepository sRepo;

	@Override
	public CurrentUserSession LoginIntoAccount(LoginDTO loginDTO) throws LoginException {
		Customer existingCustomer = cRepo.findByMobile(loginDTO.getMobile());
		
		if(existingCustomer ==null) {
			throw new LoginException("Please enter valid mobile number");
		}
		
		Optional<CurrentUserSession> validCustomerSessionopt = sRepo.findById(existingCustomer.getCustId());
		
		if(validCustomerSessionopt.isPresent()) {
			throw new LoginException("Customer already logged in with this number");
		}
		if(existingCustomer.getPassword().equals(loginDTO.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustId(),"Customer" ,key, LocalDateTime.now());
			
			sRepo.save(currentUserSession);
			return currentUserSession;
		} else {
			throw new LoginException("please enter valid password");
		}
		
	}

	@Override
	public String LogoutFromAccount(String key) throws LoginException {
		CurrentUserSession currentUserSession = sRepo.findByUuid(key);
		if(currentUserSession == null) {
			throw new LoginException("Customer not logged in with this number");
		} else {
			sRepo.delete(currentUserSession);
			return "Customer Logged Out Successfully...!";
		}
	}

}
