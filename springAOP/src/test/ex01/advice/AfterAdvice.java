package test.ex01.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

import org.springframework.aop.AfterReturningAdvice;

// 타켓 메서드 동작이 정상종료 된후 동작
public class AfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("After method: " + arg1.getName());
	}
	
	// spring 2.x 버전이상 XML 적용 방식 
	public void helloReturn(){
		System.out.println("helloAfterReturn");
	}
	public void helloAfter(){
		System.out.println("helloAfter");
	}
	
	//대상 정보를 받아주기위한 JoinPoint 매개변수 구현
	public void hello(JoinPoint jp){
		System.out.println("after hello"+jp);
	}
}
