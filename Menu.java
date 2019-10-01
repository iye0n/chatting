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
		
		JMenu ChatMenu = new JMenu("ä��(S)");
		ChatMenu.setToolTipText("ä�� �޴�");
		ChatMenu.setMnemonic('S');
		
		JMenuItem newItem = new JMenuItem("���ο� ä��(N)");
		newItem.setMnemonic('N');
		ChatMenu.add(newItem);
		
		JMenuItem openItem = new JMenuItem("���� ä��(O)");
		newItem.setMnemonic('O');
		ChatMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("�ݱ�(X)");
		exitItem.setMnemonic('X');
		ChatMenu.add(exitItem);
		
		bar.add(ChatMenu);
		
		JMenu formatMenu = new JMenu("����(E)");
		formatMenu.setToolTipText("���� �޴�");
		formatMenu.setMnemonic('E');
		
		String colors[] = {"Dark","Light","Red","Green","Blue"};
		JMenu colorMenu = new JMenu("����(C)");
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
		
		String fontNames[]= {"����","����"};
		JMenu fontMenu = new JMenu("�۲�(T)");
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
        
        JMenu helpMenu = new JMenu( "����(H)" );
        helpMenu.setToolTipText("���� �޴��Դϴ�");
        helpMenu.setMnemonic( 'H' );
        JMenuItem helpItem = new JMenuItem( "�����׸�(L)" );
        helpItem.setMnemonic( 'L' );
        helpMenu.add(helpItem);
        bar.add( helpMenu );
        setSize( 400, 200 );
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
