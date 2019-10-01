package chating;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Openwindow extends JPanel
{
	private Main main;
	//private JButton loginButton;
	private JFrame frame,frame2,frame3;
	private static JLabel image1,image2;
	private static ImageIcon ic1,ic2;
	private static JPasswordField passText;
	private static JTextField userText;
	private static boolean bLoginCheck;
	private static JButton btnRegi;
	private static JButton btnLogin;
	
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
            	//Openwindow login = new Openwindow();
            	LoginPage();
            }  
        });
        
        
     //   public void placeLoginPanel(JPanel panel) {
       // 	panel.setLayout(null);
        //	JLabel userLabel = new JLabel()
        //}
		//frame.getContentPane().add(openwindow);
		frame.add(image1);
		frame.setBounds(200,300,640,360); 
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void LoginPage() {	// login누르면 나오는 페이지  출력
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
       /**
        * 
        * 
        * image2가 나오지 못하고 있는데 해결점 ㅎㅎㅎ0
        * 
        * 
        * 
        */
        frame2.add(image2);	
    	frame2.setBounds(200,300,640,360);   
        frame2.setVisible(true);
    	frame2.setResizable(false);
    	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void registerPage() {	// register 누르면 나오는 page
		frame2.dispose();
		frame3 = new JFrame("register");
		frame3.setBounds(200, 300, 300, 550);
		
		frame3.setLayout(null);
        JLabel EmailLabel = new JLabel("Email");
        EmailLabel.setBounds(20,150,80,25);
        frame3.add(EmailLabel);
        
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(20,180,80,25);
        frame3.add(userLabel);
        
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20,210,80,25);
        frame3.add(passLabel);
        
        userText = new JTextField(20);
	    userText.setBounds(110,150,160,25);
	    frame3.add(userText);
        		
		userText = new JTextField(20);
	    userText.setBounds(110,180,160,25);
	    frame3.add(userText);
	       	
	    passText = new JPasswordField(20);
	    passText.setBounds(110,210,160,25);
	    frame3.add(passText);
	    
	    frame3.setVisible(true);
		frame3.setResizable(false);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void mainSetting(Main main) {
		this.main=main;
	}
	
	public static void checkLogin() {
		if (userText.getText().equals("admin")&& new String(passText.getPassword()).equals("admin")) {
			JOptionPane.showMessageDialog(null, "sucess");
			bLoginCheck = true;
			
			if(isLogin()) {
				//showFrameText();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "fail");
	}
	
	public static boolean isLogin() {
		return bLoginCheck;
	}
}

