package com.gaoxiong.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gaoxiong
 * @ClassName TimeAop
 * @Description TODO
 * @date 2018/10/26 0:07
 */
@Aspect
@Component
public class TimeAop  {

    @Before("execution(* com.gaoxiong.webController.UserController.*(..))")
    public void befor(){

    }

    @After(value = "execution(* com.gaoxiong.webController.UserController.*(..))")
    public void after(){

    }

    @AfterThrowing(value = "bean(userController)")
    public void afterThrowing(){

    }
    @Around(value = "execution(* com.gaoxiong.webController.UserController.*(..))")
    @Pointcut(value = "execution(* com.gaoxiong.webController.UserController.*(..))")
    public void around( ProceedingJoinPoint point ){
        Object[] args = point.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
