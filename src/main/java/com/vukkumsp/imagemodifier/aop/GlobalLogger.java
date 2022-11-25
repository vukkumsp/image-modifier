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
public class GlobalLogger {
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
