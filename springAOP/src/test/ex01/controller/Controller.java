package test.ex01.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Controller {
	public static void main(String [] args) throws Exception{
		String[] configLocations = new String[] { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		RunMain rm = (RunMain)context.getBean("rm");
		rm.message();
		//rm.throwEx();
	}
   
}
 