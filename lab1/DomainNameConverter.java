import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class DomainNameConverter extends JFrame
{
	public DomainNameConverter()
	{
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JLabel jl=new JLabel("Enter URL:");
		JTextField tf = new JTextField(40);
		JButton btn = new JButton("Find IP");
		jl.setBounds(100,100,80,20);
		tf.setBounds(180,98,300,22);
		btn.setBounds(250,200,90,30);
		this.add(jl);
		this.add(tf);
		this.add(btn);
		//mmkn a3ml tf.addActionListener w a5od nfs code el button l2n l tf msh btfhm 8er el enter
		
		//get the url by pressing enter
		tf.addKeyListener(new KeyListener(){
			public void keyPressed (KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String input = tf.getText();
				Pattern p = Pattern.compile("(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");
				Matcher m = p.matcher(input);
				boolean b = m.matches();
				if(b==true)
				{
					try
					{
						InetAddress inet=InetAddress.getByName(input);
						String ipAddress =inet.toString();
						JOptionPane.showMessageDialog( DomainNameConverter.this,ipAddress );
					}
					catch(UnknownHostException ex)
					{
						JOptionPane.showMessageDialog( DomainNameConverter.this, "not found" );
					}
							
				}
				else
				{
					try
					{
						InetAddress inet=InetAddress.getLocalHost();
						String localAddress =inet.toString();
						JOptionPane.showMessageDialog( DomainNameConverter.this,localAddress );
					}
					catch(UnknownHostException ex)
					{
						JOptionPane.showMessageDialog( DomainNameConverter.this, "cannot get local address" );
					}
				}					
				}
					
			}
			public void keyReleased (KeyEvent e) {}
			public void keyTyped (KeyEvent e) {}
			
			
		});
		//safely close app
		this.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {

                int option=JOptionPane.showConfirmDialog(DomainNameConverter.this, "Do you want to exit?", "confirmation message",JOptionPane.YES_NO_OPTION);
                if (option==0) 
                {
                    dispose();
                }
            }

            public void windowClosed(WindowEvent e) {
                
            }

            public void windowIconified(WindowEvent e) {
                
            }

            public void windowDeiconified(WindowEvent e) {
                
            }

            public void windowActivated(WindowEvent e) {
                
            }

            public void windowDeactivated(WindowEvent e) {
                
            }
        });
		//get the url by pressing btn
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				String input = tf.getText();
				Pattern p = Pattern.compile("(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");
				Matcher m = p.matcher(input);
				boolean b = m.matches();
				if(b==true)
				{
					try
					{
						InetAddress inet=InetAddress.getByName(input);
						String ipAddress =inet.toString();
						JOptionPane.showMessageDialog( DomainNameConverter.this,ipAddress );
					}
					catch(UnknownHostException e)
					{
						JOptionPane.showMessageDialog( DomainNameConverter.this, "not found" );
					}
							
				}
				else
				{
					try
					{
						InetAddress inet=InetAddress.getLocalHost();
						String localAddress =inet.toString();
						JOptionPane.showMessageDialog( DomainNameConverter.this,localAddress );
					}
					catch(UnknownHostException e)
					{
						JOptionPane.showMessageDialog( DomainNameConverter.this, "cannot get local address" );
					}
				}

			}
	});}
		
		
	public static void main(String args[])
	{
		DomainNameConverter obj =new DomainNameConverter();
		obj.setSize(600, 400);
		obj.setResizable(false);
		obj.setVisible(true);
	}
	
}