package com.springAssisment.springrest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springAssisment.springrest.controler.UserController;
import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.GetUniqueUserIdResponse;
import com.springAssisment.springrest.response.GetUserListResponse;
import com.springAssisment.springrest.response.UpdateUserResponse;
import com.springAssisment.springrest.services.UserDAO;
import com.springAssisment.springrest.services.UserService;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserRestControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Mock
	private UserDAO userDAO;
	
	@Value("${local.server.port}")
    private Integer port;
	
	public final String BASE_URL = "http://localhost:9094/springrest";

	public String getBaseUrl() {
		return BASE_URL.replace("9094", port.toString());
	}

	@Test
	void testGetUserPosts() {
		GetUserListResponse response = new GetUserListResponse();
		response.setUserPost(new ArrayList<>());
		response.setStatus(HttpStatus.FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userService.findAllUser()).thenReturn(response);
		assertEquals(HttpStatus.FOUND, userController.getUserPosts().getStatus());
	}
	
	@Test
	void testGetUserPostsWithException() {
		GetUserListResponse response = new GetUserListResponse();
		response.setUserPost(new ArrayList<>());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userService.findAllUser()).thenReturn(response);
		assertEquals(HttpStatus.NOT_FOUND, userController.getUserPosts().getStatus());
	}

	@Test
	void testGetUniqueUserIds() {
		GetUniqueUserIdResponse response = new GetUniqueUserIdResponse();
		response.setUserIdCount(1l);
		response.setStatus(HttpStatus.OK);
		response.setMessage("Unique User Ids Found");	
		when(userService.findUniqueUser()).thenReturn(response);
		assertEquals(HttpStatus.OK, userController.getUniqueUserIds().getStatus());   
	}
	
	@Test
	public void updateUserPost() {
		RestTemplate restTemplate = new RestTemplate();
		final String updateUserPostUrl = getBaseUrl() + "/user/update";
		User user = new User();
		ResponseEntity<UpdateUserResponse> updateResponse = restTemplate.postForEntity(updateUserPostUrl, user, UpdateUserResponse.class);
		assertEquals(HttpStatus.OK, updateResponse.getBody().getStatus()); 
	}

}
