package test.ex01.advice;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;

//타겟 메서드 동작중 예외발생할경우 
public class ThrowAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }
	
	// spring 2.x 버전이상 XML 적용 방식 
	//public void hello(){
//		System.out.println("Throw hello");
	//}
	
	//예외발생 정보를 받아주기위한 Throwable 매개변수 구현
	public void hello(Throwable ex){
		System.out.println("Throw hello"+ex);
	}
}
