package com.feng.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.feng.context.RequestParamHolder;

public class WsyytInterceptor implements HandlerInterceptor {
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		// 解析请求参数信息
		RequestParamHolder.putRequestParam(request);
		System.out.println("---------------------------------");
		System.out.println(RequestParamHolder.get("key"));
		System.out.println("---------------------------------");
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
        if(arg2 == null) {

        }
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {

	}

	
}
