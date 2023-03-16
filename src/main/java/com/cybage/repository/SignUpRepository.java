package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.RoleBean;
import com.cybage.model.SignUpBean;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpBean, Integer> {

	boolean existsByEmail(String email);

	SignUpBean findByEmail(String email);
	
	boolean findByRole(String role);

	//boolean findByRole(RoleBean role);
}
