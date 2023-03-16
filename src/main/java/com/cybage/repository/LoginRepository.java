package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.SignUpBean;

@Repository
public interface LoginRepository extends JpaRepository<SignUpBean, Integer> {

	//get all values of user by email
	SignUpBean findUserByEmail(String email);
	
	 @Query("SELECT u FROM SignUpBean u WHERE u.email = :email")
	 public  List<SignUpBean>  getUserByEmail(@Param("email") String email);
	 
	 @Query("SELECT u FROM SignUpBean u WHERE u.email = :email AND u.password=:password")
	 public  SignUpBean getDataForAuthentication(@Param("email") String email, @Param("password") String password);	 

	SignUpBean findByEmailAndPassword(String email, String password);
}
