package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.service.AdminServices;
import com.masai.service.LoginService;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {
	
	
	@Autowired
	@Qualifier(value = "admin")
	private LoginService loginService;
	
	@Autowired
	private AdminServices aServices;
	
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginIntoAccountHandler(@RequestBody LoginDTO login)
			throws LoginException {
		CurrentUserSession str = loginService.LoginIntoAccount(login);
		return new ResponseEntity<CurrentUserSession>(str, HttpStatus.OK);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logoutFromAccountHandler(@RequestParam(required = false) String key)
			throws LoginException {
		String str = loginService.LogoutFromAccount(key);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}


}
