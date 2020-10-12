import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import java.sql.*;

class Login implements FocusListener
{
	JFrame fr;
	JLabel lexit,l1,l2,l3,l4,l5;
	JTextField t1;
	JPasswordField t2;
	int w=1;
	Thread th;
	Border border1,border2;		

	public Login()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-500)/2,(dim.height-300)/2,500,300);
		fr.setContentPane(new JLabel(new ImageIcon("images\\login.png")));
		
		lexit = new JLabel(new ImageIcon("images\\exit1.png"));
		lexit.setBounds(450,10,32,32);
		lexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				fr.dispose();
			}
		});

		l1 = new JLabel("UserName");
		l2 = new JLabel("Password");
		l1.setFont(new Font("verdana",Font.BOLD,16));
		l2.setFont(new Font("verdana",Font.BOLD,16));
		l1.setForeground(Color.cyan);
		l2.setForeground(Color.cyan);
		l1.setBounds(90,100,100,30);
		l2.setBounds(90,140,100,30);
		fr.add(l1);
		fr.add(l2);

		l3 = new JLabel("<html><u>Forget Password?</u></html>");
		l4 = new JLabel("<html><u>Create New User</u></html>");
		l3.setFont(new Font("verdana",Font.BOLD,11));
		l4.setFont(new Font("verdana",Font.BOLD,11));
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l3.setForeground(Color.gray);
		l4.setForeground(Color.gray);
		l3.setBounds(50,200,120,20);
		l4.setBounds(50,225,120,20);
		fr.add(l3);
		fr.add(l4);
		l3.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l3.setForeground(Color.pink);
				l3.setFont(new Font("verdana",Font.BOLD,12));
			}
			public void mouseExited(MouseEvent me)
			{
				l3.setForeground(Color.gray);
				l3.setFont(new Font("verdana",Font.BOLD,11));
			}
			public void mouseClicked(MouseEvent me)
			{
				new Forget();
			}
		});
		l4.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l4.setForeground(Color.pink);
				l4.setFont(new Font("verdana",Font.BOLD,12));
			}
			public void mouseExited(MouseEvent me)
			{
				l4.setForeground(Color.gray);
				l4.setFont(new Font("verdana",Font.BOLD,11));
			}
			public void mouseClicked(MouseEvent me)
			{
				new NewUser();
			}
		});

		border1 = BorderFactory.createLineBorder(Color.gray);
		border2 = BorderFactory.createLineBorder(Color.green);
		
		t1 = new JTextField();
		t2 = new JPasswordField();
		t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t1.setFont(new Font("verdana",Font.BOLD,18));
		t2.setFont(new Font("verdana",Font.BOLD,18));
		t1.setBounds(190,100,220,30);
		t2.setBounds(190,140,220,30);
		t1.setOpaque(false);
		t2.setOpaque(false);
		t1.setForeground(Color.green);
		t1.setCaretColor(Color.green);
		t2.setForeground(Color.green);
		t2.setCaretColor(Color.green);
		fr.add(t1);
		fr.add(t2);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		
		l5 = new JLabel(new ImageIcon("images\\submit1.png"));
		l5.setBounds(310,190,100,30);
		l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(l5);	
		l5.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l5.setIcon(new ImageIcon("images\\submit2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				l5.setIcon(new ImageIcon("images\\submit1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				
				if(t1.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(fr,"Error! usename can't be leave blank");
					t1.requestFocus();					
				}
				else if(t2.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(fr,"Error! password can't be leave blank");
					t2.requestFocus();					
				}
				else	
				{
					try
					{
						Connection con = Dao.createConnection();
						PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
						ps.setString(1,t1.getText());
						ps.setString(2,t2.getText());
						ResultSet rs = ps.executeQuery();
						if(rs.next()==true)
						{			
							JOptionPane.showMessageDialog(fr,"Welcome, " + t1.getText().toUpperCase());
							con.close();
							fr.dispose();	
							new MainForm(t1.getText());
						}
						else
						{
							JOptionPane.showMessageDialog(fr,"Invalid username or password");
						}
						con.close();		
					}
					catch(SQLException e)	
					{
						JOptionPane.showMessageDialog(fr,e.toString());
					}
				}
			}
		});
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void focusGained(FocusEvent fe)
	{
		JTextField tf = (JTextField)fe.getComponent();
		if(tf==t1)
		{
			t1.setBorder(BorderFactory.createCompoundBorder(border2,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		}
		if(tf==t2)
		{
			t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t2.setBorder(BorderFactory.createCompoundBorder(border2,BorderFactory.createEmptyBorder(1,8,1,1)));	
		}
	}

	public void focusLost(FocusEvent fe)
	{
	}

	public static void main(String args[])
	{
		new Login();
	}
}