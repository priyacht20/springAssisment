package com.springAssisment.springrest.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPropertyReader {

	@Value("${user-post.base.url}")
	private String userPostUrl;

	public String getUserPostUrl() {
		return userPostUrl + "/posts";
	}


	
	
}
