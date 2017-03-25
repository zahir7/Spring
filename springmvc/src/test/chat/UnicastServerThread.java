package test.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UnicastServerThread extends Thread{
	// �����κ��� ���޵� Socket(Ŭ���̾�Ʈ�� �����)�� ����
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	// run()�� ������
	public void run() {
		// ��Ʈ�� ����
		try {
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// client �� �ۼ���
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			while(true){
				// client �� ������ �޼��� �����ϱ�
				String msg = br.readLine();
				System.out.println(msg);
				// client �� �޼��� ������
				bw.write(msg + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			// Ŭ���̾�Ʈ�� ������ ������ ��� �߻�
			InetAddress ip = socket.getInetAddress();
			String address  = ip.getHostAddress();
			System.out.println("["+address+"] ���� ������ ���������ϴ�.");			
		}
	}
}
