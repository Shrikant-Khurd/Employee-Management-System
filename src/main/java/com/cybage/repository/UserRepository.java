package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.model.RoleBean;
import com.cybage.model.SignUpBean;

public interface UserRepository extends JpaRepository<SignUpBean, Integer> {
	
	boolean existsByEmail(String email);

	SignUpBean findByEmailAndPassword(String email, String password);

	SignUpBean findByEmail(String email);

	
}
