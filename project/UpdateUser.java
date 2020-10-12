import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;

class UpdateUser
{
	String str[] = {"Enter Student ID","Student's Name","Father's Name","Gender","Address","Mobile","Email-ID"};
	JButton b1;
	JFrame fr,pfr;
	JLabel lexit;
	JLabel lbl[],l1,l2,l3,l4,l5,l6,l7;
	JTextField txt[];
	int y1=102,y2=132;
	JComboBox c1,c2,c3,c4,c5,c6;
	JTextField t1,t2,t3;

	public UpdateUser(JFrame ff)
	{
		pfr = ff;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-900)/2,(dim.height-520)/2,900,590);
		fr.setContentPane(new JLabel(new ImageIcon("images\\Update.png")));
		
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

		lbl = new JLabel[7];
		for(int i=0 ; i<lbl.length ; i++)
		{
			lbl[i] = new JLabel(str[i]);
			lbl[i].setFont(new Font("verdana",Font.PLAIN,16));
			lbl[i].setForeground(Color.cyan);
			lbl[i].setBounds(60,y1,200,30);
			fr.add(lbl[i]);	
			y1 = y1 + 63;
		}

		Border border1 = BorderFactory.createLineBorder(Color.gray);
		
		txt = new JTextField[7];
		for(int i=0 ; i<lbl.length ; i++)
		{
			txt[i] = new JTextField();
			txt[i].setFont(new Font("verdana",Font.BOLD,15));
			txt[i].setForeground(Color.white);
			txt[i].setBounds(60,y2,235,30);
			txt[i].setOpaque(false);
			txt[i].setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			fr.add(txt[i]);	
			y2 = y2 + 63;
		}

		l1 = new JLabel("High School");
		l1.setFont(new Font("verdana",Font.PLAIN,16));
		l1.setForeground(Color.cyan);		
		l1.setBounds(480,105,150,30);
		fr.add(l1);

		l2 = new JLabel("Intermediate");
		l2.setFont(new Font("verdana",Font.PLAIN,16));
		l2.setForeground(Color.cyan);		
		l2.setBounds(480,160,150,30);
		fr.add(l2);
		
		l3 = new JLabel("Graduate");
		l3.setFont(new Font("verdana",Font.PLAIN,16));
		l3.setForeground(Color.cyan);		
		l3.setBounds(480,215,150,30);
		fr.add(l3);

		l4 = new JLabel("Post Graduate");
		l4.setFont(new Font("verdana",Font.PLAIN,16));
		l4.setForeground(Color.cyan);		
		l4.setBounds(480,270,150,30);
		fr.add(l4);

		l5 = new JLabel("Courses");
		l5.setFont(new Font("verdana",Font.PLAIN,16));
		l5.setForeground(Color.cyan);		
		l5.setBounds(480,360,150,30);
		fr.add(l5);

		l5 = new JLabel("Fees");
		l5.setFont(new Font("verdana",Font.PLAIN,16));
		l5.setForeground(Color.cyan);		
		l5.setBounds(480,410,150,30);
		fr.add(l5);

		l6 = new JLabel("Discount");
		l6.setFont(new Font("verdana",Font.PLAIN,16));
		l6.setForeground(Color.cyan);		
		l6.setBounds(480,460,150,30);
		fr.add(l6);
			
		l7 = new JLabel("Duration");
		l7.setFont(new Font("verdana",Font.PLAIN,16));
		l7.setForeground(Color.cyan);		
		l7.setBounds(480,510,150,30);
		fr.add(l7);
	
		c1 = new JComboBox();
		c1.addItem("Select");
		c1.addItem("UP Board");
		c1.addItem("CBSE Board");
		c1.addItem("ICSE Board");
		c1.addItem("Open Board");
		c1.setBounds(610,105,225,30);
		c1.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c1);		

		c2 = new JComboBox();
		c2.addItem("Select");
		c2.addItem("UP Board");
		c2.addItem("CBSE Board");
		c2.addItem("ICSE Board");
		c2.addItem("Open Board");
		c2.setBounds(610,160,225,30);
		c2.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c2);

		c3 = new JComboBox();
		c3.addItem("Select");
		c3.addItem("BA");
		c3.addItem("B.Com");
		c3.addItem("B.Sc");
		c3.addItem("BCA");
		c3.addItem("BBA");
		c3.addItem("B.Tech");
		c3.setBounds(610,215,225,30);
		c3.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c3);

		c4 = new JComboBox();
		c4.addItem("Select");
		c4.addItem("MA");
		c4.addItem("M.Com");
		c4.addItem("M.Sc");
		c4.addItem("MCA");
		c4.addItem("MBA");
		c4.addItem("M.Tech");
		c4.setBounds(610,270,225,30);
		c4.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c4);	

		c5 = new JComboBox();
		c5.addItem("Select");
		c5.addItem("Basic");
		c5.addItem("Tally");
		c5.addItem("DTP");
		c5.addItem("C & C++");
		c5.addItem("Data Structure");
		c5.addItem("JAVA");
		c5.addItem("DotNet");
		c5.addItem("Python");
		c5.addItem("Web Designing");
		c5.addItem("RDBMS");
		c5.setBounds(610,365,225,30);
		c5.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c5);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t1.setFont(new Font("verdana",Font.PLAIN,15));
		t2.setFont(new Font("verdana",Font.PLAIN,15));
		t3.setFont(new Font("verdana",Font.PLAIN,15));
		t1.setBounds(610,410,225,30);
		t2.setBounds(610,460,225,30);
		t3.setBounds(610,510,225,30);
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		
		b1 = new JButton("Search");
		b1.setFont(new Font("verdana",Font.PLAIN,15));
		b1.setBounds(310,130,100,30);
		fr.add(b1);
		
		
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}