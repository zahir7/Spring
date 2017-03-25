package test.ex01.advice;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;

//Ÿ�� �޼��� ������ ���ܹ߻��Ұ�� 
public class ThrowAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }
	
	// spring 2.x �����̻� XML ���� ��� 
	//public void hello(){
//		System.out.println("Throw hello");
	//}
	
	//���ܹ߻� ������ �޾��ֱ����� Throwable �Ű����� ����
	public void hello(Throwable ex){
		System.out.println("Throw hello"+ex);
	}
}
