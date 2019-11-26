package chatting;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class ChatWin extends Frame {
    String nickname = "";
    TextArea ta = new TextArea();
    Panel p = new Panel();
    TextField tf = new TextField();
    
    ChatWin() {
        this("guest");
    }

    ChatWin(String nickname) {
        super("Chatting");
        this.nickname = nickname;

        setBounds(100, 100, 300, 500);
        
        p.setLayout(new BorderLayout());
        p.add(tf, "Center");

        add(ta, "Center");
        add(p, "South");

        addWindowListener(new WindowAdapter(){   
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        tf.addActionListener(new EventHandler());
        ta.setText("#" + nickname + "님 즐거운 채팅되세요.");
        ta.setEditable(false);   // ta부분 수정불가
        setVisible(true);
        tf.requestFocus();   // 키 이벤트를 받을 컴포넌트 설정
    }
/*
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.print("Please Input Nickname >> ");
            @SuppressWarnings("resource")
         Scanner scan=new Scanner(System.in);
            String nick =scan.next();
            
            new ChatWin(nick);
        }
        else
           new ChatWin(args[0]);

    }
*/ 
    class EventHandler implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         String msg=tf.getText();
         ta.append("\n"+nickname+"> "+msg);
         tf.setText("");
      }     
    }

	public void mainSetting(Menu menu) {
		// TODO Auto-generated method stub
		
	} 

}