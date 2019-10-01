package chating;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpIpClient {
	 private static final Logger LOG = LoggerFactory.getLogger(TcpIpClient.class);
	    
	    public static void main(String[] args) {
	        String serverIp = "127.0.0.1";
	        try(Socket socket = new Socket(serverIp, 8080)){
	            
	            // 입력스트림 
	            InputStream in = socket.getInputStream();
	            DataInputStream dis = new DataInputStream(in);
	            
	            // 데이터 출력 
	            LOG.info("message : " + dis.readUTF());
	            
	            dis.close();
	        }catch(IOException e) {
	            LOG.error(e.toString());
	        }
	    }
}
