import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import java.io.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

class InsertRecord implements ItemListener
{
	String fees[]={" ","2500","4500","3000","3500","2500","5000","5500","11000","7500","8000"};
	String duration[]={" ","3","2","4","2","1","3","4","2","4","2"};
	String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String str[] = {"Generate ID","Student's Name","Father's Name","Gender","Address","Mobile","Email-ID"};
	JFrame fr,pfr;
	JLabel lexit,lbrowse,limg,lsave,lreset,ldob;
	JLabel lbl[],l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7,t9,t10;
	int y1=102,y2=132;
	JComboBox c1,c2,c3,c4,c5,c6,cb1,cb2,cb3,t8;
	String path;
	Image original,scaled;
	JRadioButton r1,r2; 
	ButtonGroup bg;
	JCheckBox chk;
	int tot,dis,tam,ph=0;

	public InsertRecord(JFrame ff)
	{
		pfr = ff;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-900)/2,(dim.height-520)/2,900,590);
		fr.setContentPane(new JLabel(new ImageIcon("images\\insertframe.png")));
		
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
			if(i==0)
			{
				lbl[0] = new JLabel("<html><u>"+str[0]+"</u></html>");
				lbl[0].setForeground(Color.green);
				lbl[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			else
			{
				lbl[i] = new JLabel(str[i]);
				lbl[i].setForeground(Color.cyan);
			}
			lbl[i].setFont(new Font("verdana",Font.PLAIN,16));
			lbl[i].setBounds(60,y1,200,30);
			fr.add(lbl[i]);	
			y1 = y1 + 63;
		}
		lbl[0].addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				String uid = UUID.randomUUID().toString();
				uid = "SRM-" + uid.substring(0,6);
				t1.setText(uid);
			}
		});
	
		Border border1 = BorderFactory.createLineBorder(Color.gray);
		
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
			
		l7 = new JLabel("Total Fees");
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
		c1.setBounds(610,105,235,30);
		c1.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c1);		

		c2 = new JComboBox();
		c2.addItem("Select");
		c2.addItem("UP Board");
		c2.addItem("CBSE Board");
		c2.addItem("ICSE Board");
		c2.addItem("Open Board");
		c2.setBounds(610,160,235,30);
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
		c3.setBounds(610,215,235,30);
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
		c4.setBounds(610,270,235,30);
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
		c5.setBounds(610,365,150,30);
		c5.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(c5);
		c5.addItemListener(this);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JComboBox();
		for(int i=4 ; i<=50 ; i=i+5)
		{
			if(i>=5)
			{
				t8.addItem(""+i);
			}
			else
			{
				t8.addItem(""+0);
				i=0;
			}
		}
		t9 = new JTextField();
		t10 = new JTextField();
		t1.setFont(new Font("verdana",Font.PLAIN,15));
		t2.setFont(new Font("verdana",Font.PLAIN,15));
		t3.setFont(new Font("verdana",Font.PLAIN,15));
		t4.setFont(new Font("verdana",Font.PLAIN,15));
		t5.setFont(new Font("verdana",Font.PLAIN,15));
		t6.setFont(new Font("verdana",Font.PLAIN,15));
		t7.setFont(new Font("verdana",Font.PLAIN,15));
		t8.setFont(new Font("verdana",Font.PLAIN,15));
		t9.setFont(new Font("verdana",Font.PLAIN,15));
		t10.setFont(new Font("verdana",Font.PLAIN,15));
		
		t1.setBounds(60,132,235,30);
		t2.setBounds(60,195,235,30);
		t3.setBounds(60,258,235,30);
		t4.setBounds(60,384,235,30);
		t5.setBounds(60,447,235,30);
		t6.setBounds(60,510,235,30);
		t7.setBounds(610,410,235,30);
		t8.setBounds(610,460,115,30);
		t9.setBounds(610,510,235,30);
		t10.setBounds(765,365,80,30);
		
		t1.setFont(new Font("verdana",Font.BOLD,15));
		t2.setFont(new Font("verdana",Font.BOLD,15));
		t3.setFont(new Font("verdana",Font.BOLD,15));
		t4.setFont(new Font("verdana",Font.BOLD,15));
		t5.setFont(new Font("verdana",Font.BOLD,15));
		t6.setFont(new Font("verdana",Font.BOLD,15));
		t7.setFont(new Font("verdana",Font.BOLD,15));
		t8.setFont(new Font("verdana",Font.BOLD,15));
		t9.setFont(new Font("verdana",Font.BOLD,15));
		t10.setFont(new Font("verdana",Font.BOLD,15));
		t1.setForeground(Color.white);
		t2.setForeground(Color.white);
		t3.setForeground(Color.white);
		t4.setForeground(Color.white);
		t5.setForeground(Color.white);
		t6.setForeground(Color.white);
		t7.setForeground(Color.white);
		//t8.setForeground(Color.white);
		t9.setForeground(Color.white);
		t10.setForeground(Color.white);
		t1.setCaretColor(Color.white);
		t2.setCaretColor(Color.white);
		t3.setCaretColor(Color.white);
		t4.setCaretColor(Color.white);
		t5.setCaretColor(Color.white);
		t6.setCaretColor(Color.white);
		t7.setCaretColor(Color.white);
		//t8.setCaretColor(Color.white);
		t9.setCaretColor(Color.white);
		t10.setCaretColor(Color.white);
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t4.setOpaque(false);
		t5.setOpaque(false);
		t6.setOpaque(false);
		t7.setOpaque(false);
		//t8.setOpaque(false);
		t9.setOpaque(false);
		t10.setOpaque(false);
		t1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t4.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t5.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t6.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t7.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		//t8.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t9.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		t10.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		fr.add(t4);
		fr.add(t5);
		fr.add(t6);
		fr.add(t7);
		fr.add(t8);
		fr.add(t9);
		fr.add(t10);
		t5.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch = ke.getKeyChar();
				if(ch<'0' || ch>'9')
				{
					ke.consume();
				}
				if(t5.getText().length()>9)
				{
					t5.setText(t5.getText().substring(0,t5.getText().length()-1));	
				}
			}
		});

		chk = new JCheckBox("Apply");
		chk.setBounds(740,460,115,30);
		chk.setOpaque(false);
		chk.setFont(new Font("verdana",Font.BOLD,16));
		chk.setForeground(Color.pink);
		chk.addItemListener(this);
		fr.add(chk);	

		bg = new ButtonGroup();
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		r1.setFont(new Font("verdana",Font.PLAIN,16));
		r2.setFont(new Font("verdana",Font.PLAIN,16));
		r1.setForeground(Color.white);
		r2.setForeground(Color.white);
		r1.setBounds(60,321,68,30);			
		r2.setBounds(130,321,90,30);
		r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		r1.setOpaque(false);
		r2.setOpaque(false);
		bg.add(r1);
		bg.add(r2);
		fr.add(r1);
		fr.add(r2);	

		ldob = new JLabel("Date of Birth");
		ldob.setFont(new Font("verdana",Font.PLAIN,16));
		ldob.setForeground(Color.cyan);
		ldob.setBounds(240,293,150,30);
		fr.add(ldob);	
		
		cb1 = new JComboBox();
		for(int i=1 ; i<=31 ; i++)
		{
			cb1.addItem(""+i);
		}	
		cb1.setBounds(240,325,50,30);
		cb1.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(cb1);

		cb2 = new JComboBox();
		for(int i=0 ; i<12 ; i++)
		{
			cb2.addItem(month[i]);
		}	
		cb2.setBounds(295,325,60,30);
		cb2.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(cb2);

		cb3 = new JComboBox();
		for(int i=1980 ; i<=2000 ; i++)
		{
			cb3.addItem(""+i);
		}	
		cb3.setBounds(360,325,70,30);
		cb3.setFont(new Font("verdana",Font.PLAIN,16));
		fr.add(cb3);


		limg = new JLabel();
		limg.setBounds(318,115,104,103);
		fr.add(limg);

		lbrowse = new JLabel("<html><u>Browse Photo</u></html>");
		lbrowse.setBounds(330,215,85,30);
		lbrowse.setForeground(Color.green);
		lbrowse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lbrowse);
		lbrowse.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					FileDialog fd = new FileDialog(fr,"Load Image",FileDialog.LOAD);
					fd.setVisible(true);
					path = fd.getDirectory()+fd.getFile();
					if(path.equals("nullnull"))
					{
						ph=0;
						JOptionPane.showMessageDialog(fr,"canceled by user");
					}
					else
					{
						ph=1;
						original = Toolkit.getDefaultToolkit().getImage(path);
						scaled = original.getScaledInstance(104,103,Image.SCALE_DEFAULT);
						limg.setIcon(new ImageIcon(scaled));
					}
				}
				catch(Exception e)
				{
				}	
			}
		});

		lsave = new JLabel(new ImageIcon("images\\save1.png"));
		lreset = new JLabel(new ImageIcon("images\\reset1.png"));
		lsave.setBounds(750,7,32,32);
		lreset.setBounds(800,7,32,32);
		lsave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lsave);
		lsave.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					if(t1.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Generate ID");
					}
					else if(t2.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Enter Student's Name");
						t2.requestFocus();
					}
					else if(t3.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Enter Father's Name");
						t3.requestFocus();
					}
					else if(r1.isSelected()==false && r2.isSelected()==false)
					{
						JOptionPane.showMessageDialog(fr,"Please Select Gender");
					}
					else if(t4.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Enter Address");
						t4.requestFocus();
					}
					else if(t5.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Enter Mobile Number");
						t5.requestFocus();
					}
					else if(t6.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(fr,"Please Enter Email ID");
						t6.requestFocus();
					}
					else if(c1.getSelectedItem().equals("Select"))
					{
						JOptionPane.showMessageDialog(fr,"Please Select High School");
						c1.requestFocus();
					}
					else if(c2.getSelectedItem().equals("Select"))
					{
						JOptionPane.showMessageDialog(fr,"Please Select Intermediate");
						c2.requestFocus();
					}
					else if(c5.getSelectedItem().equals("Select"))
					{
						JOptionPane.showMessageDialog(fr,"Please Select Course");
						c5.requestFocus();
					}
					else
					{
						if(t6.getText().trim().length()!=0)
						{
							String str = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";	
							Pattern pattern = Pattern.compile(str);
							Matcher matcher = pattern.matcher(t6.getText());
						
							if(matcher.matches()!=true)
							{
								JOptionPane.showMessageDialog(fr,"Invalid email-id");
								t6.requestFocus();	
								t6.setText("");				
							}
							else
							{
								if(ph==0)
								{
									JOptionPane.showMessageDialog(fr,"Please Browse Photo");
								}
								else
								{
								try
								{
									Connection con = Dao.createConnection();
									PreparedStatement ps = con.prepareStatement("insert into sms values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
									ps.setString(1,t1.getText());
									ps.setString(2,t2.getText());
									ps.setString(3,t3.getText());
								
									String gen = "";
									if(r1.isSelected()==true)
									{
										gen = "Male";
									}			
									else
									{
										gen = "Female";
									}		

									ps.setString(4,gen);

									String dt = cb1.getSelectedItem().toString() +"-"+ cb2.getSelectedItem().toString()+"-"+ cb3.getSelectedItem().toString();
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
									java.util.Date date = sdf.parse(dt);
									java.sql.Date dob = new java.sql.Date(date.getTime());
						
									ps.setDate(5,dob);
									ps.setString(6,t4.getText());
									ps.setString(7,t5.getText());
									ps.setString(8,t6.getText());
									ps.setString(9,c1.getSelectedItem().toString());
									ps.setString(10,c2.getSelectedItem().toString());
									ps.setString(11,c3.getSelectedItem().toString());
									ps.setString(12,c4.getSelectedItem().toString());
									ps.setString(13,c5.getSelectedItem().toString());
									ps.setString(14,t9.getText());
									ps.setString(15,t8.getSelectedItem().toString());
									ps.setString(16,t10.getText());
				
									FileInputStream fis = new FileInputStream(path);
									ps.setBinaryStream(17,fis,fis.available());

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
								catch(Exception e)	
								{
									JOptionPane.showMessageDialog(fr,e.toString());
								}
								}
							}
						}
					}
				}
				catch(Exception e)
				{
				}
			}
			public void mouseEntered(MouseEvent me)
			{
				lsave.setIcon(new ImageIcon("images\\save2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				lsave.setIcon(new ImageIcon("images\\save1.png"));
			}
		});

		fr.add(lreset);			
		lreset.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				
			}
			public void mouseEntered(MouseEvent me)
			{
				lreset.setIcon(new ImageIcon("images\\reset2.png"));
			}
			public void mouseExited(MouseEvent me)
			{
				lreset.setIcon(new ImageIcon("images\\reset1.png"));
			}
		});

		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent ie)
	{
		try
		{
			JCheckBox cb = (JCheckBox)ie.getItem();
			if(cb==chk)
			{
				if(chk.isSelected()==true)
				{
					if(t8.getSelectedItem().toString().equals("0"))
					{
						JOptionPane.showMessageDialog(fr,"Please select the discount");
						chk.setSelected(false);
					}
					else
					{
						tot = Integer.parseInt(t7.getText());
						int rate = Integer.parseInt(t8.getSelectedItem().toString());
						dis = tot * rate / 100;
						tam = tot - dis;
						t9.setText(""+tam);	
					}
				}
				else
				{
					t8.setSelectedIndex(0);
					dis=0;
					tam = tot;
					t9.setText(""+tam);
				}
			}
		}
		catch(Exception e)
		{
			int indx = c5.getSelectedIndex();
			t7.setText(""+fees[indx]);
			t10.setText(""+duration[indx]+" mth");
			t9.setText(t7.getText());
		}
	}	
}