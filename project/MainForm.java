import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

class MainForm implements Runnable,ActionListener
{
	JFrame fr;
	JLabel lexit,l1,l2,l3,l4,l5,lwelcome,ltime;
	Thread th;
	boolean bn; 
	JPopupMenu pop;
	JMenuItem p1,p2,p3,p4,p5;
	JMenuBar mb;
	JMenu op;
	JMenuItem m1;	
	JToolBar tb;
	JButton b1,b2,b3,b4,b5;

	public MainForm(String un)
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setSize(dim.width,dim.height);
		fr.setContentPane(new JLabel(new ImageIcon("images\\mainform.png")));
		
		lwelcome = new JLabel("Welcome, " + un);
		lwelcome.setBounds((dim.width-200)/2,7,400,30);	
		lwelcome.setFont(new Font("verdana",Font.BOLD,20));
		lwelcome.setForeground(Color.blue);
		fr.add(lwelcome);

		mb = new JMenuBar();
		op = new JMenu("Operation");
		op .setFont(new Font("verdana",Font.PLAIN,14));
		m1 = new JMenuItem("  Insert  ");
		m1.setIcon(new ImageIcon("images\\add0.png"));
		m1.addActionListener(this);
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		m1.setFont(new Font("verdana",Font.PLAIN,14));
		op.add(m1);
		mb.add(op);
		mb.setBounds(1,1,dim.width,40);
		fr.add(mb);

		ltime = new JLabel();
		//ltime.setBounds(80,7,400,30);
		ltime.setFont(new Font("verdana",Font.BOLD,16));
		ltime.setForeground(Color.blue);
		//fr.add(ltime);

		lexit = new JLabel(new ImageIcon("images\\exit2.png"));
		lexit.setBounds(dim.width-80,30,48,48);
		lexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lexit.setToolTipText("Quit SMS");
		fr.add(lexit);
		lexit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				lexit.setIcon(new ImageIcon("images\\exit3.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				lexit.setIcon(new ImageIcon("images\\exit2.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				bn=false;
				fr.dispose();
				//System.exit(0);
			}
		});

		l1 = new JLabel(new ImageIcon("images/add1.png"));
		l2 = new JLabel(new ImageIcon("images/search1.png"));
		l3 = new JLabel(new ImageIcon("images/remove1.png"));
		l4 = new JLabel(new ImageIcon("images/edit1.png"));
		l5 = new JLabel(new ImageIcon("images/display1.png"));
		l1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l1.setBounds(60,140,96,96);
		l2.setBounds(60,250,96,96);
		l3.setBounds(60,360,96,96);
		l4.setBounds(60,470,96,96);
		l5.setBounds(60,580,96,96);
		fr.add(l1);		
		fr.add(l2);		
		fr.add(l3);		
		fr.add(l4);		
		fr.add(l5);
		l1.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l1.setIcon(new ImageIcon("images//add2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l1.setIcon(new ImageIcon("images//add1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				fr.setEnabled(false);
				new InsertRecord(fr);
			}
		});
		l2.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l2.setIcon(new ImageIcon("images//search2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l2.setIcon(new ImageIcon("images//search1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				fr.setEnabled(false);
				new SearchUser(fr);
			}
		});
		l3.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l3.setIcon(new ImageIcon("images//remove2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l3.setIcon(new ImageIcon("images//remove1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				fr.setEnabled(false);
				new DeleteUser(fr);
			}
		});
		l4.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l4.setIcon(new ImageIcon("images//edit2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l4.setIcon(new ImageIcon("images//edit1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				fr.setEnabled(false);
				new UpdateUser(fr);
			}
		});
		l5.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l5.setIcon(new ImageIcon("images//display2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l5.setIcon(new ImageIcon("images//display1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
			}
		});

		pop = new JPopupMenu();
		p1 = new JMenuItem(" Insert ");						
		p2 = new JMenuItem(" Search ");						
		p3 = new JMenuItem(" Modify ");						
		p4 = new JMenuItem(" Remove ");
		p5 = new JMenuItem(" Display ");
		p1.setFont(new Font("verdana",Font.PLAIN,14));
		p2.setFont(new Font("verdana",Font.PLAIN,14));
		p3.setFont(new Font("verdana",Font.PLAIN,14));
		p4.setFont(new Font("verdana",Font.PLAIN,14));
		p5.setFont(new Font("verdana",Font.PLAIN,14));
		p1.setIcon(new ImageIcon("images\\add0.png"));
		p2.setIcon(new ImageIcon("images\\search0.png"));
		p3.setIcon(new ImageIcon("images\\edit0.png"));
		p4.setIcon(new ImageIcon("images\\remove0.png"));
		p5.setIcon(new ImageIcon("images\\display0.png"));
		
		p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		p3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
		p4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
		p5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
		
		p1.setMnemonic((int)'I');
		p2.setMnemonic((int)'C');
		p3.setMnemonic((int)'M');
		p4.setMnemonic((int)'V');
		p5.setMnemonic((int)'D');
			
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		p4.addActionListener(this);
		p5.addActionListener(this);
		pop.add(p1);
		pop.addSeparator();
		pop.add(p2);
		pop.addSeparator();
		pop.add(p3);
		pop.addSeparator();
		pop.add(p5);
		pop.addSeparator();
		pop.add(p4);

		fr.addMouseListener(new MouseAdapter()
		{
			public void cat(MouseEvent me)
			{
				if(me.isPopupTrigger()==true)
				{
					pop.show(fr,me.getX(),me.getY());
				}
			}

			public void mousePressed(MouseEvent me)
			{
				cat(me);
			}

			public void mouseReleased(MouseEvent me)
			{
				cat(me);
			}
		});

		tb = new JToolBar("Operation");
		b1 = new JButton(new ImageIcon("images\\add0.png"));
		b2 = new JButton(new ImageIcon("images\\search0.png"));
		b3 = new JButton(new ImageIcon("images\\remove0.png"));
		b4 = new JButton(new ImageIcon("images\\edit0.png"));
		b5 = new JButton(new ImageIcon("images\\display0.png"));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b1.setToolTipText("Insert");
		b2.setToolTipText("Search");
		b3.setToolTipText("Remove");
		b4.setToolTipText("Modify");
		b5.setToolTipText("Display");
		tb.add(b1);
		tb.add(b2);
		tb.add(b3);
		tb.add(b4);
		tb.add(b5);
		tb.add(ltime);
		tb.setBounds(1,40,dim.width,40);
		fr.add(tb);					
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		th = new Thread(this);
		th.start();
		bn=true;
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==p1 || ae.getSource()==m1 || ae.getSource()==b1)
		{
			fr.setEnabled(false);
			new InsertRecord(fr);
		}	
	}	

	public void run()
	{
		try
		{
			while(bn)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss");
				Date dt = new Date();
				String strdt = sdf.format(dt).toString();
				ltime.setText("  "+strdt);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
		}
	}

	public static void main(String args[])
	{
		new MainForm("sharad");
	}
}