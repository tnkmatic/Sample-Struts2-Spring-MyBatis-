/**
 *
 */
package com.tnkmatic.trial.struts2.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.tnkmatic.trial.dto.UserCondDto;
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

//@ParentPackage("struts-default")
//@Namespace("/test")

/******************************************************************************
*
* Spring Configuration Annotation
*
*****************************************************************************/
@Controller("userSearchAction")
@Scope("prototype")
public class UserSearchAction extends BaseAction {
	@SuppressWarnings(value = { "unused" })
	private static Logger logger = Log4jUtil.getLogger();
	@Autowired(required=true)
	private UserService userService;

	private UserCondDto userCondDto;
	private List<UserInfoDto> userInfoDtoList;
	private Integer userCount;

	/**************************************************************************
	 * Spring AOP と DI を併せて使用すると、インジェクションが出来ないため
	 * ApplicationContextから直接取得
	 *************************************************************************/
	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.action.BaseAction#init()
	 */
	@Override
	public void init() throws Exception {
		/*
		if (userService == null) {
			userService = (UserService) ctx.getBean("userService");
		}*/
		return;
	}

	/* (非 Javadoc)
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	@Action(value="/userlist", results={
				@Result(name=ActionSupport.SUCCESS,
							type="tiles",
							location="userMaintenance")})
	public String execute() throws Exception {
		/**************************************************************************
		 * ユーザ一覧取得
		 *************************************************************************/
		userInfoDtoList = userService.getUserList(userCondDto);
		userCount = userInfoDtoList.size();

		return ActionSupport.SUCCESS;
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.action.BaseAction#destroy()
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
	public UserCondDto getUserCondDto() {
		return userCondDto;
	}

	public void setUserCondDto(UserCondDto userCondDto) {
		this.userCondDto = userCondDto;
	}

	public List<UserInfoDto> getUserInfoDtoList() {
		return userInfoDtoList;
	}

	public void setUserInfoDtoList(List<UserInfoDto> userInfoDtoList) {
		this.userInfoDtoList = userInfoDtoList;
	}

	public Integer getUserCount() {
		return userCount;
	}
}


