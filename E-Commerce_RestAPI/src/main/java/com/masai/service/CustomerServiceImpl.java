package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Product;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrderDetailsRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.SessionRepository;

@Service
public class CustomerServiceImpl implements CustomerServices{
	
	@Autowired
	private CustomerRepository cRepo;

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private OrderDetailsRepository odRepo;
	@Autowired
//	private PaymentRepo payRepo;
//	@Autowired
	private SessionRepository sRepo;

	@Override
	public Customer RegisterNewCustomer(Customer customer) throws CustomerException {
		Customer cust = cRepo.findByEmail(customer.getEmail());
		
		if(cust != null) {
			throw new CustomerException("Customer Already registered with this email");
		}
		
		Customer addCustomer = cRepo.save(customer);
		return addCustomer;
	}
	@Override
	public Customer UpdateCustomer(String key,Integer custId,String fname,String lname,String email,String mobile,String password) throws CustomerException, LoginException {
         CurrentUserSession activeSession= sRepo.findByUuid(key);
		
         if (activeSession == null)
 			throw new LoginException("No active session found.");
         Optional<Customer> cust = cRepo.findById(activeSession.getUserId());

 		if (cust == null)
 			throw new CustomerException("Access restricted.");
 		Optional<Customer> newcust = cRepo.findById(custId);

 		if (!newcust.isPresent())
 			throw new CustomerException("Invalid Customer Id");

 		Customer newcust1 = newcust.get();

 		if (fname != null) {
 			newcust1.setFirstName(fname);;
 		}
 		if (lname != null) {
 			newcust1.setLastName(lname);;
 		}
 		if (email != null) {
 			newcust1.setEmail(email);
 		}
 		if (password != null) {
 			newcust1.setPassword(password);
 		}

 		Customer updated = cRepo.save(newcust1);

 		return updated;
	}

	@Override
	public Cart addProductToCart(String key, Integer productId, Integer quantity) throws CartException, ProductException, LoginException, CustomerException {

		CurrentUserSession activeSession = sRepo.findByUuid(key);
		
		if(activeSession == null) {
			throw new LoginException("No active session found");
		}
		
		Customer customer = cRepo.findById(activeSession.getUserId()).orElseThrow(()-> new CustomerException("Customer Not Found.....!"));
		Product product = productRepo.findById(productId).orElseThrow(()-> new ProductException("Product Not Found"));
		
		
		if (product.getProductStock() == 0)
			throw new ProductException("Product Out Of Stock");

		if (product.getProductStock() < quantity)
			throw new ProductException("product Stock is less than ordered quantity.");
		
			Cart cart= new Cart();	
				product.setProductStock(product.getProductStock()-quantity);
  			    cart.setProductName(product.getProductName());
				cart.setProductBrand(product.getProductBrand());
				cart.setProductDescription(product.getProductDescription());
				cart.setProductRating(product.getProductRating());
				cart.setProductMarketPrice(product.getProductMarketPrice());
				cart.setProductSellingPrice(product.getProductSellingPrice());
				cart.setCategoryName(product.getCategory().getCategoryName());
//				cart.setUserId(activeSession.getUserId());
				productRepo.save(product);
				cartRepo.save(cart);		
				return cart;			
	}

}
