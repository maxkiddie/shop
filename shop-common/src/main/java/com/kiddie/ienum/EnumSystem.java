/**
 * 
 */
package com.kiddie.ienum;

import com.kiddie.ienum.base.IErrorEnum;

/**
 * @author xuzhaojie
 *
 *         2018年11月12日 上午9:41:48
 */
public enum EnumSystem implements IErrorEnum{
	SUSS(0, "请求成功"),
	SYSTEM_ERROR(1000, "系统异常"),
	PARAM_ERROR(1001, "参数缺失"),
	PARAM_FORMAT_ERROR(1002, "参数格式错误"),
	DATA_NOT_MATCH(1003, "数据填写有误"),
	DATA_NOT_FOUND(1004, "找不到数据"),
	TOKEN_HAD_MODIFY(1005, "token被篡改"),
	TOKEN_EXPIRED(1005, "token已过期"),
	TOKEN_NOT_MATCH(1006, "token不匹配"),
	TOKEN_NOT_EXSIT(1007, "token是必须参数"),
	USER_CAN_NOT_GET(1008, "系统获取不到用户信息"),
	ADMIN_CAN_NOT_GET(1009, "系统获取不到管理员信息"),
	CODE_EXPIRED(1010, "验证码已过期"),
	CODE_ERROR(1011, "验证码不匹配"),
	DATA_REPEAT(1012, "表单重复提交"),
	NO_AUTH(1013, "没权限"),
	PWD_NOT_FIT(1014, "两次密码不匹配"),
	FILE_TYPE_NOT_FIT(1015, "文件类型不匹配"),
	CODE_PRD_ERROR(1016, "系统错误,获取后台验证码"),
	REMOTE_IP_ERROR(1017, "远程网络出现问题"),
	CREATE_FILE_ERROR(1018, "文件创建失败"),
	FILE_IO_ERROR(1019, "文件IO失败"),
	FILE_NOT_FOUND(1020, "文件源不存在"),
	PACK_FILE_ERROR(1021, "打包文件失败"),
	DEL_FILE_ERROR(1022, "删除文件失败");
	
	private Integer code;
	private String msg;

	private EnumSystem(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public int getCode() {
		return code;
	}
	
	@Override
	public String getMsg() {
		return msg;
	}

}
