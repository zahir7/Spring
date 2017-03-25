package test.ex01.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
// BeforeAdvice 는 MethodBeforeAdvice 인터페이스를 구현해서 실행되며 
// 타켓메서드 실행되기전 동작한다.
public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Before method: " + arg0.getName());
	}
	
	
	// spring 2.x 버전이상 XML 적용 방식 
	public void hello(){
		System.out.println("before hello");
	}
	
	//대상 정보를 받아주기위한 JoinPoint 매개변수 구현
	public void hello(JoinPoint jp){
		System.out.println("before hello"+jp.getSignature());
	}
}
