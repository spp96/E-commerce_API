package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;

public interface LoginService {
	
	public CurrentUserSession LoginIntoAccount(LoginDTO loginDTO) throws LoginException;
	
	public String LogoutFromAccount(String key) throws LoginException;

}
