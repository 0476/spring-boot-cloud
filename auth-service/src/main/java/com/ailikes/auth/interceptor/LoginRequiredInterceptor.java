//package com.ailikes.auth.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
///**
// * @author ailikes
// * @date 2018-06-01
// * @version 1.0.0
// */
//public class LoginRequiredInterceptor extends HandlerInterceptorAdapter {
//
//	private final Logger logger = LoggerFactory.getLogger(LoginRequiredInterceptor.class);
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		logger.info(request.getRequestURI());
//		return super.preHandle(request, response, handler);
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		logger.info(request.getRequestURI());
//		super.afterCompletion(request, response, handler, ex);
//	}
//}