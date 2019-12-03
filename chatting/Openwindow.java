package chatting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Openwindow extends JPanel
{   
   Menu menu;
   //private JButton loginButton;
   private JFrame frame;
   private static JFrame frame2;
   private JFrame frame3;
   private static JLabel image1,image2;
   private static ImageIcon ic1,ic2;
   private static JPasswordField passText;
   private static JTextField userText,nameText;
   private static boolean bLoginCheck;
   private static JButton btnRegi;
   private static JButton btnLogin;
   //protected static Server serverchatwin;
   //protected static Client clientchatwin;
   
   
   public static void main(String[] args) {
   }
   public Openwindow() {
      frame = new JFrame("수지");
      ic1 = new ImageIcon("./image2.png");
      image1 = new JLabel(ic1);
      
      JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(110, 100, 75, 55);
        frame.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               LoginPage();
            }  
        });
        
      frame.add(image1);
      frame.setBounds(200,300,640,360); 
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void LoginPage() {   // login누르면 나오는 페이지  출력
      frame.dispose();
      frame2 = new JFrame("수지");
   
      ic2 = new ImageIcon("./image2.png");
      image2 = new JLabel(ic2);
       
       //frame2.setLayout(null);
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(20,80,80,25);
        frame2.add(userLabel);
        
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20,110,80,25);
        frame2.add(passLabel);
           
        userText = new JTextField(20);
        userText.setBounds(110,80,160,25);
        frame2.add(userText);
           
        passText = new JPasswordField(20);
        passText.setBounds(110,110,160,25);
        frame2.add(passText);
        passText.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              checkLogin();
           }
        });
        
        btnRegi = new JButton("Register");
        btnRegi.setBounds(20,150,100,25);
        frame2.add(btnRegi);
        btnRegi.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              registerPage();
           }
        });
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(170,150,100,25);
        frame2.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              checkLogin();
           }
        });
       
        frame2.add(image2);   
       frame2.setBounds(200,300,640,360);   
        frame2.setVisible(true);
       frame2.setResizable(false);
       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public void registerPage() {   // register 누르면 나오는 page
      frame2.dispose();
      
      frame3 = new JFrame("register");
      
      frame3.setLayout(null);
        JLabel NameLabel = new JLabel("Name");
        NameLabel.setBounds(20,40,80,25);
        frame3.add(NameLabel);
        
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(20,70,80,25);
        frame3.add(userLabel);
        
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20,100,80,25);
        frame3.add(passLabel);
        
        btnLogin.setBounds(20,130,100,25);
        frame3.add(btnLogin);
       
        btnLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              frame3.dispose();
              LoginPage();
           }
        });
        
        nameText = new JTextField(20);
       nameText.setBounds(110,40,160,25);
       frame3.add(nameText);
              
      userText = new JTextField(20);
       userText.setBounds(110,70,160,25);
       frame3.add(userText);
             
       passText = new JPasswordField(20);
       passText.setBounds(110,100,160,25);
       frame3.add(passText);
       
       frame3.add(image1); 
      frame3.setBounds(200,300,640,360);
      frame3.setVisible(true);
      frame3.setResizable(false);
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void mainSetting(Main main) {
   }
   
   public static void checkLogin() {
      if ((userText.getText().equals("admin")&& new String(passText.getPassword()).equals("admin"))|
    		  (userText.getText().equals("client")&& new String(passText.getPassword()).equals("client"))) {
         JOptionPane.showMessageDialog(null, "sucess");
         bLoginCheck = true;
         
         if(isLogin()) {
            //showFrameText();
        	 if(userText.getText().equals("admin")) {
        		 frame2.dispose();
            	 Menu menu= new Menu("admin");
        	 }
        	 else {
        		 frame2.dispose();
            	 Menu menu= new Menu("client");
        	 }
        	
        	 //menu.OpenwindowSetting(openwindow);
            //Openwindow  openwindow = new Openwindow();
            //openwindow.menu=new Menu("admin");
            //openwindow.menu.OpenwindowSetting(openwindow);
            //openwindow.serverchatwin = new Server();
            //openwindow.clientchatwin=new Client();
            /*serverchatwin = new Server();
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            clientchatwin = new Client();*/
            //Openwindow openwindow = new Openwindow();
            //if(openwindow.getName().equals(""))
            //   openwindow.menu=new Menu(null);
            //else
            //   openwindow.menu=new Menu(openwindow.getName());
            
            //openwindow.menu.OpenwindowSetting(openwindow);
         }
      }
      else if(userText.getText().equals("")&&new String(passText.getPassword()).equals("")) {
         // register 페이지에서 login페이지 누르면 fail뜨는 문제 해결하기 위해 만들었음. 코드 추가할 필요 없음.   
      }
      else
         JOptionPane.showMessageDialog(null, "fail");
   }
   public String getName() {
      return nameText.getText();
   }
   
   public static boolean isLogin() {
      return bLoginCheck;
   }
}