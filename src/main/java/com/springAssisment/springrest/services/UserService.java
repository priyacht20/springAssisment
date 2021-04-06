package com.springAssisment.springrest.services;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.GetUniqueUserIdResponse;
import com.springAssisment.springrest.response.GetUserListResponse;
import com.springAssisment.springrest.response.UpdateUserResponse;

public interface UserService {

	public GetUserListResponse findAllUser();
	public GetUniqueUserIdResponse findUniqueUser();
	public UpdateUserResponse updateUser(User user);
	
}
