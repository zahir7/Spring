package test.ex01.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// Before , AtferRturning ��� ó���Ҽ��ִ�. 
// �޼��� ������ ProceedingJoinPoint �� �ݵ��� �Ű������� ���޹޾ƾ��Ѵ�. 
public class AroundAdvice {
	public void helloAround(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("around before");
		Object obj = jp.proceed();
		System.out.println("around after");
	}
}
