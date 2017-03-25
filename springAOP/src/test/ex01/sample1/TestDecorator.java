package test.ex01.sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestDecorator implements MethodInterceptor {
	  public Object invoke(MethodInvocation invocation) throws Throwable {
	        System.out.print("test ");
	        Object obj = invocation.proceed();  // ���ͼ��� ȣ�� ������
	        System.out.println("@");
	        return obj;
	    }
}
