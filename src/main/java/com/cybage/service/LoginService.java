package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.SignUpBean;
import com.cybage.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired LoginRepository loginRepository;
	
	//getting user by email
	public SignUpBean getUserByEmail(String email) 
	{
		return loginRepository.findUserByEmail(email);
	}
	
	//check if user exists by given email 
	public boolean checkUserByEmail(String email) 
	{
		SignUpBean userData = loginRepository.findUserByEmail(email);
			
			if(userData != null) {
				return true;
			}
			else {
				return false;
			}
	}
	
	//check if given password by login is same for the email
		public boolean checkPassword(SignUpBean signUpBean) 
		{
			//check if email exists
			boolean flag = checkUserByEmail(signUpBean.getEmail());
			
			//if yes
			if(flag) {
				return getUserByEmail(signUpBean.getEmail()).getPassword().equals(signUpBean.getPassword());
			}
			else {
				return false;
			}	
		}
		
		public SignUpBean loginAuthentication(String email, String password) {
			return loginRepository.getDataForAuthentication(email, password);
		}
	
	
}
