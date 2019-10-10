package chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("request...");
			socket.connect(new InetSocketAddress("192.168.11.1",5000));
			System.out.println("success");
		}catch(Exception except) {}
		if(!socket.isClosed()) {
			try {
				socket.close();
			}catch(IOException ioexcept) {}
		}
	}
}
