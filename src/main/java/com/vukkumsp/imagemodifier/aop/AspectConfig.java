package com.vukkumsp.imagemodifier.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.vukkumsp.imagemodifier.exceptions.GlobalException;

@Aspect
@Configuration
public class AspectConfig {
    
    /* 
     * Logging
     * 
     * Global Exception Handling
     * 
     * Time Taken
     * 
     */

    private Logger logger = LoggerFactory.getLogger(AspectConfig.class);


    @Before("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        logger.info("Executing {}", joinPoint);
    }

    @After("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        logger.info("End {}", joinPoint);
    }

    // Exception Handling

    @Around("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            Object obj = joinPoint.proceed();
            return obj;
        }
        catch(GlobalException ex){
            logger.info("Global Exception occurred");
        }
        return "throwException";
    }

    
}
