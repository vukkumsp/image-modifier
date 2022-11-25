// package com.vukkumsp.imagemodifier.aop;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Configuration;

// import com.vukkumsp.imagemodifier.exceptions.GlobalException;

// @Aspect
// @Configuration
// public class GlobalExceptionHandler {
    
//     private Logger logger = LoggerFactory.getLogger(RestApiLogger.class);

//     @Around("execution(* com.vukkumsp.imagemodifier.rest.*.*(..))")
//     public Object handler(ProceedingJoinPoint joinPoint) throws Throwable{
//         try{
//             Object obj = joinPoint.proceed();
//             return obj;
//         }
//         catch(GlobalException ex){
//             logger.info("Global Exception occurred");
//         }
//         return "throwException"; //Handle it well
//     }
// }
