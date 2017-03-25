package test.ex01.sample1;

public class MessageWriter {
	  public void writeMessage() {
	        System.out.println("World");
	  }
	  public void writeKoMessage() {
	        System.out.println("안녕하세요");
	  }
	  public void errorTestMethod() throws Exception {
		  throw new Exception("예외 강제발생");
	  }
}
