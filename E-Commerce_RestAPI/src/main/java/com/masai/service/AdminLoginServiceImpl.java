package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.repository.AdminRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;

@Service(value = "admin")
public class AdminLoginServiceImpl implements LoginService{
	
	@Autowired
	private AdminRepository aRepo;
	
	@Autowired
	private SessionRepository sRepo;

	@Override
	public CurrentUserSession LoginIntoAccount(LoginDTO loginDTO) throws LoginException {
		Admin existingAdmin = aRepo.findByAdminMobile(loginDTO.getMobile());
		if (existingAdmin == null)
			throw new LoginException("please enter valid mobile number");
		Optional<CurrentUserSession> validAdminSessionOpt = sRepo.findById(existingAdmin.getAdminId());
		if (validAdminSessionOpt.isPresent())
			throw new LoginException("Admin already logged in with this number");
		if (existingAdmin.getPassword().equals(loginDTO.getPassword())) {
			String key = RandomString.make(6);	
		
			CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(),"Admin", key, LocalDateTime.now());
			sRepo.save(currentUserSession);
			return currentUserSession;
		} else
			throw new LoginException("please enter valid password");
	}

	@Override
	public String LogoutFromAccount(String key) throws LoginException {
		CurrentUserSession currentUserSession = sRepo.findByUuid(key);
		if (currentUserSession == null)
			throw new LoginException("Admin not logged in with this number");
		else {
			sRepo.delete(currentUserSession);
			return "Admin Logged Out Successfully...!";
		}
	}

}
