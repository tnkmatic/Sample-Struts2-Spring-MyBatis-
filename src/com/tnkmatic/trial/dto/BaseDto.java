/*
 ******************************************************************************
 *
 *  BaseDto.java
 *
 ******************************************************************************
 */
package com.tnkmatic.trial.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseDto {

	/******************************************************************************
	 *
	 * Beanの内容をわかりやすく表示
	 *
	 *****************************************************************************/
	public String toString() {
		return ReflectionToStringBuilder.toString(
					this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
