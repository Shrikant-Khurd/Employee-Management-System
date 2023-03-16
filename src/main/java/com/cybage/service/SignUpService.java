package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.model.RoleBean;
import com.cybage.model.SignUpBean;
import com.cybage.repository.RoleRespository;
import com.cybage.repository.SignUpRepository;

@Service
public class SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private RoleRespository roleRespository;

//Registration
	public String registration(SignUpBean signUpBean) {
		String userEmail = signUpBean.getEmail();
		//RoleBean roleb=SignUpBean.getRole();
		RoleBean roleb=signUpBean.getRole();
		
		if (signUpRepository.existsByEmail(userEmail)) {
			return "Account already exists. Try logging in.";
		}
		else if(roleb.getRoleName()=="Manager") {			
			 signUpRepository.save(signUpBean);
			 return "Registration successful.";
		}
		else
			signUpRepository.save(signUpBean);
		return "Employee added successfully.";
			//return addEmployee( signUpBean);
		//return "Registration successful.";
	}

//Add-employee
	public String addEmployee(SignUpBean signUpBean) {
		String userEmail = signUpBean.getEmail();
		if (signUpRepository.existsByEmail(userEmail)) {
			return "Account already exists, Try logging in.";
		}
		signUpRepository.save(signUpBean);
		return "Employee added successfully.";
	}

//Get-all-employee
	public List<SignUpBean> getAllEmployee() {
		return signUpRepository.findAll();
	}

//Find-by-id
	public SignUpBean getEmployeeById(int id) {
		return signUpRepository.findById(id).orElse(null);
	}

//Delete-employee
	public void deleteEmployee(int id) {
		signUpRepository.deleteById(id);
	}

//Update-employee
	public String updateEmployee(int id, SignUpBean signUpBean) {
		SignUpBean signUpBean1 = signUpRepository.findById(id).get();
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

		signUpRepository.save(signUpBean1);
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


