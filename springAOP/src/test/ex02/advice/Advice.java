package test.ex02.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


// @Aspect를 붙여줘야 Advice가 된다.
@Aspect
public class Advice {


	@Around("execution(public * test.ex02.controller..*(..))")
	public void around(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("around before");
		Object obj = jp.proceed();
		System.out.println("around after");
	}
	
	@Before("execution(public * test.ex02.controller..*(..))")
	public void before(){
		System.out.println("before");
	}
	
	@After("execution(public * test.ex02.controller..*(..))")
	public void after(){
		System.out.println("after");
	}
	
	@AfterReturning("execution(public * test.ex02.controller..*(..))")
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	@AfterThrowing("execution(public * test.ex02.controller..*(..))")
	public void afterThrowing(){
		System.out.println("afterThrowing");
	}
	
}
