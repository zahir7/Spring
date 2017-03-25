/*
	AOP �� Ȱ���� HelloWorld
	1. cglib.jar ���̺귯�� �߰� 
	2. ���Ͻ� �� Struts �� ���ͼ��� ������ �����Ѵ�. 
*/
package test.ex01.sample1;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.MethodBeforeAdvice;

import test.ex01.advice.*;

public class HelloWorldAOPFroxy {
	public static void main(String[] args)throws Exception {
		//join point - target ����� �޼��� 
        MessageWriter target = new MessageWriter();    
        // ���Ͻ� ����
        ProxyFactory pf = new ProxyFactory();
        
        // 1.�����̽� �߰�
        //pf.addAdvice(new MessageDecorator());
        //pf.addAdvice(new TestDecorator());
        
        // 2.Before Advice�� �ϳ��� joinpoint�� �����ϱ� ���� Advice���� ������ ����� ����
        pf.addAdvice(new BeforeAdvice());  
       
        // 3.AfterAdvice  Advice�� �ϳ��� joinpoint�� ������ �Ŀ� Advice���� ������ ����� ����
        pf.addAdvice(new AfterAdvice());
        
        // 4.ThrowsAdvice ���ܹ߻��� ������ ��ɼ���
        pf.addAdvice(new ThrowAdvice());
        
        pf.setTarget(target);
        // �߰��� �����̽��� Ȱ���� MessageWriter ����
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        
        //target.writeMessage();
        //System.out.println("");
        proxy.writeMessage(); 
        //proxy.errorTestMethod();
        
    }

}
