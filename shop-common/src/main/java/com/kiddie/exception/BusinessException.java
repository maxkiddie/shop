/**
 * 
 */
package com.kiddie.exception;

import com.kiddie.ienum.base.IErrorEnum;

/**
 * @author xuzhaojie
 *
 *         2018年8月3日 上午11:54:23
 */
public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IErrorEnum errorEnum;

	public BusinessException(String message) {
		this(message, null);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(IErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}

	/**
	 * @return the errorEnum
	 */
	public IErrorEnum getErrorEnum() {
		return errorEnum;
	}

	/**
	 * @param errorEnum
	 *            the errorEnum to set
	 */
	public void setErrorEnum(IErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}

}
