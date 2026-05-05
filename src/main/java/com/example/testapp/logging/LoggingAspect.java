package com.example.testapp.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.example.testapp.controller..*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("REQUEST: {} args={}", joinPoint.getSignature(), joinPoint.getArgs());

        Object response = joinPoint.proceed();

        log.info("RESPONSE: {}", response);

        return response;
    }
}