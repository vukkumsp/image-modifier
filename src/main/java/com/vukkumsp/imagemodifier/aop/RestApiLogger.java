package com.vukkumsp.imagemodifier.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class RestApiLogger {
    /* 
     * For other functions call aop can't intercept as those calls won't have proxies
     * for example, any method call like this.method won't be able to intercepted
     * as it is self referenced.
     */

    private Logger logger = LoggerFactory.getLogger(RestApiLogger.class);

    @Before("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        logger.info("Start {}", joinPoint);
    }

    @After("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        logger.info("End {}", joinPoint);
    }
}
