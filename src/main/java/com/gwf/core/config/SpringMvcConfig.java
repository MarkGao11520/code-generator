package com.gwf.core.config;

import com.alibaba.fastjson.JSON;
import com.gwf.core.business.core.Result;
import com.gwf.core.business.core.ResultCode;
import com.gwf.core.business.core.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/7/12.
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
    private final Logger logger = LoggerFactory.getLogger(SpringMvcConfig.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/connect");
    }

    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
                Result result = new Result();
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;

                    if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
                        result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
                        logger.info(e.getMessage());
                    } else {
                        result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                        String message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                        logger.error(message, e);
                    }
                } else {
                    if (e instanceof NoHandlerFoundException) {
                        result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
                    } else {
                        result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(e.getMessage());
                        logger.error(e.getMessage(), e);
                    }
                }
                responseResult(response, result);
                return new ModelAndView();
            }

        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
