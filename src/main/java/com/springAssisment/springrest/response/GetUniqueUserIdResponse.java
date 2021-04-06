package com.springAssisment.springrest.response;

import java.io.Serializable;

public class GetUniqueUserIdResponse extends BaseResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userIdCount;
	
	

	public Long getUserIdCount() {
		return userIdCount;
	}

	public void setUserIdCount(Long userIdCount) {
		this.userIdCount = userIdCount;
	}

	@Override
	public String toString() {
		return "UserIdResponse [userIdCount=" + userIdCount + "]";
	}
}
