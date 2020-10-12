import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class NewUser implements FocusListener
{
	JFrame fr;
	JLabel lexit,l1,l2,l3,l4,l5;
	JTextField t1,t3;
	JPasswordField t2;
	int w=1;
	Thread th;
	Border border1,border2;		

	public NewUser()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-500)/2,(dim.height-300)/2,500,300);
		fr.setContentPane(new JLabel(new ImageIcon("images\\newuser.png")));
		
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
		l3 = new JLabel("Email ID");
		l1.setFont(new Font("verdana",Font.BOLD,16));
		l2.setFont(new Font("verdana",Font.BOLD,16));
		l3.setFont(new Font("verdana",Font.BOLD,16));
		l1.setForeground(Color.cyan);
		l2.setForeground(Color.cyan);
		l3.setForeground(Color.cyan);
		l1.setBounds(90,80,100,30);
		l2.setBounds(90,120,100,30);
		l3.setBounds(90,160,100,30);
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);

		border1 = BorderFactory.createLineBorder(Color.gray);
		border2 = BorderFactory.createLineBorder(Color.green);
		
		t1 = new JTextField();
		t2 = new JPasswordField();
		t3 = new JTextField();
		t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t1.setFont(new Font("verdana",Font.BOLD,18));
		t2.setFont(new Font("verdana",Font.BOLD,18));
		t3.setFont(new Font("verdana",Font.BOLD,18));
		t1.setBounds(190,80,220,30);
		t2.setBounds(190,120,220,30);
		t3.setBounds(190,160,220,30);
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t1.setForeground(Color.green);
		t1.setCaretColor(Color.green);
		t2.setCaretColor(Color.green);
		t2.setForeground(Color.green);
		t3.setCaretColor(Color.green);
		t3.setForeground(Color.green);
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		t3.addFocusListener(this);

		l5 = new JLabel(new ImageIcon("images\\submit1.png"));
		l5.setBounds(310,210,100,30);
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
				else if(t3.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(fr,"Error! email-id can't be leave blank");
					t3.requestFocus();					
				}
				else
				{
					if(t3.getText().trim().length()!=0)
					{
						String str = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";	
						Pattern pattern = Pattern.compile(str);
						Matcher matcher = pattern.matcher(t3.getText());
						
						if(matcher.matches()!=true)
						{
							JOptionPane.showMessageDialog(fr,"Invalid email-id");
							t3.requestFocus();	
							t3.setText("");				
						}
						else
						{
							try
							{
								Connection con = Dao.createConnection();
								PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?)");
								ps.setString(1,t1.getText());
								ps.setString(2,t2.getText());
								ps.setString(3,t3.getText());
								int z = ps.executeUpdate();
								if(z>0)
								{			
									JOptionPane.showMessageDialog(fr,"User Created Successfully");
								}
								else
								{
									JOptionPane.showMessageDialog(fr,"Error! in creating record");
								}
								con.close();		
							}
							catch(SQLException e)	
							{
								JOptionPane.showMessageDialog(fr,e.toString());
							}
						}
					}
				}
			}
		});
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void focusGained(FocusEvent fe)
	{
		JTextField tf = (JTextField)fe.getComponent();
		if(tf==t1)
		{
			t1.setBorder(BorderFactory.createCompoundBorder(border2,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		}
		if(tf==t2)
		{
			t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t2.setBorder(BorderFactory.createCompoundBorder(border2,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		}
		if(tf==t3)
		{
			t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
			t3.setBorder(BorderFactory.createCompoundBorder(border2,BorderFactory.createEmptyBorder(1,8,1,1)));	
		}
	}

	public void focusLost(FocusEvent fe)
	{
	}
}