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
			System.out.println("�ش� ��Ʈ�� ������Դϴ�.");
			System.exit(0);
		}		
		try{
			while(true){
				System.out.println("Server Ready...");
				// Ŭ���̾�Ʈ�� �����û�� �����Ǹ�
				// �ش� Ŭ���̾�Ʈ�� ����� Socket �� ����
				Socket socket = server.accept();
				// Ŭ���̾�Ʈ�� �޼����� �ۼ����� UnicastServerThread ����
				// UnicastServerThread ������ Socket �� ������
				
				UnicastServerThread thread = 
						new UnicastServerThread(socket);
						// UnicastServerThread �� start()�� ȣ����
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
