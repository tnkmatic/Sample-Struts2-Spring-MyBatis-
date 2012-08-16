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
import com.opensymphony.xwork2.ModelDriven;
import com.tnkmatic.trial.dto.UserEditInfoDto;
import com.tnkmatic.trial.service.UserService;
import com.tnkmatic.trial.util.Log4jUtil;
import com.tnkmatic.trial.util.StaticValues;

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
public class UserDeleteAction extends BaseAction
		implements ModelDriven<UserEditInfoDto> {

	@SuppressWarnings(value = { "unused" })
	private static Logger logger = Log4jUtil.getLogger();
	@Autowired(required=true)
	private UserService userService;

	private UserEditInfoDto userEditInfoDto = new UserEditInfoDto();

	/* (非 Javadoc)
	 * @see com.tnkmatic.trial.struts2.action.BaseAction#init()
	 */
	@Override
	public void init() throws Exception {
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

		if (userEditInfoDto.getKeys() != null) {
			for (final Integer userId : userEditInfoDto.getKeys()) {
				if (userId != null) {
					userIdList.add(userId);
				}
			}

			//以降の処理では未使用
			userEditInfoDto.setEditMode(StaticValues.EDIT_MODE_DELETE);
		}

		if (userIdList.size() > 0) {
			userService.deleteUser(userIdList);
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
	@Override
	public UserEditInfoDto getModel() {
		return userEditInfoDto;
	}


}
