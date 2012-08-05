package com.tnkmatic.trial.framework.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tnkmatic.trial.util.Log4jUtil;

@Aspect
@Component("loggingAspect")
public class LoggingAspect {
	private static Logger logger = Log4jUtil.getLogger();

	/******************************************************************************
	 * Pointcut定義
	 * Serviceアノテーションを付与しているサービスを対象
	 *****************************************************************************/
	@Pointcut("@within(org.springframework.stereotype.Service) ||"
					+ "@within(org.springframework.stereotype.Component)")
	//@Pointcut("within(com.tnkmatic.trial.service.*)")
	public void pointcut() {}

	/******************************************************************************
	 * Advisorの定義
	 * pointcut()のフィルタに合致したときにロギング処理を実行
	 *****************************************************************************/
	@Around(value = "pointcut()")
	public Object loggingProcess(ProceedingJoinPoint jp) throws Throwable {
		Log4jUtil.infoStartLog(logger, targetSignature(jp));

		final Object obj = jp.proceed();

		Log4jUtil.infoFinishLog(logger, targetSignature(jp));

		return obj;
	}

	/******************************************************************************
	 * Advisorの定義
	 * 例外発生時のコンソール出力
	 * throwing属性はメソッドのThrowableの引数名と同名を指定する
	 *****************************************************************************/
	@AfterThrowing(value = "pointcut()", throwing = "ex")
	public void loggingAfterThrowing(JoinPoint jp, Throwable ex) {
		logger.error("##### AfetrThrowing ######");
		logger.error(ex.getMessage(), ex);
	}

	private String targetSignature(final ProceedingJoinPoint jp) {
		final Signature signature = jp.getSignature();
		return signature.getDeclaringTypeName()
					+ " # " + signature.getName();
	}
}
