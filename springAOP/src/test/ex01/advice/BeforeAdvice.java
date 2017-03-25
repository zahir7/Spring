package test.ex01.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
// BeforeAdvice �� MethodBeforeAdvice �������̽��� �����ؼ� ����Ǹ� 
// Ÿ�ϸ޼��� ����Ǳ��� �����Ѵ�.
public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Before method: " + arg0.getName());
	}
	
	
	// spring 2.x �����̻� XML ���� ��� 
	public void hello(){
		System.out.println("before hello");
	}
	
	//��� ������ �޾��ֱ����� JoinPoint �Ű����� ����
	public void hello(JoinPoint jp){
		System.out.println("before hello"+jp.getSignature());
	}
}
