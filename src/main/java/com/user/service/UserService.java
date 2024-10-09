package com.user.service;

import java.util.List;

import com.user.dto.SignInDto;
import com.user.dto.UpdatePwd;
import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoudException;

public interface UserService {
	
	public String register(UserDTO userdto);
	
	public boolean signin(SignInDto signInDto) throws UserNotFoudException;
	
	public String updatePwd(UpdatePwd updatePwd) throws UserNotFoudException;
	
	public String checkEmailUnique(String email);
	
	public String forgotPwd(String email) throws UserNotFoudException;
	
	public List<User> getUser();

}
