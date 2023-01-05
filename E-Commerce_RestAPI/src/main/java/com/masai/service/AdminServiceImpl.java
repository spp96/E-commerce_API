package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.repository.AdminRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.SessionRepository;

@Service
public class AdminServiceImpl implements AdminServices{
	
	@Autowired
	AdminRepository aRepo;
	
	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	SessionRepository sRepo;
	
	@Autowired
	CustomerRepository cRepo;

	@Override
	public Admin RegisterNewAdmin(Admin admin) throws AdminException {
		
        Admin ad = aRepo.findByAdminMobile(admin.getAdminMobile());
		
		if(ad != null) {
			throw new AdminException("Admin Already registered with this mobile");
		}
		
		Admin newadmin = aRepo.save(admin);
		return newadmin;
	}

	@Override
	public Admin UpdateAdmin(String key,Integer adminId,String name,String email,String mobile,String password) throws LoginException, AdminException
		{
		CurrentUserSession activeSession= sRepo.findByUuid(key);

		if (activeSession == null)
			throw new LoginException("No active session found.");
		Admin admin = aRepo.findByAdminId(activeSession.getUserId());

		if (admin == null)
			throw new AdminException("Access restricted.");
		Optional<Admin> ad = aRepo.findById(adminId);

		if (!ad.isPresent())
			throw new AdminException("Invalid Admin Id");

		Admin newad = ad.get();

		if (name != null) {
			newad.setAdminName(name);;
		}
		if (email != null) {
			newad.setAdminEmail(email);
		}
		if (mobile != null) {
			newad.setAdminMobile(mobile);
		}
		if (password != null) {
			newad.setPassword(password);
		}

		Admin updated = aRepo.save(newad);

		return updated;
	}
	@Override
	public Product addNewProduct(String key, Product product) throws ProductException, LoginException {
		CurrentUserSession activeSession = sRepo.findByUuid(key);

		if (activeSession == null) {
			
			throw new LoginException("No active session found.");
		}
		Admin admin = aRepo.findByAdminId(activeSession.getUserId());

		if (admin == null) {
			
			throw new LoginException("Access restricted.");
		}
		Product savedProduct = pRepo.save(product);

		return savedProduct;
	}

	@Override
	public List<Product> getAllProducts(String key) throws ProductException,LoginException {
		CurrentUserSession activeSession = sRepo.findByUuid(key);

		if (activeSession == null) {
			
			throw new LoginException("No active session found.");
		}

		Admin admin = aRepo.findByAdminId(activeSession.getUserId());

		if (admin == null) {
			
			throw new LoginException("Access restricted.");
		}

		List<Product> productList = pRepo.findAll();

		if (productList.size() == 0) {
			
			throw new ProductException("Products Not Found");
		}

		return productList;
	}

	@Override
	public Product updateProduct(String key, Integer productId, String name, String des, String brand, Double rating,
			Double mPrice,
			Double sPrice, Integer stock) throws ProductException, LoginException {

		CurrentUserSession activeSession = sRepo.findByUuid(key);

		if (activeSession == null)
			throw new LoginException("No active session found.");
		Admin admin = aRepo.findByAdminId(activeSession.getUserId());

		if (admin == null)
			throw new ProductException("Access restricted.");
		// Getting the product to Update.
		Optional<Product> product = pRepo.findById(productId);

		if (!product.isPresent())
			throw new ProductException("Invalid Product Id");

		Product p = product.get();

		if (name != null) {
			p.setProductName(name);
		}
		if (des != null) {
			p.setProductDescription(des);
		}
		if (brand != null) {
			p.setProductBrand(brand);
		}
		if (rating != null) {
			p.setProductRating(rating);
		}
		if (mPrice != null) {
			p.setProductMarketPrice(mPrice);
		}
		if (sPrice != null) {
			p.setProductSellingPrice(sPrice);
		}
		if (stock != null) {
			p.setProductStock(stock);
		}

		Product updated = pRepo.save(p);

		return updated;
	
	}

	@Override
	public List<Customer> getAllCustomers(String key) throws CustomerException {
		CurrentUserSession activeSession = sRepo.findByUuid(key);

		if (activeSession == null)
			throw new CustomerException("No active session found.");
		Admin admin = aRepo.findByAdminId(activeSession.getUserId());

		if (admin == null)
			throw new CustomerException("Access restricted.");
		List<Customer> customerList = cRepo.findAll();

		if (customerList.size() == 0)
			throw new CustomerException("No Customers Found");

		return customerList;
	}


}
