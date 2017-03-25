package test.ex01.controller;

public class RunMain {
	public void message(){
		System.out.println("test");
	}
	
	public void throwEx()throws Exception{
		throw new Exception("강제발생");
	}
}
