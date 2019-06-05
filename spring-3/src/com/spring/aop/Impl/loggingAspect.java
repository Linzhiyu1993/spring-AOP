package com.spring.aop.Impl;
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
@Order(2)
@Aspect
@Component
public class loggingAspect {
	@Before("execution(public int com.spring.aop.Impl.CalculatorImpl.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint)
    {
		String methodName=joinPoint.getSignature().getName();
		Object[] args=joinPoint.getArgs();
    	System.out.println("The method"+methodName+" begins with "+args);
    }
	
	@After("execution(public int com.spring.aop.Impl.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint)
    {
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" end ");
    }
	
	@AfterReturning(value="execution(public int com.spring.aop.Impl.CalculatorImpl.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" end after returning "+result);
	}
	
	/**
	 * 在目标方法出现异常时只能够的代码
	 * 可以访问到异常对象；且可以指定在出现特殊异常时执行
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="execution(public int com.spring.aop.Impl.CalculatorImpl.*(..))",
			throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex)
	{
		String methodName=joinPoint.getSignature().getName();
    	System.out.println("The method"+methodName+" occurs exception "+ex);

	}
	
	/**
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 环绕通知类似于动态代理额全过程，ProceedingJoinPoint 这个类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须要有返回值，返回值即目标方法的返回值
	 * @param pjd
	 */
	@Around("execution(public int com.spring.aop.Impl.CalculatorImpl.*(..))")
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
