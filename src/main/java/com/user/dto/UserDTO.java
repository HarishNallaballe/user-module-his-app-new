package com.user.dto;

public class UserDTO {
	
	private Integer userId;
	private String name;
	private String email;
	private String mobileNumber;
	
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
	public UserDTO(Integer userId,String name, String email, String mobileNumber) {
		super();
		this.userId=userId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public UserDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ "]";
	}
}
