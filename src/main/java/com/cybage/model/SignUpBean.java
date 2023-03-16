package com.cybage.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class SignUpBean {
	@Id
	@GeneratedValue
	private int registrationId;

	@Column(nullable = false, unique = true, length = 55)
	private String email;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 20)
	private String lastName;

	@Column(nullable = false, length = 50)
	private String address;

	@Column(nullable = false)
	private Date dateOfBirth;

	@Column(nullable = false, length = 10)
	private String contactNumber;

	@Column(nullable = false, length = 50)
	private String companyName;

	@Column(nullable = false, length = 20)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JsonIgnoreProperties(value = {"SignUpBean", "hibernateLazyInitializer"})
	@JoinColumn(name="roleId")
	private RoleBean role;
}