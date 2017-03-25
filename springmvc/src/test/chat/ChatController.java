package test.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChatController {
	
	public ChatController(){
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
		} catch (Exception e) {
			System.out.println("해당 포트가 사용중입니다.");
			System.exit(0);
		}		
		try{
			while(true){
				System.out.println("Server Ready...");
				// 클라이언트의 연결요청이 접수되면
				// 해당 클라이언트와 통신할 Socket 을 생성
				Socket socket = server.accept();
				// 클라이언트와 메세지를 송수신할 UnicastServerThread 생성
				// UnicastServerThread 생성시 Socket 을 전달함
				
				UnicastServerThread thread = 
						new UnicastServerThread(socket);
						// UnicastServerThread 의 start()를 호출함
				thread.start();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/form.do")
	public String form(){
		return "/test/form.jsp";
	}
	

}
