package test.ex01.sample1;

public class MessageWriter {
	  public void writeMessage() {
	        System.out.println("World");
	  }
	  public void writeKoMessage() {
	        System.out.println("�ȳ��ϼ���");
	  }
	  public void errorTestMethod() throws Exception {
		  throw new Exception("���� �����߻�");
	  }
}
