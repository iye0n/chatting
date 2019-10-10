package chatting;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			InetAddress inetaddress = InetAddress.getLocalHost();
			String localhost = inetaddress.getHostAddress();
			serverSocket.bind(new InetSocketAddress(localhost, 5000));
			
			System.out.println(localhost);
			
			while(true) {
				System.out.println("waiting....");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("accept: "+isa.getHostName());
			}
		}catch (Exception except){
		}
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			}catch(IOException ioexcept){
			}
		}
	}
}
