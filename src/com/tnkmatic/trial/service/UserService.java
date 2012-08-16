/*
 ******************************************************************************
 *
 *  UserService.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.service;

import java.util.List;

import com.tnkmatic.trial.dto.UserCondDto;
import com.tnkmatic.trial.dto.UserEditInfoDto;
import com.tnkmatic.trial.dto.UserInfoDto;

public interface UserService {
	/**************************************************************************
	 *
	 *  ユーザ一覧情報の取得
	 *
	 *************************************************************************/
	public List<UserInfoDto> getUserList(UserCondDto userCondDto) throws Exception;

	/**************************************************************************
	 *
	 *  特定ユーザ一の取得
	 *
	 *************************************************************************/
	public UserInfoDto getUserByPrimaryKey(Integer userId) throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ一情報の登録・更新
	 *
	 *************************************************************************/
	public void editUser(UserEditInfoDto userEditInfoDto) throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ一情報の削除
	 *
	 *************************************************************************/
	public void deleteUser(List<Integer> userIdList) throws Exception;
}
