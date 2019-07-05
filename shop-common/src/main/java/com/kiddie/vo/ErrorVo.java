/**
 * 
 */
package com.kiddie.vo;

import java.util.HashMap;
import java.util.Map;

import com.kiddie.ienum.EnumSystem;
import com.kiddie.vo.base.BaseVo;

/**
 * @author xuzhaojie
 *
 *         2019年5月6日 上午11:59:30
 */
public class ErrorVo extends BaseVo {
	private Map<String, String> errors = new HashMap<String, String>();

	{
		setErrorEnum(EnumSystem.SYSTEM_ERROR);
	}

	public void putError(String key, String value) {
		this.errors.put(key, value);
	}

	/**
	 * @return the errors
	 */
	public Map<String, String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
