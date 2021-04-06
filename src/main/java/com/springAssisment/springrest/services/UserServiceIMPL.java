package com.springAssisment.springrest.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.GetUniqueUserIdResponse;
import com.springAssisment.springrest.response.GetUserListResponse;
import com.springAssisment.springrest.response.UpdateUserResponse;


@Service
public class UserServiceIMPL implements UserService {

	
    @Autowired
    private UserDAO userDAO;

	@Override
	public GetUniqueUserIdResponse findUniqueUser() {
		GetUniqueUserIdResponse response = new GetUniqueUserIdResponse();
		try {
			List<User> findAllUserPostResponse = userDAO.findAll();
			Long uniqueUserIdCount = findAllUserPostResponse != null ? findAllUserPostResponse.stream().map(User::getUserId)
					.distinct().count() : null;
			response.setUserIdCount(uniqueUserIdCount);
			response.setStatus(HttpStatus.OK);
			response.setMessage("Unique User Ids Found");	
		}catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setUserIdCount(0l);
			response.setStatus(HttpStatus.NOT_FOUND);
		}
		return response;
	}



	@Override
	public GetUserListResponse findAllUser() {
		GetUserListResponse response = new GetUserListResponse();
		List<User> users = userDAO.findAll();
		if (!users.isEmpty()) {
			response.setUserPost(users.stream().collect(Collectors.toList())); 
			response.setStatus(HttpStatus.FOUND);
			response.setMessage("user post list found");
		}else {
			response.setUserPost(null); 
			response.setStatus(HttpStatus.NOT_FOUND);
			response.setMessage("user post list not found");
		}
		return response;
	}



	@Override
	public UpdateUserResponse updateUser(User user) {
		User updatedUserPost = userDAO.updateUser(user);
		UpdateUserResponse response = new UpdateUserResponse();
		response.setUser(updatedUserPost);
		if(updatedUserPost != null) {
			response.setStatus(HttpStatus.OK);
			response.setMessage("User Post Updated Successfully");
		}else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("User Post Updated Successfully");
		}
		return response;
	}
	
	
	
}
