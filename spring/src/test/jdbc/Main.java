package test.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static SelectUI selectui;
	public void setSelectui(SelectUI selectui) {
		this.selectui = selectui;
	}
	
	public static void main(String [] args){
		 ApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
	     Main m = (Main) context.getBean("main");
	     m.selectui.show();
	}
}
