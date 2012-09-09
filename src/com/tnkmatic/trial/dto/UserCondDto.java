/*
 ******************************************************************************
 *
 *  UserCondDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class UserCondDto extends BaseDto {
	private Integer	condUserId;		//ユーザID
	private String		condUserName;	//ユーザ名
	private String		condPref;		//出身地
	private String		condTelNumber;	//電話番号

	public Integer getCondUserId() {
		return condUserId;
	}

	/*
	@Validations(
		intRangeFields= {
			@IntRangeFieldValidator(
				min="100"
				,max="999"
				,key="error.range.userid")})
	*/

	@Validations(
		intRangeFields={
			@IntRangeFieldValidator(
				min="100"
				,max="999"
				,key="error.range.userid")})
	public void setCondUserId(Integer condUserId) {
		this.condUserId = condUserId;
	}

	public String getCondUserName() {
		return condUserName;
	}

	public void setCondUserName(String condUserName) {
		this.condUserName = condUserName;
	}

	public String getCondPref() {
		return condPref;
	}

	public void setCondPref(String condPref) {
		this.condPref = condPref;
	}

	public String getCondTelNumber() {
		return condTelNumber;
	}

	public void setCondTelNumber(String condTelNumber) {
		this.condTelNumber = condTelNumber;
	}
}