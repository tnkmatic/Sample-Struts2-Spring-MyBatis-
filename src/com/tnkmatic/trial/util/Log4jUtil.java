package com.tnkmatic.trial.util;

import org.apache.log4j.Logger;

public class Log4jUtil {

	/************************************************************************
	*
	*  ロガーの取得
	*  StackTraceの取得のためにThrowableを生成
	*  StackTraceには、クラスメソッドの呼び出し順に格納されている
	*  1番目は呼び出しクラス（本クラス）のため、2番目のクラスを用いる
	*
	*************************************************************************/
	public static Logger getLogger() {
		final String className = new Throwable().getStackTrace()[1].getClassName();
		return Logger.getLogger(className);
	}

	/************************************************************************
	*
	*  StartLog
	*
	*************************************************************************/
	public static void infoStartLog(
				final Logger logger, final String message) {
		logger.info(">> " + message + " :: start.");
	}

	/************************************************************************
	*
	*  EndLog
	*
	*************************************************************************/
	public static void infoFinishLog(
				final Logger logger, final String message) {
		logger.info("<< " + message + " :: finish.");
	}
}
