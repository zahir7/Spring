package test.ex01.sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestDecorator implements MethodInterceptor {
	  public Object invoke(MethodInvocation invocation) throws Throwable {
	        System.out.print("test ");
	        Object obj = invocation.proceed();  // 인터셉터 호출 기준점
	        System.out.println("@");
	        return obj;
	    }
}
