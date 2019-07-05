package com.kiddie.zuul.filter.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.kiddie.vo.ErrorVo;
import com.kiddie.zuul.filter.base.FilterInterface;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ErrorFilter extends ZuulFilter implements FilterInterface {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return -10;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		Throwable throwable = context.getThrowable();
		logger.error("this is a ErrorFilter :{}", throwable.getMessage());
		ErrorVo vo = handleException(throwable);
		context.remove("throwable");
		writeJson(vo);
		return null;
	}

	private ErrorVo handleException(Throwable throwable) {
		ErrorVo vo = new ErrorVo();
		vo.putError("error", throwable.getMessage());
		return vo;
	}
}
