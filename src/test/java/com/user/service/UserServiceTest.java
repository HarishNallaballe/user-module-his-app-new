package com.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.dto.SignInDto;
import com.user.dto.UpdatePwd;
import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoudException;
import com.user.repo.UserRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void registerUserTest_DuplicateEmail() {
		UserDTO dto = new UserDTO(1,"hari","hari@gmail.com","6300369259");
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		when(userRepository.save(user)).thenReturn(user);
		String message = userServiceImpl.register(dto);
		assertThat("Already user present with given email id : hari@gmail.com").isEqualTo(message);
	}
	
//	@Test
//	public void registerUser_Savetest() {
//		UserDTO dto = new UserDTO(1,"hari","hari1@gmail.com","6300369259");
//		User user = new User();
//		BeanUtils.copyProperties(dto, user);
//		when(userRepository.save(user)).thenReturn(user);
//		String message = userServiceImpl.register(dto);
//		assertEquals("User Saved Successfully", message);
//	}
	
	@Test
	public void checkEmailUniqueTest() {
		String email="kala1@gmail.com";
		User user = new User();
		when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
		String checkEmailUnique = userServiceImpl.checkEmailUnique(email);
		assertThat(checkEmailUnique).isEqualTo("Already user present with given email id : "+email);
	}
	
	@Test
	public void signInTest() throws UserNotFoudException {
			SignInDto signInDto = new SignInDto();
			signInDto.setEmail("shilpa@gmail.com");
			signInDto.setPassword("Shil6610");
			User user = new User();
			when(userRepository.findByEmailAndConfirmPwd(signInDto.getEmail(), signInDto.getPassword())).thenReturn(Optional.of(user));
			boolean signin = userServiceImpl.signin(signInDto);
			assertEquals(true, signin);
	}
	
//	@Test
//	public void sigiTest() {
//		SignInDto signInDto = new SignInDto();
//		assertThrows(UserNotFoudException.class, ()->userServiceImpl.signin(signInDto));
//	}

	
//	@Test
//	public void forgotPasswordTest() throws UserNotFoudException {
//		User user = new User();
//		when(userRepository.findByEmail("kala1@gmail.com")).thenReturn(Optional.of(user));
//		String forgotPwd = userServiceImpl.forgotPwd("kala1@gmail.com");
//		System.out.println(forgotPwd);
//		assertThat("Harish").isEqualTo(forgotPwd);
//	}
	
	@Test
	public void getUsersTest() {
		List<User> list=new ArrayList<>();
				list.add(new User(1,"harish","harish@gmail.com","1234567"));
				list.add(new User(2,"harish","harish@gmail.com","1234567"));
				list.add(new User(3,"harish","harish@gmail.com","1234567"));
				
		when(userRepository.findAll()).thenReturn(list);
		List<User> user = userServiceImpl.getUser();
		assertThat(user).isEqualTo(list);
	}
	
	@Test
	public void checkEmailUniqueTetsFail() {
		String email="kala1@gmail.com";
		when(userRepository.findByEmail(email)).thenReturn(null);
		String checkEmailUnique = userServiceImpl.checkEmailUnique(email);
		assertEquals("No User found with email : "+email, checkEmailUnique);
	}
	
	@Test
	public void updateUserTest() throws UserNotFoudException {
		UpdatePwd updatePwd = new UpdatePwd(1,"hari5678","hari123","hari123");
		User user = new User();
		BeanUtils.copyProperties(updatePwd, user);
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		
		String updatePwd2 = userServiceImpl.updatePwd(updatePwd);
		
		assertEquals("User Entered the Wrong Password", updatePwd2);
	}
	
	
	@Test
	public void forgotPwdTest() throws UserNotFoudException {
		String email="kala1@gmail.com";
		when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
		String forgotPwd = userServiceImpl.forgotPwd(email);
		assertEquals("User Not Found With This Email : "+email, forgotPwd);
	}
//	@Test
//	public void updateUserTest() throws UserNotFoudException {
//		UpdatePwd pwd = new UpdatePwd("Shil6610","Shilpa","Shilpa");
//		User user = new User();
//		BeanUtils.copyProperties(pwd, user);
//		
//		when(userRepository.save(user)).thenReturn(user);
//		
//		String updatePwd = userServiceImpl.updatePwd(pwd);
//		System.out.println(updatePwd);
//		assertEquals("Password Saved Succesfully", updatePwd);
//	}
	
	
	
	

}
