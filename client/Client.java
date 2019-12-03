package client;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class Client {
	static String nickname;
	static Socket socket;
	public static void main(String args[]) throws IOException {
		try {
			nickname="client";
			String serverIp = "127.0.0.1";
			socket = new Socket(serverIp,7777);
			System.out.println("서버에 연결중입니다. 서버IP :"+serverIp);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			dos.writeUTF(nickname+"님이 입장했습니다.");
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		String nickname = "client";
		Client cc = new Client(nickname);
	}
	Frame f ;
	TextArea ta;
	TextField tf;
	Panel pp, p;

	InputStream is = null;
	OutputStream os = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	public Client(String nickname) throws IOException{
		f = new Frame("Client");

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


	
		is = socket.getInputStream();
		os = socket.getOutputStream();
		dis = new DataInputStream(is);
		dos = new DataOutputStream(os);

		ThreadReader tReader = new ThreadReader(dis,ta);
		//ThreadSender tSender = new ThreadSender(dos,tf,nickname);
		tReader.start();
		//tSender.start();


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