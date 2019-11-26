package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class ChatServerProcessThread extends Thread{
	private String name = null;
	private Socket socket = null;
	List<PrintWriter> listWriters = null;
	
	public ChatServerProcessThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8));
			
			while(true) {
				String request = bufferedReader.readLine();
				
				if (request == null) {
					printLog("disconnected");
					quit(printWriter);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			printLog(this.name + "disconected");
		}
	}

	private void quit(PrintWriter printWriter) {
		// TODO Auto-generated method stub
		synchronized (printWriter) {
			((List<PrintWriter>) printWriter).remove(printWriter);
		}
		System.out.println(this.name+" disconnected");
		printWriter.flush();	
	}
	
	private void printMessage(String data) {
		synchronized (listWriters) {
			for(PrintWriter writer:listWriters) {
				writer.println(this.name+":"+data);
				writer.flush();
			}
		}
	}
	
	/*private void join() {
		
	}*/

	private void printLog(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}