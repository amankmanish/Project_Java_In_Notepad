import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;

class DeleteUser
{
	JButton b1;
	JTextField t1;
	JFrame fr,pfr;
	JLabel lexit;
	public DeleteUser(JFrame ff)
	{
		pfr = ff;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-900)/2,(dim.height-400)/2,900,400);
		fr.setContentPane(new JLabel(new ImageIcon("images\\delete.png")));
		
		lexit = new JLabel(new ImageIcon("images\\exit1.png"));
		lexit.setBounds(850,7,32,32);
		lexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lexit.setToolTipText("Quit SMS");
		fr.add(lexit);
		lexit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				lexit.setIcon(new ImageIcon("images\\exit2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				lexit.setIcon(new ImageIcon("images\\exit1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				pfr.setEnabled(true);
				fr.dispose();
			}
		});

		t1 = new JTextField();
		t1.setFont(new Font("verdana",Font.PLAIN,15));
		t1.setBounds(450,180,100,30);
		fr.add(t1);
		
		b1 = new JButton("Go");
		b1.setFont(new Font("verdana",Font.PLAIN,15));
		b1.setBounds(570,180,100,30);
		fr.add(b1);
		
		
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}