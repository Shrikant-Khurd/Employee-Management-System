//package com.cybage.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cybage.model.SignUpBean;
//import com.cybage.service.LoginService;
//
//@RestController
//@RequestMapping("/user")
//public class LoginController {
//	
//	@Autowired 
//	private LoginService loginService;
//	
//	@PostMapping("/login")
//	public ResponseEntity<SignUpBean> login(@RequestBody SignUpBean signUpBean)
//	{
//		String email = signUpBean.getEmail();
//		String password = signUpBean.getPassword();
//	
//		SignUpBean loggedInUser = loginService.loginAuthentication(email, password);
//		
//		boolean verifyEmailOfUser = loginService.checkUserByEmail(email);
//		boolean flagToCheckPassword = loginService.checkPassword(signUpBean);
//		
////		if (!verifyEmailOfUser) 
////		{
////			throw new InvalidInputException("User does not exists...");
////		}
////		else if(verifyEmailOfUser) 
////		{
////			if(flagToCheckPassword) 
////			{
////				
////			}
////		else 
////		{
////			throw new InvalidInputException("Incorrect credentials ...");
////		}
//
//		return new ResponseEntity<SignUpBean>(loggedInUser, HttpStatus.OK);
//	}
//}
////}
//
