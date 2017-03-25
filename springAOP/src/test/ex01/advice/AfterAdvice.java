package test.ex01.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

import org.springframework.aop.AfterReturningAdvice;

// Ÿ�� �޼��� ������ �������� ���� ����
public class AfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("After method: " + arg1.getName());
	}
	
	// spring 2.x �����̻� XML ���� ��� 
	public void helloReturn(){
		System.out.println("helloAfterReturn");
	}
	public void helloAfter(){
		System.out.println("helloAfter");
	}
	
	//��� ������ �޾��ֱ����� JoinPoint �Ű����� ����
	public void hello(JoinPoint jp){
		System.out.println("after hello"+jp);
	}
}
