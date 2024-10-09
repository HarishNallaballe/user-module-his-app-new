//package com.user.rest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.user.dto.UpdatePwd;
//import com.user.entity.User;
//import com.user.exception.UserNotFoudException;
//import com.user.rest.UserController;
//import com.user.service.UserService;
//
//@WebMvcTest(controllers = UserController.class)
//public class UserControllerTest {
//
//	@MockBean
//	private UserService userService;
//
//	@Autowired
//	private MockMvc mockMvc;
//
////	ObjectMapper obj=new ObjectMapper();
////	ObjectWriter objectWriter=obj.writer();
//	
////	  @Test
////	  public void checkEmailUnique() throws Exception {
////	    
////	  when(userService.checkEmailUnique(Mockito.anyString())).thenReturn("Duplicate Email");
////		  
////	  MockHttpServletRequestBuilder req =
////	  MockMvcRequestBuilders.get("/unique/{email}","email");
////	  
////	  MvcResult result = mockMvc.perform(req).andReturn();
////	  
////	  MockHttpServletResponse response = result.getResponse();
////	  
////	  String contentAsString = response.getContentAsString();
////	  System.out.println(contentAsString);
////	  
////	  //int status = response.getStatus();
////	  
////	  assertEquals("Duplicate Email", contentAsString);
////	  
////	  }
////	  
////	  @Test
////	  public void forgotPwdTest() throws Exception {
////		  when(userService.forgotPwd(Mockito.anyString())).thenReturn("harish123");
////		  
////		  MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/forgot/{email}","email");
////		  
////		  MvcResult result = mockMvc.perform(req).andReturn();
////		  
////		  MockHttpServletResponse response = result.getResponse();
////		  
////		  String contentAsString = response.getContentAsString();
////		  assertEquals("harish123", contentAsString);
////	  }
////	  
////	  @Test
////	  public void updatePwdTest() throws UserNotFoudException,Exception {
////		  
////		  UpdatePwd updatePwd = new UpdatePwd("harish123","nalla123","nalla123");
////		  User user = new User();
////		  BeanUtils.copyProperties(updatePwd, user);
////		  String string = objectWriter.writeValueAsString(user);
////		  when(userService.updatePwd(any(UpdatePwd.class))).thenReturn("Pwd");
////		  
////		  MockHttpServletRequestBuilder put = MockMvcRequestBuilders.put("/update")
////				                                      .contentType(MediaType.APPLICATION_JSON)
////				                                      .accept(MediaType.APPLICATION_JSON)
////				                                      .content(string);
////		  String contentAsString = mockMvc.perform(put).andReturn().getResponse()
////				                                       .getContentAsString();
////		  System.out.println(contentAsString);
////		  assertEquals("Pwd", contentAsString);
////				                          
////	  }
////
////	
////		/*
////		 * public void register() throws Exception {
////		 * 
////		 * UserDTO userdto = new UserDTO("harish","harish12@gmail.com","6300369259");
////		 * 
////		 * User user = new User();
////		 * 
////		 * BeanUtils.copyProperties(userdto, user);
////		 * 
////		 * String string = objectWriter.writeValueAsString(user);
////		 * 
////		 * MockHttpServletRequestBuilder req =
////		 * MockMvcRequestBuilders.post("/register").contentType(MediaType.
////		 * APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON) .content(string);
////		 * ResultActions result = mockMvc.perform(req).andExpect(status().isCreated())
////		 * .andExpect(jsonPath("$", notNullValue()))
////		 * .andExpect(jsonPath("$.name",is("harish"))); assertEquals(201, result); }
////		 */
////	
////	
//}
