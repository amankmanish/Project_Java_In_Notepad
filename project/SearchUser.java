import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import java.sql.*;
import java.io.*;

class SearchUser implements ActionListener
{
	String str[] = {"Enter Student ID","Student's Name","Father's Name","Gender","Address","Mobile","Email-ID"};
	JFrame fr,pfr;
	JLabel lexit;
	JLabel lbl[],l1,l2,l3,l4,l5,l6,l7;
	JTextField txt[];
	JButton b1;
	int y1=102,y2=132;
	JTextField tt1,tt2,tt3,tt4,tt5,tt6;
	JTextField t1,t2,t3;
	JLabel limg;
	Image original,scaled;

	public SearchUser(JFrame ff)
	{
		pfr = ff;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-900)/2,(dim.height-520)/2,900,590);
		fr.setContentPane(new JLabel(new ImageIcon("images\\SearchUser.png")));
		
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

		limg = new JLabel();
		limg.setBounds(318,180,104,103);
		fr.add(limg);

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
	
		tt1 = new JTextField();
		tt1.setFont(new Font("verdana",Font.PLAIN,16));
		tt1.setForeground(Color.cyan);		
		tt1.setBounds(610,105,225,30);
		fr.add(tt1);
			
		tt2 = new JTextField();
		tt2.setFont(new Font("verdana",Font.PLAIN,16));
		tt2.setForeground(Color.cyan);		
		tt2.setBounds(610,160,225,30);
		fr.add(tt2);		
		
		tt3 = new JTextField();
		tt3.setFont(new Font("verdana",Font.PLAIN,16));
		tt3.setForeground(Color.cyan);		
		tt3.setBounds(610,215,225,30);
		fr.add(tt3);

		tt4 = new JTextField();
		tt4.setFont(new Font("verdana",Font.PLAIN,16));
		tt4.setForeground(Color.cyan);		
		tt4.setBounds(610,270,225,30);
		fr.add(tt4);
		
		tt5 = new JTextField();
		tt5.setFont(new Font("verdana",Font.PLAIN,16));
		tt5.setForeground(Color.cyan);		
		tt5.setBounds(610,365,225,30);
		fr.add(tt5);
		
		tt1.setOpaque(false);
		tt2.setOpaque(false);
		tt3.setOpaque(false);
		tt4.setOpaque(false);
		tt5.setOpaque(false);
		
		tt1.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		tt2.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));	
		tt3.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));
		tt4.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));
		tt5.setBorder(BorderFactory.createCompoundBorder(border1,BorderFactory.createEmptyBorder(1,8,1,1)));		
		
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
		b1.addActionListener(this);
		fr.add(b1);
		
		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Connection con = Dao.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from sms where roll=?");
			ps.setString(1,txt[0].getText());
			ResultSet rs = ps.executeQuery();			
			if(rs.next()==true)
			{
				txt[1].setText(rs.getString("student_name"));
				txt[2].setText(rs.getString("father_name"));
				txt[3].setText(rs.getString("gender"));
				txt[4].setText(rs.getString("address"));
				txt[5].setText(rs.getString("mobile"));
				txt[6].setText(rs.getString("email"));
				tt1.setText(rs.getString(9)); 
				tt2.setText(rs.getString(10)); 
				tt3.setText(rs.getString(11)); 
				tt4.setText(rs.getString(12)); 
				tt5.setText(rs.getString(13)); 
				t1.setText(rs.getString(14)); 
				t2.setText(rs.getString(15)); 
				t3.setText(rs.getString(16)); 
			
				Blob b = rs.getBlob(17);	
				byte by[] = b.getBytes(1,(int)b.length());
				FileOutputStream fos = new FileOutputStream("photos\\"+txt[0].getText()+".jpg");
				fos.write(by);
				fos.close();
	
				original = Toolkit.getDefaultToolkit().getImage("photos\\"+txt[0].getText()+".jpg");
				scaled = original.getScaledInstance(104,103,Image.SCALE_DEFAULT);
				limg.setIcon(new ImageIcon(scaled));
			}
			else
			{
				JOptionPane.showMessageDialog(fr,"ID does not exists.....");
			}
			con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}