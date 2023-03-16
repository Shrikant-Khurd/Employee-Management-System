package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.RoleBean;
import com.cybage.model.SignUpBean;
import com.cybage.repository.RoleRespository;
import com.cybage.repository.SignUpRepository;
import com.cybage.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRespository roleRespository;

//Registration
	public String registration(SignUpBean signUpBean) {
		String userEmail = signUpBean.getEmail();
		RoleBean checkRole = signUpBean.getRole();
		System.out.println(checkRole.getRoleId() + " " + checkRole.getRoleName());
		if (userRepository.existsByEmail(userEmail)) {
			return "Account already exists. Try logging in.";
		}
		userRepository.save(signUpBean);
		return "Registration successful.";
//
//		if (checkRole.getRoleName() == "Manager") {
//			userRepository.save(signUpBean);
//			System.out.println("EMP");
//			return "Employee added successfully.";
//		} else {  
//			userRepository.save(signUpBean);
//			System.out.println("MNG");
//			return "Registration successful.";
//
//		}
	}

//Add-employee
	public String addEmployee(SignUpBean signUpBean) {
		String userEmail = signUpBean.getEmail();
		if (userRepository.existsByEmail(userEmail)) {
			return "Account already exists, Try logging in.";
		}
		if (signUpBean.getFirstName() == null)
			return "First name cannot be empty";

		if (signUpBean.getLastName() == null)
			return "last name cannot be empty";

		if (signUpBean.getAddress() == null)
			return "Address name cannot be empty";

		if (signUpBean.getDateOfBirth() == null)
			return "DOB name cannot be empty";

		if (signUpBean.getLastName() == null)
			return "First name cannot be empty";

		if (signUpBean.getContactNumber() == null)
			return "phone number cannot be empty";

		if (signUpBean.getCompanyName() == null)
			return "Company name cannot be empty";

		if (signUpBean.getPassword() == null)
			return "Passwordcannot be empty";

		userRepository.save(signUpBean);
		return "Employee added successfully.";
	}

//Get-all-employee
	public List<SignUpBean> getAllEmployee() {
		return userRepository.findAll();
	}

//Find-by-id
	public SignUpBean getEmployeeById(int id) {
		return userRepository.findById(id).orElse(null);
	}

//Delete-employee
	public void deleteEmployee(int id) {
		userRepository.deleteById(id);
	}

//Update-employee
	public String updateEmployee(int id, SignUpBean signUpBean) {
		SignUpBean signUpBean1 = userRepository.findById(id).get();
		if (signUpBean.getFirstName() != null)
			signUpBean1.setFirstName(signUpBean.getFirstName());

		if (signUpBean.getLastName() != null)
			signUpBean1.setLastName(signUpBean.getLastName());

		if (signUpBean.getAddress() != null)
			signUpBean1.setAddress(signUpBean.getAddress());

		if (signUpBean.getDateOfBirth() != null)
			signUpBean1.setDateOfBirth(signUpBean.getDateOfBirth());

		if (signUpBean.getLastName() != null)
			signUpBean1.setLastName(signUpBean.getLastName());

		if (signUpBean.getContactNumber() != null)
			signUpBean1.setContactNumber(signUpBean.getContactNumber());

		if (signUpBean.getCompanyName() != null)
			signUpBean1.setCompanyName(signUpBean.getCompanyName());

		if (signUpBean.getPassword() != null)
			signUpBean1.setPassword(signUpBean.getPassword());

		userRepository.save(signUpBean1);
		return "Employee updated successfully.";
	}

//Add-role
	public String addRole(RoleBean roleBean) {
		String checkRole = roleBean.getRoleName();
		if (roleRespository.existsByRoleName(checkRole)) {
			return "Role already exists!";
		}
		roleRespository.save(roleBean);
		return "Role added successfully.";
	}

	public SignUpBean LoginWithPassword(String email, String password) {
		SignUpBean user = userRepository.findByEmail(email);

		if (user.getPassword().equals(password))
			return user;
//		} else
//			return "Incorrect Password";	
		else
			System.out.println("incorrect password");
			return null;
	}
}

//	// to find if Email is unique or not
//	public boolean checkEmail(String email) {
//		SignUpBean userData = signUpRepository.findByEmail(email);
//		if (userData != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}