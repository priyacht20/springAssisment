package com.springAssisment.springrest.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.GetUniqueUserIdResponse;
import com.springAssisment.springrest.response.GetUserListResponse;
import com.springAssisment.springrest.response.UpdateUserResponse;
import com.springAssisment.springrest.services.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/find/list")
	public GetUserListResponse getUserPosts() {
		return userService.findAllUser();
	}
	
	@GetMapping(value = "/find/uniqueUserIds")
	public GetUniqueUserIdResponse getUniqueUserIds() {
		return userService.findUniqueUser();	
	}
	
	@PostMapping(value = "/update")
	public UpdateUserResponse updateUserPost(@RequestBody User user) {
		User uPost = new User();
		uPost.setId(4);
		uPost.setTitle("1800Flowers");
		uPost.setBody("1800Flowers");
		return userService.updateUser(uPost);	
	}

}
