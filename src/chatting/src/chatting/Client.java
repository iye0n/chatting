package chatting;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("request...");
			socket.connect(new InetSocketAddress("172.20.10.2",8080));
			System.out.println("success");
			//데이터를 내보내는  Stream : 해임달(Socket)객체에게 무지개로드(Stream)을 열어달라고!!

			OutputStream os= socket.getOutputStream();//바이트 스트림


			//보조스트림을 이용하면 write()작업이 보다 수월함.

			OutputStreamWriter osw= new OutputStreamWriter(os);//문자스트림

			PrintWriter writer = new PrintWriter(os); //보조 문자스트림			

			System.out.println("스트림 연결작업 성공!!..데이터전송 가능상태");
			//InputStreamReader, OutputStreamWriter
			

			//보낼 데이터를 키보드로 입력받기

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("보낼 메세지 입력 : ");

			String msg= scanner.nextLine();

			

			//스트림을 통해서 데이터 전송!

			writer.println(msg);

			writer.flush();

			writer.close();

			

			System.out.println("메세지 전송이 완료 되었습니다.");		

			

		} catch (IOException e) {

			System.out.println("서버와 통신이 불가합니다.");

		}catch(Exception except) {}
		if(!socket.isClosed()) {
			try {
				socket.close();
			}catch(IOException ioexcept) {}
		}
	}
}