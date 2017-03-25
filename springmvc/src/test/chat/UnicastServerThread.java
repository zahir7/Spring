package test.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UnicastServerThread extends Thread{
	// 서버로부터 전달된 Socket(클라이언트와 연결된)을 저장
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	// run()의 재정의
	public void run() {
		// 스트림 연결
		try {
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// client 와 송수신
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			while(true){
				// client 가 전달한 메세지 수신하기
				String msg = br.readLine();
				System.out.println(msg);
				// client 로 메세지 재전송
				bw.write(msg + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			// 클라이언트와 연결이 끊어진 경우 발생
			InetAddress ip = socket.getInetAddress();
			String address  = ip.getHostAddress();
			System.out.println("["+address+"] 와의 연결이 끊어졌습니다.");			
		}
	}
}
