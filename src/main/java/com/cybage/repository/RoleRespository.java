package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.RoleBean;

public interface RoleRespository extends JpaRepository<RoleBean, Integer> {

	boolean existsByRoleName(String roleName);
}
