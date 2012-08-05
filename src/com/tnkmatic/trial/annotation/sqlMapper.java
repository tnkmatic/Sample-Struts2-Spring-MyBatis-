package com.tnkmatic.trial.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author eiichi
 * org.mybatis.spring.mapper.MapperScannerConfigurer
 * でのDAOクラス検出用
 */
@Retention (RetentionPolicy.RUNTIME)
public @interface sqlMapper { }
