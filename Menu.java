package chating;
import javax.swing.*;

public class Menu extends JFrame{
	private JRadioButtonMenuItem colorItems[],fonts[];
	private JCheckBoxMenuItem styleItems[];
	private ButtonGroup fontGroup, colorGroup;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}
	
	public Menu(){
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu ChatMenu = new JMenu("채팅(S)");
		ChatMenu.setToolTipText("채팅 메뉴");
		ChatMenu.setMnemonic('S');
		
		JMenuItem newItem = new JMenuItem("새로운 채팅(N)");
		newItem.setMnemonic('N');
		ChatMenu.add(newItem);
		
		JMenuItem openItem = new JMenuItem("오픈 채팅(O)");
		newItem.setMnemonic('O');
		ChatMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("닫기(X)");
		exitItem.setMnemonic('X');
		ChatMenu.add(exitItem);
		
		bar.add(ChatMenu);
		
		JMenu formatMenu = new JMenu("편집(E)");
		formatMenu.setToolTipText("편집 메뉴");
		formatMenu.setMnemonic('E');
		
		String colors[] = {"Dark","Light","Red","Green","Blue"};
		JMenu colorMenu = new JMenu("색상(C)");
		colorMenu.setMnemonic('C');
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorGroup = new ButtonGroup();
		
		for (int i=0;i<colors.length;i++)
		{
			colorItems[i] = new JRadioButtonMenuItem(colors[i]);
			colorMenu.add(colorItems[i]);
		}
		
		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		//formatMenu.addSeparator();
		
		String fontNames[]= {"굴림","바탕"};
		JMenu fontMenu = new JMenu("글꼴(T)");
		fonts = new JRadioButtonMenuItem[fontNames.length];
        fontGroup = new ButtonGroup();
        
        for ( int i = 0; i < fonts.length; i++ ) 
        {
            fonts[ i ] = new JRadioButtonMenuItem( fontNames[ i ] );
            fontMenu.add( fonts[ i ] );
            fontGroup.add( fonts[ i ] );
        }
        fonts[0].setSelected(true);
        //fontMenu.addSeparator();
        
        bar.add(formatMenu);
        
        JMenu helpMenu = new JMenu( "도움말(H)" );
        helpMenu.setToolTipText("도움말 메뉴입니다");
        helpMenu.setMnemonic( 'H' );
        JMenuItem helpItem = new JMenuItem( "도움말항목(L)" );
        helpItem.setMnemonic( 'L' );
        helpMenu.add(helpItem);
        bar.add( helpMenu );
        setSize( 400, 200 );
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
