package chatting;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import client.Client;
import server.Server;

public class Menu extends JFrame{
   private JRadioButtonMenuItem color[],fonts[];
   private JCheckBoxMenuItem styleItems[];
   private ButtonGroup fontGroup, colorGroup;
   private Openwindow openwindow;
   private JFrame Menuframe;
   protected Server serverchatwin;
   protected Client clientchatwin;
   private static ImageIcon ic1;
   private static JLabel image1;

   public static void main(String[] args) { 
      Menu menu = new Menu(args[0]);
   }
   public Menu(String name){
	   System.out.println(name);
      Menuframe = new JFrame("수지");
      ic1 = new ImageIcon("./image2.png");
      image1 = new JLabel(ic1);
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      
      JMenu ChatMenu = new JMenu("채팅(S)");
      ChatMenu.setToolTipText("채팅 메뉴");
      ChatMenu.setMnemonic('S');
      
      JMenuItem newItem = new JMenuItem("새로운 채팅(N)");
      newItem.setMnemonic('N');
      ChatMenu.add(newItem);
      newItem.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
        	 if (name.equals("admin")) {
        		 Menuframe.dispose();
                 new Server("server"); 
        	 }
        	 else {
        		 Menuframe.dispose();
                 try {
					new Client("client");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 }
           // Menu menu = new Menu("admin");
            //menu.chatWin=new ChatWin(name);
            //menu.chatWin.mainSetting(menu);
            //menu.serverchatwin = new Server();
            //menu.serverchatwin.mainSetting(menu);
            //menu.clientchatwin = new Client();
            
         }
      });
      
      JMenuItem openItem = new JMenuItem("오픈 채팅(O)");
      newItem.setMnemonic('O');
      ChatMenu.add(openItem);
      
      JMenuItem exitItem = new JMenuItem("닫기(X)");
      exitItem.setMnemonic('X');
      ChatMenu.add(exitItem);
      exitItem.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                 System.exit(0);
              }
           });
      
      bar.add(ChatMenu);
      
      JMenu formatMenu = new JMenu("편집(E)");
      formatMenu.setToolTipText("편집 메뉴");
      formatMenu.setMnemonic('E');
      
      String colors[] = {"Light","Dark","Red","Green","Blue"};
      JMenu colorMenu = new JMenu("색상(C)");
      colorMenu.setMnemonic('C');
      color = new JRadioButtonMenuItem[colors.length];
      colorGroup = new ButtonGroup();
      
      for (int i=0;i<colors.length;i++)
      {
         color[i] = new JRadioButtonMenuItem(colors[i]);
         colorMenu.add(color[i]);
         colorGroup.add(color[i]);
      }
      
      color[0].setSelected(true);
      formatMenu.add(colorMenu);
      //formatMenu.addSeparator();
      
      String fontNames[]= {"굴림","바탕"};
      JMenu fontMenu = new JMenu("글꼴(T)");
      fontMenu.setMnemonic('T');
      fonts = new JRadioButtonMenuItem[fontNames.length];
        fontGroup = new ButtonGroup();
        
        for ( int i = 0; i < fonts.length; i++ ) 
        {
            fonts[ i ] = new JRadioButtonMenuItem( fontNames[ i ] );
            fontMenu.add( fonts[ i ] );
            fontGroup.add( fonts[ i ] );
            switch(i) {   
            case 0:// 굴림
              Font font1 = new Font("굴림",Font.PLAIN,20);
              setFont(font1);
           case 1:
              Font font2 = new Font("바탕",Font.PLAIN,20);
              setFont(font2);
            }
        }
        fonts[0].setSelected(true);
        formatMenu.add(fontMenu);
        //fontMenu.addSeparator();
        
        bar.add(formatMenu);
        
        JMenu helpMenu = new JMenu( "도움말(H)" );
        helpMenu.setToolTipText("도움말 메뉴입니다");
        helpMenu.setMnemonic( 'H' );
        JMenuItem helpItem = new JMenuItem( "도움말 항목(L)" );
        helpItem.setMnemonic( 'L' );
        helpMenu.add(helpItem);
        bar.add( helpMenu );
        add(image1); 
      setBounds(200,300,640,360);
      setVisible(true);
      setResizable(false);
      //frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize( 400, 200 );
        //setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public void OpenwindowSetting(Openwindow openwindow) {
      // TODO Auto-generated method stub
      this.openwindow=openwindow;
      
   }
   

}