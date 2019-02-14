package com.annotation.annotationImpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {
    @Pointcut("@annotation(com.annotation.annotationImpl.WoToken)")
    private void cut() {
        //切点
    }
    @Around("cut()&&@annotation(woToken)")
    public Object advice(ProceedingJoinPoint joinPoint, WoToken woToken) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (int i= 0;i<args.length;i++) {
            String argValue = (String) args[i];
            String s = argValue + woToken.value();
            args[i] = s;
        }
        Object proceed = joinPoint.proceed(args);
        return proceed;
    }

}
