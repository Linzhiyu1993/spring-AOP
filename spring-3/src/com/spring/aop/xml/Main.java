package com.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   public static void main(String[] args)
   {
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-xml.xml");
	   Calculator cal=ctx.getBean(Calculator.class);
	   
	   int result=cal.add(12, 3);
	   System.out.println("result "+result);
	   
	   result=cal.div(10, 2);
	   System.out.println("result "+result);
   }
}
