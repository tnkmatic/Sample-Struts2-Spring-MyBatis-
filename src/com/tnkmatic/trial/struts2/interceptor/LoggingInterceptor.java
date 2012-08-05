package com.tnkmatic.trial.struts2.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tnkmatic.trial.util.Log4jUtil;

public class LoggingInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Log4jUtil.getLogger();

	/**************************************************************************
	 *
	 *  Struts2用のログ出力インターセプタの実装
	 *
	 *************************************************************************/
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final String actionName =
				invocation.getProxy().getConfig().getClassName();
		final String methodName =
				invocation.getProxy().getMethod();

		Log4jUtil.infoStartLog(logger, actionName + " # " + methodName);

		final String resultCode = invocation.invoke();

		Log4jUtil.infoFinishLog(logger, actionName + " # " + methodName);

		return resultCode;
	}
}
