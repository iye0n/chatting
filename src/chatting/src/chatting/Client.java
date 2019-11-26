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
			//�����͸� ��������  Stream : ���Ӵ�(Socket)��ü���� �������ε�(Stream)�� ����޶��!!

			OutputStream os= socket.getOutputStream();//����Ʈ ��Ʈ��


			//������Ʈ���� �̿��ϸ� write()�۾��� ���� ������.

			OutputStreamWriter osw= new OutputStreamWriter(os);//���ڽ�Ʈ��

			PrintWriter writer = new PrintWriter(os); //���� ���ڽ�Ʈ��			

			System.out.println("��Ʈ�� �����۾� ����!!..���������� ���ɻ���");
			//InputStreamReader, OutputStreamWriter
			

			//���� �����͸� Ű����� �Է¹ޱ�

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("���� �޼��� �Է� : ");

			String msg= scanner.nextLine();

			

			//��Ʈ���� ���ؼ� ������ ����!

			writer.println(msg);

			writer.flush();

			writer.close();

			

			System.out.println("�޼��� ������ �Ϸ� �Ǿ����ϴ�.");		

			

		} catch (IOException e) {

			System.out.println("������ ����� �Ұ��մϴ�.");

		}catch(Exception except) {}
		if(!socket.isClosed()) {
			try {
				socket.close();
			}catch(IOException ioexcept) {}
		}
	}
}