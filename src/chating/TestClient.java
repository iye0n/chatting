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
        
        Socket                soc;     // 서버에 연결할 소켓
        BufferedReader        br;      // 서버가 보낸 메세지를 읽을 리더
        PrintWriter            pw;      // 서버로 메세지를 보낼 라이터
        Scanner                scan;   // 사용자가 입력한 데이터를 읽을 스캐너
        
        try{
            
            soc = new Socket("localhost",6000);
            System.out.println(getTime() + "Accept to Server Success!!");
            // 연결된 서버로부터 데이터를 받아올 준비를 한다
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            // 연결된 서버로 데이터를 보낼 준비를 한다
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
