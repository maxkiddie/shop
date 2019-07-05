/**
 * 
 */
package com.kiddie.vo;

import com.kiddie.ienum.base.IErrorEnum;
import com.kiddie.vo.base.BaseVo;

/**
 * @author xuzhaojie
 *
 *         2019年5月6日 上午11:59:30
 */
public class ResultVo extends BaseVo {
	public ResultVo() {

	}

	public ResultVo(IErrorEnum e) {
		this.setErrorEnum(e);
	}
}
