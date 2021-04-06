package com.springAssisment.springrest.services;

import java.util.List;

import com.springAssisment.springrest.domain.User;



public interface UserDAO {
      
	public List<User> findAll();
	public User updateUser(User user);
}
