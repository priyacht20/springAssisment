package com.springAssisment.springrest.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.util.ApplicationPropertyReader;



@Repository
public class UserDaoIMPL implements UserDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApplicationPropertyReader applicationPropertyReader;
	
	
	@Override
	public List<User> findAll() {
		ResponseEntity<User[]> responseEntity = restTemplate
				.getForEntity(applicationPropertyReader.getUserPostUrl(), User[].class);
		if (responseEntity != null && responseEntity.getBody() != null) {
			return Arrays.asList(responseEntity.getBody()); 
		}
		return Collections.emptyList();
	}


	@Override
	public User updateUser(User user) {
		User foundUserPost = findAll().stream().filter(uPost -> user.getId().equals(uPost.getId()))
				.findFirst().get();
		foundUserPost.setTitle(user.getTitle());
		foundUserPost.setBody(user.getBody());
		return foundUserPost;
	}

}
