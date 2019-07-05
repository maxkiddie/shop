/**
 * 
 */
package com.kiddie.vo.base;

import com.kiddie.ienum.EnumSystem;
import com.kiddie.ienum.base.IErrorEnum;

/**
 * @author xuzhaojie
 *
 *         2019年5月7日 上午10:00:19
 */
public abstract class BaseVo {
	private Integer code;
	private String msg;

	{
		setErrorEnum(EnumSystem.SUSS);
	}

	public void setErrorEnum(IErrorEnum e) {
		this.code = e.getCode();
		this.msg = e.getMsg();
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

}
