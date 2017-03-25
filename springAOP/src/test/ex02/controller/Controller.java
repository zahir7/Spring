package test.ex02.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Controller {
	public static void main(String [] args) throws Exception{
		String[] configLocations = new String[] { "applicationContext2.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		RunMain rm = (RunMain)context.getBean("rm");
		rm.message();
		//rm.throwEx();
	}
   
}
 