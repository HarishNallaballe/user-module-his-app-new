package com.user.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.user.constants.AppConstants;
import com.user.dto.SignInDto;
import com.user.dto.UpdatePwd;
import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoudException;
import com.user.service.UserService;

@RestController
public class UserController {
	
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestHeader("his-correlation-id") String correlationId, @RequestBody UserDTO userDTO){
		String message = service.register(userDTO);
		logger.info("his-correlation-id : "+correlationId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> signIn(@RequestHeader("his-correlation-id") String correlationId,@RequestBody SignInDto signInDto) throws UserNotFoudException{
		logger.info("his-correlation-id : "+correlationId);
		boolean signin = service.signin(signInDto);
		if(signin) {
			return new ResponseEntity<String>(AppConstants.SIGNED_SUCCESFULLY,HttpStatus.OK);
		}
		return new ResponseEntity<String>(AppConstants.NO_USER_FOUND+signInDto.getEmail(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePwd(@RequestHeader("his-correlation-id") String correlationId,@RequestBody UpdatePwd updatePwd) throws UserNotFoudException{
		logger.info("his-correlation-id : "+correlationId);
		String updated = service.updatePwd(updatePwd);
			return new ResponseEntity<String>(updated,HttpStatus.OK);
	}
	
	@GetMapping("/unique/{email}")
	public ResponseEntity<String> checkEmailUnique(@RequestHeader("his-correlation-id") String correlationId,@PathVariable String email){
		logger.info("his-correlation-id : "+correlationId);
		String message = service.checkEmailUnique(email);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

	@GetMapping("/forgot/{email}")
	public ResponseEntity<String> forgotPwd(@RequestHeader("his-correlation-id") String correlationId,@PathVariable String email) throws UserNotFoudException{
		logger.info("his-correlation-id : "+correlationId);
		String message = service.forgotPwd(email);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(@RequestHeader("his-correlation-id") String correlationId){
		logger.info("his-correlation-id : "+correlationId);
		List<User> user = service.getUser();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}

}
