package chating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
 
public class TestClient {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Socket                soc;     // ������ ������ ����
        BufferedReader        br;      // ������ ���� �޼����� ���� ����
        PrintWriter            pw;      // ������ �޼����� ���� ������
        Scanner                scan;   // ����ڰ� �Է��� �����͸� ���� ��ĳ��
        
        try{
            
            soc = new Socket("localhost",6000);
            System.out.println(getTime() + "Accept to Server Success!!");
            // ����� �����κ��� �����͸� �޾ƿ� �غ� �Ѵ�
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            // ����� ������ �����͸� ���� �غ� �Ѵ�
            pw = new PrintWriter(soc.getOutputStream());
            scan = new Scanner(System.in);
            System.out.println("now, you can use translator!!");
            String inputData = "";
            
            while(!inputData.equals("exit")){
                System.out.printf(getTime()+"to Server > ");
                
                inputData = scan.nextLine();
                pw.println(inputData);
                pw.flush();
                System.out.println(getTime() + "from Server > "+br.readLine());
            }
            soc.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();            
        }
 
    }
    
    static String getTime(){
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
 
}
