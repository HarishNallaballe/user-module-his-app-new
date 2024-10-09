package com.user.entity;

import java.sql.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String name;
	
	@Column(unique = true,nullable = false)
	private String email;
	@Column(unique = true,nullable = false)
	private String mobileNumber;
	private String pwdUpdated;
	private String confirmPwd;
	private String role;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPwdUpdated() {
		return pwdUpdated;
	}
	public void setPwdUpdated(String pwdUpdated) {
		this.pwdUpdated = pwdUpdated;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public User(String name, String email, String mobileNumber, String pwdUpdated, String confirmPwd,
			String role) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.pwdUpdated = pwdUpdated;
		this.confirmPwd = confirmPwd;
		this.role = role;
	}
	public User(Integer id,String name, String email, String mobileNumber) {
		super();
		this.userId=id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", pwdUpdated=" + pwdUpdated + ", confirmPwd=" + confirmPwd + ", role=" + role + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
}
