package com.kiddie.zuul.filter.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;

public interface FilterInterface {

	default public HttpServletRequest getHttpServletRequest() {
		return RequestContext.getCurrentContext().getRequest();
	}

	default public void writeJson(Object object) {
		RequestContext context = RequestContext.getCurrentContext();
		try {
			// 获取返回值内容，加以处理
			HttpServletResponse response = context.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.getWriter().write(JSON.toJSONString(object));
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
