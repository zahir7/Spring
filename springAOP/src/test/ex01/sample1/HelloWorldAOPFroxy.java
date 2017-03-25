/*
	AOP 를 활용한 HelloWorld
	1. cglib.jar 라이브러리 추가 
	2. 프록시 는 Struts 의 인터셉터 역할을 수행한다. 
*/
package test.ex01.sample1;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.MethodBeforeAdvice;

import test.ex01.advice.*;

public class HelloWorldAOPFroxy {
	public static void main(String[] args)throws Exception {
		//join point - target 실행될 메서드 
        MessageWriter target = new MessageWriter();    
        // 프록시 생성
        ProxyFactory pf = new ProxyFactory();
        
        // 1.어드바이스 추가
        //pf.addAdvice(new MessageDecorator());
        //pf.addAdvice(new TestDecorator());
        
        // 2.Before Advice는 하나의 joinpoint를 실행하기 전에 Advice에서 지정한 기능을 수행
        pf.addAdvice(new BeforeAdvice());  
       
        // 3.AfterAdvice  Advice는 하나의 joinpoint를 실행한 후에 Advice에서 지정한 기능을 수행
        pf.addAdvice(new AfterAdvice());
        
        // 4.ThrowsAdvice 예외발생시 지정된 기능수행
        pf.addAdvice(new ThrowAdvice());
        
        pf.setTarget(target);
        // 추가된 어드바이스를 활용한 MessageWriter 생성
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        
        //target.writeMessage();
        //System.out.println("");
        proxy.writeMessage(); 
        //proxy.errorTestMethod();
        
    }

}
