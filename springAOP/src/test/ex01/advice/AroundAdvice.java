package test.ex01.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// Before , AtferRturning 모두 처리할수있다. 
// 메서드 구현시 ProceedingJoinPoint 를 반듯이 매개변수로 전달받아야한다. 
public class AroundAdvice {
	public void helloAround(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("around before");
		Object obj = jp.proceed();
		System.out.println("around after");
	}
}
