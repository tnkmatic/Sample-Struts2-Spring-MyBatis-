/*
 ******************************************************************************
 *
 *  UserInfoDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

public class UserInfoDto extends BaseDto {
	private Integer	userId;			//ユーザID
	private String		userName;		//ユーザ名
	private String		pref;			//出身地
	private String		telNumber;		//内線番号

	private Boolean		isProc;			//処理対象判別用

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

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Boolean getIsProc() {
		return isProc;
	}

	public void setIsProc(Boolean isProc) {
		this.isProc = isProc;
	}

}
