/**
 *
 */
package com.tnkmatic.trial.struts2.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
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

@Results({
	@Result(
		name=ActionSupport.INPUT,
		type="tiles",
		location="userMaintenance")
})
/******************************************************************************
*
* Spring Configuration Annotation
*
*****************************************************************************/
@Controller("userSearchAction")
@Scope("prototype")
public class UserSearchAction extends BaseAction {

	private static final long serialVersionUID = 1L;

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
	@Override
	public void initAction() throws Exception {
		logger.info("### UserSearchActin init ###");

/*
		if (userService == null) {
			userService = (UserService) ctx.getBean("userService");
		}
*/
/*
		String[] names = ctx.getBeanDefinitionNames();

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);

			if (!names[i].equals("search")) {
				final Object obj = ctx.getBean(names[i]);
				System.out.println(obj.toString());
			}
		}
*/
		return;
	}

	/* (非 Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	@Action(value="/userlist", results={
				@Result(name=ActionSupport.SUCCESS,
							type="tiles",
							location="userMaintenance")})
	public String execute() throws Exception {
		List<UserInfoDto> prevList 			= userInfoDtoList;
		Map<Integer, UserInfoDto> prevMap 	= new HashMap<Integer, UserInfoDto>();

		if (prevList != null) {
			for (int i = 0; i < prevList.size(); i++) {
				final UserInfoDto userInfoDto = prevList.get(i);
				prevMap.put(userInfoDto.getUserId(), userInfoDto);
			}
		}

		/**************************************************************************
		 * ユーザ一覧取得
		 *************************************************************************/
		userInfoDtoList = userService.getUserList(userCondDto);
		userCount = userInfoDtoList.size();

		/**************************************************************************
		 * チェックボックスの設定の復元
		 *************************************************************************/
		for (int i = 0; i < userInfoDtoList.size(); i++) {
			final UserInfoDto userInfoDto =
					prevMap.get(userInfoDtoList.get(i).getUserId());
			if (userInfoDto != null) {
				userInfoDtoList.get(i).setIsProc(userInfoDto.getIsProc());
			}
		}

		return ActionSupport.SUCCESS;
	}

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.action.BaseAction#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		logger.info("### UserSearchActin destory ###");
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

	@VisitorFieldValidator
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


