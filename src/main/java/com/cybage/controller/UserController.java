package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.RoleBean;
import com.cybage.model.SignUpBean;
import com.cybage.service.SignUpService;
import com.cybage.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//Registration of Manager
	@PostMapping("/registration-user")
	public ResponseEntity<String> registration(@RequestBody SignUpBean signUpBean) {
		String registrationStatus = userService.registration(signUpBean);
		return new ResponseEntity<>(registrationStatus, HttpStatus.OK);
	}

//Employee all CRUD Operations below
	@PostMapping("/add-employee")
	public ResponseEntity<String> addEmployee(@RequestBody SignUpBean signUpBean) {
		String addEmployeeStatus = userService.addEmployee(signUpBean);
		return new ResponseEntity<>(addEmployeeStatus, HttpStatus.OK);
	}

	@GetMapping("/get-all-employee")
	public ResponseEntity<List<SignUpBean>> getAllEmployee() {
		List<SignUpBean> employeeList = userService.getAllEmployee();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/get-employee-by-id/{id}")
	public ResponseEntity<SignUpBean> getEmployeeById(@PathVariable int id) {
		SignUpBean signUpBean1 = userService.getEmployeeById(id);
		return new ResponseEntity<>(signUpBean1, HttpStatus.OK);
	}

	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		userService.deleteEmployee(id);
		return new ResponseEntity<>("Employee Deleted Successfully!", HttpStatus.OK);
	}

	@PutMapping("/update-employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody SignUpBean signUpBean) {
		String updateEmployeeStatus	= userService.updateEmployee(id, signUpBean);
		return new ResponseEntity<>(updateEmployeeStatus, HttpStatus.OK);
	}

//To add Role
	@PostMapping("/addRole")
	public ResponseEntity<String> addRole(@RequestBody RoleBean roleBean) {
		String addRoleStatus = userService.addRole(roleBean);
		return new ResponseEntity<>(addRoleStatus, HttpStatus.OK);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<SignUpBean> verifyLoginWithPassword(@PathVariable String email,
			@PathVariable String password) {
		SignUpBean login = userService.LoginWithPassword(email, password);
		return new ResponseEntity<SignUpBean>(login, HttpStatus.OK);
	}
}

//@PostMapping("/registration")
//public ResponseEntity<String> registration(@RequestBody SignUpBean signUpBean)
//{
//	String UserEmail = signUpBean.getEmail();
//	
//	boolean verifyIfEmailExists = signUpService.checkEmail(UserEmail);
//	
//	if(!verifyIfEmailExists)
//	{
//		signUpService.registration(signUpBean);
//		return new ResponseEntity<>("Registered successfully!!", HttpStatus.CREATED);
//	}
//	else
//	{
//		throw new InvalidInputException("Email already exists!");
//	}
//}