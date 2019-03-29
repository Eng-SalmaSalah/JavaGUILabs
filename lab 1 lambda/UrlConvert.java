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
public class UrlConvert extends JFrame
{
	public UrlConvert()
	{
		this.setLayout(null);
		JLabel jl=new JLabel("Enter URL:");
		JTextField tf = new JTextField(40);
		JButton btn = new JButton("Find IP");
		jl.setBounds(100,100,80,20);
		tf.setBounds(180,98,300,22);
		btn.setBounds(250,200,90,30);
		this.add(jl);
		this.add(tf);
		this.add(btn);
		btn.addActionListener((ActionEvent ae)->{
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
						JOptionPane.showMessageDialog( UrlConvert.this,ipAddress );
					}
					catch(UnknownHostException e)
					{
						JOptionPane.showMessageDialog( UrlConvert.this, "not found" );
					}
							
				}
				else
				{
					try
					{
						InetAddress inet=InetAddress.getLocalHost();
						String localAddress =inet.toString();
						JOptionPane.showMessageDialog(UrlConvert.this,localAddress );
					}
					catch(UnknownHostException e)
					{
						JOptionPane.showMessageDialog( UrlConvert.this, "cannot get local address" );
					}
				}

			}
	);}
		
		
	public static void main(String args[])
	{
		UrlConvert obj =new UrlConvert();
		obj.setSize(600, 400);
		obj.setResizable(false);
		obj.setVisible(true);
	}
	
}