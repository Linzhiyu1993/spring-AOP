package com.spring.aop.xml;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class loggingAspect {
    public void beforeMethod(JoinPoint joinPoint)
    {
		String methodName=joinPoint.getSignature().getName();
		Object[] args=joinPoint.getArgs();
    	System.out.println("The method"+methodName+" begins with "+args);
    }
	
	public void afterMethod(JoinPoint joinPoint)
    {
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" end ");
    }
	
	
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" end after returning "+result);
	}
	
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex)
	{
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" occurs exception "+ex);

	}
	
	public Object aroundMethod(ProceedingJoinPoint pjd )
	{
		Object result=null;
		String methodName=pjd.getSignature().getName();
		//执行目标方法
		try {
			System.out.println("The method "+methodName+"begins with"+Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
