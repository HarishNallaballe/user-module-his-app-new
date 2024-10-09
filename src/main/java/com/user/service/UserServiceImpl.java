package com.user.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.constants.AppConstants;
import com.user.dto.SignInDto;
import com.user.dto.UpdatePwd;
import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoudException;
import com.user.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository repo;
	
	  static Random random = new Random();

	@Override
	public String register(UserDTO userdto) {
		User user = new User();
		BeanUtils.copyProperties(userdto, user);
		user.setConfirmPwd(passwordUsingName(user.getName()));
		user.setPwdUpdated("No");
		Optional<User> findByEmail = repo.findByEmail(userdto.getEmail());
		if(findByEmail!=null) {
			logger.info("Duplicate Email, Email must be unique");
			return AppConstants.DUPLICATE_EMAIL+user.getEmail();
		}
		User saved = repo.save(user);
		return saved.getUserId()>0? AppConstants.USER_SAVED_SUCCESSFULLY:AppConstants.USER_NOT_SAVED_SUCCESSFULLY;
	}


	@Override
	public boolean signin(SignInDto signInDto) throws UserNotFoudException {
		Optional<User> user = null;
		try {
		 user= repo.findByEmailAndConfirmPwd(signInDto.getEmail(), signInDto.getPassword());
		}catch (Exception e) {
			throw new UserNotFoudException("User Not found with email and password");
		}
		return user!=null;
	}

	@Override
	public String updatePwd(UpdatePwd updatePwd) throws UserNotFoudException {
		User user1 = repo.findById(updatePwd.getId()).orElseThrow(()-> new UserNotFoudException("User not found with given Id : "+updatePwd.getId()));
		User user = null;
		 user=repo.findById(updatePwd.getId()).orElseThrow(()-> new UserNotFoudException("User not found with email : " +user1.getEmail()));
		if(!(user.getConfirmPwd().equalsIgnoreCase(updatePwd.getOldPwd()))) {
			logger.info("Please enter the correct password");
			return AppConstants.WRONG_PASSWORD;
		}
		if(user.getPwdUpdated().equalsIgnoreCase("No")) {
			user.setPwdUpdated("Yes");
			user.setConfirmPwd(updatePwd.getConfirmPwd());
			BeanUtils.copyProperties(updatePwd, user);
			repo.save(user);
			logger.info("Password updated successfully");
			return AppConstants.PASSWORD_UPDATED_SUCCESSFULLY;
		}
		logger.info("Password not updated successfully");
		return AppConstants.PASSWORD_NOT_UPDATED_SUCCESSFULLY;
	}

	@Override
	public String checkEmailUnique(String email) {
		Optional<User> user = repo.findByEmail(email);
		if(user==null) {
			return AppConstants.NO_USER_FOUND+email;
		}
		return AppConstants.DUPLICATE_EMAIL+email;
	}

	@Override
	public String forgotPwd(String email) throws UserNotFoudException {
		Optional<User> user = repo.findByEmail(email);
		if(user.isPresent()) {
			User user2 = user.get();
			return user2.getConfirmPwd();
		}
		return "User Not Found With This Email : "+email;
	}
	
	private static String passwordUsingName(String name) {

		  // Get the first 4 letters of the name and capitalize the first letter
		  String initials = name.substring(0, 1).toUpperCase() + name.substring(1, Math.min(name.length(), 4));
		  // Generate 4 random numbers
		  int randomNumber = 1000 + random.nextInt(9000);
		  // Concatenate initials and random numbers
		  String generatedString = initials + randomNumber;
		  return generatedString;
		 }


	@Override
	public List<User> getUser() {
		return repo.findAll();
	}

	
}
