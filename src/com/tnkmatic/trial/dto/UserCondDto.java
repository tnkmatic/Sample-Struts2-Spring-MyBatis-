/*
 ******************************************************************************
 *
 *  UserCondDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

public class UserCondDto extends BaseDto {
	private Integer	condUserId;		//ユーザID
	private String		condUserName;	//ユーザ名

	public Integer getCondUserId() {
		return condUserId;
	}

	public void setCondUserId(Integer condUserId) {
		this.condUserId = condUserId;
	}

	public String getCondUserName() {
		return condUserName;
	}

	public void setCondUserName(String condUserName) {
		this.condUserName = condUserName;
	}
}