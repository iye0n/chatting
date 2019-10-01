package chating;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TcpIpServer {
	 private static final Logger LOG = LoggerFactory.getLogger(TcpIpServer.class);
	    
	    public static void main(String[] args) {
	        try(ServerSocket serverSocket = new ServerSocket(8080)){
	            while(true) {
	                // ��û�� ���ö����� ���, Ŭ���̾�Ʈ�� �����û�� ������ Ŭ���̾�Ʈ���ϰ� ����� ������ ��ȯ
	                Socket socket = serverSocket.accept(); 
	                LOG.info(socket.getInetAddress() +"�κ��� �����û�� ���Խ��ϴ�.");
	                
	                // ��½�Ʈ�� 
	                OutputStream out = socket.getOutputStream();
	                DataOutputStream dos = new DataOutputStream(out);
	                
	                dos.writeUTF("Message from server");
	                LOG.info("�޽��� ���� �Ϸ�");
	                
	                dos.close();
	            }
	        }catch(IOException e) {
	            LOG.error(e.toString());
	        }
	        
	    }
}
