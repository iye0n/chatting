package chatting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Openwindow extends JPanel
{
	private Main main;
	//private JButton loginButton;
	private JFrame frame;
	private static JFrame frame2;
	private JFrame frame3;
	private Menu menu;
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
		frame = new JFrame("����");
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
	public void LoginPage() {	// login������ ������ ������  ���
		frame.dispose();
		frame2 = new JFrame("����");
	
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
	
	
	public void registerPage() {	// register ������ ������ page
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
        
        userText = new JTextField(20);
	    userText.setBounds(110,40,160,25);
	    frame3.add(userText);
        		
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
		this.main=main;
	}
	
	public static void checkLogin() {
		if (userText.getText().equals("admin")&& new String(passText.getPassword()).equals("admin")) {
			JOptionPane.showMessageDialog(null, "sucess");
			bLoginCheck = true;
			
			if(isLogin()) {
				//showFrameText();
				frame2.dispose();
				Openwindow openwindow = new Openwindow();
				openwindow.menu=new Menu();
				openwindow.menu.menuSetting(openwindow);
			}
		}
		else if(userText.getText().equals("")&&new String(passText.getPassword()).equals("")) {
			// register ���������� login������ ������ fail�ߴ� ���� �ذ��ϱ� ���� �������. �ڵ� �߰��� �ʿ� ����.
		}
		else
			JOptionPane.showMessageDialog(null, "fail");
	}
	
	public static boolean isLogin() {
		return bLoginCheck;
	}
}
