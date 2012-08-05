/*
 ******************************************************************************
 *
 *  UserCondDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

public class UserCondDto extends BaseDto {
	private Integer	userId;			//ユーザID
	private String		userName;		//ユーザ名

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}