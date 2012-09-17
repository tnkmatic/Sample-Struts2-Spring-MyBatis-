package com.tnkmatic.trial.struts2.action;

import java.util.ArrayList;
import java.util.List;

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
@Controller("userDeleteAction")
@Scope("prototype")
public class UserDeleteAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Log4jUtil.getLogger();

	@Autowired(required=true)
	private UserService userService;

	private List<UserEditInfoDto> userInfoDtoList;

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.struts2.action.BaseAction#init()
	 */
	@Override
	public void initAction() throws Exception {
		logger.info("### UserDeleteAction init ###");
		return;
	}

	/* (非 Javadoc)
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	@Action(value="/userdelete", results={
			@Result(name=ActionSupport.SUCCESS,
						type="redirectAction",
						location="userlist"
						)})
	public String execute() throws Exception {
		List<Integer> userIdList = new ArrayList<Integer>();

		for (final UserInfoDto userInfoDto : userInfoDtoList) {
			if (userInfoDto.getUserId() != null) {
				userIdList.add(userInfoDto.getUserId());
			}
		}

		if (userIdList.size() > 0) {
//			userService.deleteUser(userIdList);
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
	public List<UserEditInfoDto> getUserInfoDtoList() {
		return userInfoDtoList;
	}

	public void setUserInfoDtoList(List<UserEditInfoDto> userInfoDtoList) {
		this.userInfoDtoList = userInfoDtoList;
	}
}
