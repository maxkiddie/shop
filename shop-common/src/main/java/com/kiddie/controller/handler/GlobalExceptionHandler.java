/**
 * 
 */
package com.kiddie.controller.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.kiddie.exception.BusinessException;
import com.kiddie.exception.DataNotFoundException;
import com.kiddie.exception.RemoteApiException;
import com.kiddie.exception.ValidateException;
import com.kiddie.ienum.EnumSystem;
import com.kiddie.vo.ErrorVo;
import com.kiddie.vo.ResultVo;
import com.kiddie.vo.base.BaseVo;

/**
 * 控制器全局处理器
 * 
 * @author xuzhaojie
 *
 *         2019年5月12日 上午8:58:23
 */
@ControllerAdvice
public abstract class GlobalExceptionHandler {
	private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, BusinessException e) {
		ResultVo vo = new ResultVo();
		vo.setErrorEnum(e.getErrorEnum());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler(value = DataNotFoundException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, DataNotFoundException e) {
		ResultVo vo = new ResultVo();
		vo.setErrorEnum(e.getErrorEnum());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
	}

	@ExceptionHandler(value = ValidateException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, ValidateException e) {
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.DATA_NOT_MATCH);
		vo.setErrors(e.getErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler(value = RemoteApiException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, RemoteApiException e) {
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.REMOTE_IP_ERROR);
		vo.putError("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.PARAM_FORMAT_ERROR);
		vo.putError("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.PARAM_FORMAT_ERROR);
		vo.putError("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionMyHandler(HttpServletRequest req, HttpMediaTypeNotAcceptableException e) {
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.PARAM_FORMAT_ERROR);
		vo.putError("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
	}

	@ExceptionHandler
	@ResponseBody
	public ResponseEntity<BaseVo> exceptionHandler(HttpServletRequest req, Exception e) {
		String requestURI = req.getRequestURI();
		e.printStackTrace();
		String msg = requestURI + "出现异常:" + e.getMessage();
		log.error(msg);
		ErrorVo vo = new ErrorVo();
		vo.setErrorEnum(EnumSystem.SYSTEM_ERROR);
		vo.putError("error", msg);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(vo);
	}
}
