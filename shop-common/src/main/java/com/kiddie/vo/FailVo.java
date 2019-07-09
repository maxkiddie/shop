/**
 * 
 */
package com.kiddie.vo;

import com.kiddie.ienum.EnumSystem;
import com.kiddie.vo.base.BaseVo;

/**
 * @author xuzhaojie
 *
 *         2019年5月6日 上午11:59:30
 */
public class FailVo extends BaseVo {

	{
		setErrorEnum(EnumSystem.SYSTEM_ERROR);
	}

	private String fail;

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}
	
	
}
