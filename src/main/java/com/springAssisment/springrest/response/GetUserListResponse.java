package com.springAssisment.springrest.response;

import java.util.List;

import com.springAssisment.springrest.domain.User;



public class GetUserListResponse extends BaseResponse {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> user;

	public List<User> getUserPost() {
		return user;
	}

	public void setUserPost(List<User> user) {
		this.user = user;
	}
       
    
}
