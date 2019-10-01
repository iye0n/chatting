import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class StartsServer {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
 
            ServerSocket server = new ServerSocket(6000);
            while (true) {
                Socket client = server.accept();
                TransLator translator = new TransLator(client);
                translator.start();
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
class TransLator extends Thread {
    Socket client;
    TransLator(Socket client) {
        this.client = client;
    }
    public void run() {
        try {
            
            System.out.println(getTime() + "Client has accepted...");
 
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(client.getOutputStream());
 
            String readData = "";
 
            while (!(readData = br.readLine()).equals(null)){
 
                System.out.println( "from Client > " + readData);
 
                if (readData.equals("apple")) {
                    sleep(5000);
                    pw.println("���");
                    pw.flush();
                }else if (readData.equals("grape")) {
                    sleep(5000);
                    pw.println("����");
                    pw.flush();
                }else if (readData.equals("orange")) {
                    sleep(5000);
                    pw.println("������");
                    pw.flush();
                }else if (readData.equals("mandoo")) {
                    sleep(5000);
                    pw.println("����");
                    pw.flush();
                }else if (readData.equals("exit")){
                    break;
                }else {
                    readData = readData + "�� ������ �� �����ϴ�...";
                    pw.println(readData);
                    pw.flush();
                }
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
    public static String getTime() {
        String threadName = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + threadName;
    }
 
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
[��ó] [Java ����] ���ڼ������� : ��Ƽ ������ ����, Ŭ���̾�Ʈ|�ۼ��� ����� fit