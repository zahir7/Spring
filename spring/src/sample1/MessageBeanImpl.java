package sample1;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	  private String name;
	  private String greeting;
	  
	  private Outputter outputter;

	  @Override
	  public void sayHello() {
	    String message = greeting + name + "!";
	    System.out.println(message);
	    try {
	      outputter.output(message);
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	  }

	   public MessageBeanImpl(String name) {
	    this.name = name;
	  }
	 
	  public void setGreeting(String greeting) {
	    this.greeting = greeting;
	  }
	  
	  public void setOutputter(Outputter outputter) {
	    this.outputter = outputter;
	  }
}
