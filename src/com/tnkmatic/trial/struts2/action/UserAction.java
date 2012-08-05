package com.tnkmatic.trial.struts2.action;

import com.opensymphony.xwork2.Action;

public interface UserAction extends Action {
	/**************************************************************************
	 *
	 *  ユーザ一覧
	 *
	 *************************************************************************/
	public String searchUser() throws Exception;

	/**************************************************************************
	 *
	 *  ユーザ編集
	 *
	 *************************************************************************/
	public String showUserPopup() throws Exception;


}
