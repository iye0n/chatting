package server;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class Server {
	static String nickname;
	public static void main(String args[]) {
		nickname = "server";
		Server cs = new Server(nickname);
	}

	Frame f ;
	TextArea ta;
	TextField tf;
	Panel pp, p;

	InputStream is = null;
	OutputStream os = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	public Server(String nickname){
		f = new Frame("Server");

		ta = new TextArea();
		ta.setText("#" + nickname + "님 즐거운 채팅되세요.\n");
		ta.setEditable(false);

		tf = new TextField(30);
		pp = new Panel();
		p = new Panel();

		f.setBounds(100,100,300,200);
		f.setLayout(new BorderLayout());
		f.add(ta, "Center");

		pp.setLayout(new FlowLayout());
		pp.add(tf);
		pp.add(p);
		f.add(pp,"South");

		f.setVisible(true);

		try {
			ServerSocket serverSocket = new ServerSocket(7777);

			Socket socket = serverSocket.accept();
			ta.append(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.\n");


			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			dos.writeUTF(nickname+"님이 입장했습니다.");
			ThreadReader tReader = new ThreadReader(dis,ta);
			//ThreadSender tSender = new ThreadSender(dos,tf,nickname);
			tReader.start();
			//tSender.start();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				try {
					dos.writeUTF(nickname+"님이 퇴장했습니다.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					System.exit(0);
				}
			});

		tf.addActionListener(new EventHandler());

	}


	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String s = tf.getText();
			ta.append(nickname+" >> "+s);
			ta.append("\r\n");
			tf.setText("");

			try {
				dos.writeUTF(nickname+" >> "+s);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}

class ThreadReader extends Thread{

	DataInputStream dis;
	TextArea ta;

	ThreadReader(DataInputStream dis, TextArea ta){
		this.dis = dis;
		this.ta = ta;
	}

	public void run() {
		try {
			while(true) {
				String s = dis.readUTF();
				ta.append(s);
				ta.append("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
