/*
 ******************************************************************************
 *
 *  UserEditAction.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.struts2.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tnkmatic.trial.dto.UserEditInfoDto;
import com.tnkmatic.trial.dto.UserInfoDto;
import com.tnkmatic.trial.service.UserService;
import com.tnkmatic.trial.util.Log4jUtil;

/******************************************************************************
*
* Struts2 Configuration Annotation
*
*****************************************************************************/
@ParentPackage("trial.package")
@InterceptorRefs(
	{@InterceptorRef("trial.interceptor.package.interceptor-stack")})

/******************************************************************************
*
* Spring Configuration Annotation
*
*****************************************************************************/
@Controller("userEditAction")
@Scope("prototype")
public class UserEditAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Log4jUtil.getLogger();

	@Autowired(required=true)
	private UserService userService;

	private UserEditInfoDto userEditInfoDto;

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.struts2.action.BaseAction#init()
	 */
	@Override
	public void initAction() throws Exception {
		logger.info("### UserEditAction init ###");
		return;
	}

	/* (非 Javadoc)
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	@Action(value="/useredit", results={
			@Result(name=ActionSupport.SUCCESS,
						type="redirectAction",
						location="userlist"
						)})
	public String execute() throws Exception {
		userService.editUser(userEditInfoDto);
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return
	 * @throws Exception
	 * ユーザ編集用ダイアログの表示
	 */
	@Action(value="/userdialog", results={
			@Result(name=ActionSupport.SUCCESS,
						type="tiles",
						location="userMaintenancePopup")})
	public String showUserEditDialog() throws Exception {
		/**************************************************************************
		 * 更新の場合のみ対象ユーザを取得
		 *************************************************************************/
		if (userEditInfoDto.getEditMode() == 2) {
			UserInfoDto userInfoDto =
					userService.getUserByPrimaryKey(userEditInfoDto.getUserId());
			BeanUtils.copyProperties(userEditInfoDto, userInfoDto);
		}

		return ActionSupport.SUCCESS;
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.struts2.action.BaseAction#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		return;
	}

	/**************************************************************************
	 *
	 *  getter,setter
	 *
	 *************************************************************************/
	public UserEditInfoDto getUserEditInfoDto() {
		return userEditInfoDto;
	}

	public void setUserEditInfoDto(UserEditInfoDto userEditInfoDto) {
		this.userEditInfoDto = userEditInfoDto;
	}
}
