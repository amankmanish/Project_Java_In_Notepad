import javax.swing.*;
import java.awt.*;

class Splash implements Runnable
{
	JFrame fr;
	JLabel lb;
	int w=1;
	Thread th;
	
	public Splash()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setBounds((dim.width-500)/2,(dim.height-300)/2,500,300);

		fr.setContentPane(new JLabel(new ImageIcon("images\\splash.png")));

		lb = new JLabel(new ImageIcon("images\\line.png"));
		lb.setBounds(0,215,w,8);
		fr.add(lb);

		fr.setUndecorated(true);
		//fr.setOpacity(0.90f);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		th = new Thread(this);
		th.start();
	}

	public void run()
	{
		while(w<=500)
		{
			try
			{
				Thread.sleep(10);
				lb.setSize(w,8);
				w = w + 2;
			}
			catch(InterruptedException e)
			{
			}
		}
		th=null;
		fr.dispose();
		new Login();
	}

	public static void main(String args[])
	{
		new Splash();
	}
}