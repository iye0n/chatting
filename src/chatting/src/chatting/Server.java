package chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>();	// listWriters  : 메시지 왔다갔다 하는거
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.43.74", 8080));
			
			System.out.println("192.168.43.74");
			
			while(true) {
				System.out.println("waiting....");
				Socket socket = serverSocket.accept();
				new ChatServerProcessThread(socket,listWriters).start();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("accept: "+isa.getHostName());
				
			}
		}
		catch (Exception except){
		}
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			}
			catch(IOException ioexcept){
			}
		}
	}
	
	private static void consolLog(String log){
		System.out.println("{server "+ Thread.currentThread().getId()+"} "+ log);
	}
}
