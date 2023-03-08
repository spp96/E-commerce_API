package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Admin;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Payment;
import com.masai.repository.AdminRepository;
import com.masai.repository.CartRepository;
import com.masai.repository.PaymentRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;

@Service(value = "payment")
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository pRepo;

	@Autowired
	private SessionRepository sRepo;
	
	@Autowired
	private CartRepository cRepo;
	
	@Autowired
	private AdminRepository aRepo;

	@Override
	public Payment paymentStatus(String key) throws CustomerException, CartException {
		CurrentUserSession validUserSession = sRepo.findByUuid(key);
		if(validUserSession == null) {
		 throw new CustomerException("Please Log In First");	
		}
		
		
		List<Cart> cart =  cRepo.findByUserId(validUserSession.getUserId());
		
		if(cart.size() != 0) {
			Payment userPayment = new Payment();
			userPayment.setLocalDateTime(LocalDateTime.now());
			userPayment.setUserId(validUserSession.getUserId());
			String utr = "abc"+ RandomString.make(6)+"xyz";
			userPayment.setUTR(utr);
			if(utr.equals(null)) {
				userPayment.setPaymentStatus(false);
			}else {
				userPayment.setPaymentStatus(true);
			}
	
			return pRepo.save(userPayment);
		}else {
			throw new CartException("Cart Is Empty Please Add Item");
		}

	}

}
