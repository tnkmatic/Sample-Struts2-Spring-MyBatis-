package com.tnkmatic.trial.data;

import java.util.List;

import com.tnkmatic.trial.annotation.sqlMapper;
import com.tnkmatic.trial.dto.UserCondDto;
import com.tnkmatic.trial.dto.UserEditInfoDto;
import com.tnkmatic.trial.dto.UserInfoDto;

@sqlMapper
public interface UserMapper {
	/**************************************************************************
	 *
	 *  ユーザ一覧情報の取得
	 *
	 *************************************************************************/
	public List<UserInfoDto> getUserList(UserCondDto userCondDto) throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ一情報の登録
	 *
	 *************************************************************************/
	public void insertUserInfo(UserEditInfoDto userEditInfoDto) throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ一情報の更新
	 *
	 *************************************************************************/
	public void udpateUserInfo(UserEditInfoDto userEditInfoDto) throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ一情報の削除
	 *
	 *************************************************************************/
	public void deleteUserInfo(List<UserCondDto> userCondDtoList) throws Exception;

}
