/*
 ******************************************************************************
 *
 *  UserEditInfoDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

public class UserEditInfoDto extends UserInfoDto {
	int editMode;		// 1:登録 2:更新

	public int getEditMode() {
		return editMode;
	}

	public void setEditMode(int editMode) {
		this.editMode = editMode;
	}

}
