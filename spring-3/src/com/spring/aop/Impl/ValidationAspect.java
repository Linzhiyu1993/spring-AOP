package com.spring.aop.Impl;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)//使用order指定切面的优先级，值越小优先级越高
@Aspect
@Component
public class ValidationAspect {
   @Before("execution (public int com.spring.aop.Impl.CalculatorImpl.*(..))")
   public void validateArgs(JoinPoint joinPoint)
   {
	   System.out.println("validate "+Arrays.asList(joinPoint.getArgs()));
   }
}
