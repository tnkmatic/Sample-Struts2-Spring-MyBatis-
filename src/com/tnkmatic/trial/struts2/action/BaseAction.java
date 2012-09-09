package com.tnkmatic.trial.struts2.action;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport
	implements ApplicationContextAware {

	private static final long serialVersionUID = 1L;

	protected ApplicationContext ctx;

	/**************************************************************************
	 *
	 *  インスタンス初期化時
	 *
	 *************************************************************************/
	@PostConstruct
	public abstract void init() throws Exception;

	/**************************************************************************
	 *
	 *  Spring ApplicationContextの取得用
	 *
	 *************************************************************************/
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.ctx = arg0;
	}

	/**************************************************************************
	 *
	 *  インスタンス破棄時
	 *
	 *************************************************************************/
	@PreDestroy
	public abstract void destroy() throws Exception;

}
