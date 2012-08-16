/*
 ******************************************************************************
 *
 *  UserServiceImpl.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnkmatic.trial.data.UserMapper;
import com.tnkmatic.trial.dto.UserCondDto;
import com.tnkmatic.trial.dto.UserEditInfoDto;
import com.tnkmatic.trial.dto.UserInfoDto;
import com.tnkmatic.trial.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired(required=true)
	private UserMapper userMapper;

	/* (非 Javadoc)
	 * @see com.tnkmatic.trail.service.UserService#getUserList(com.tnkmatic.trial.dto.UserCondDto)
	 */
	@Override
	@Transactional
	public List<UserInfoDto> getUserList(UserCondDto userCondDto)
			throws Exception {
		final List<UserInfoDto> list = userMapper.getUserList(userCondDto);

		return list;
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.service.UserService#getUserByPrimaryKey(java.lang.String)
	 */
	@Override
	@Transactional
	public UserInfoDto getUserByPrimaryKey(Integer condUserId) throws Exception {
		final UserCondDto userCondDto = new UserCondDto();

		userCondDto.setCondUserId(condUserId);

		final List<UserInfoDto> list = userMapper.getUserList(userCondDto);

		return list.get(0);
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.service.UserService#editUser(com.tnkmatic.trial.dto.UserEditInfoDto)
	 */
	@Override
	@Transactional
	public void editUser(UserEditInfoDto userEditInfoDto) throws Exception {
		if (userEditInfoDto.getEditMode() == 1) {
			userMapper.insertUserInfo(userEditInfoDto);
		} else if (userEditInfoDto.getEditMode() == 2) {
			userMapper.udpateUserInfo(userEditInfoDto);
		} else {
			return;
		}
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.service.UserService#deleteUser(com.tnkmatic.trial.dto.UserCondDto)
	 */
	@Override
	public void deleteUser(List<Integer> userIdList) throws Exception {
		userMapper.deleteUserInfo(userIdList);
	}
}
