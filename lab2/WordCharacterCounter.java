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
import java.util.StringTokenizer; 
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener; 
public class WordCharacterCounter extends JFrame
{	public WordCharacterCounter()
	{
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JTextArea ta = new JTextArea();
        JButton btn1 = new JButton("word");
        JButton btn2 = new JButton("character");
		JLabel charsNum = new JLabel("Number of characters is: ");
        JLabel jl = new JLabel();
		JLabel caretLoc = new JLabel("Location of caret is: ");
		JLabel j2 = new JLabel();
        ta.setBounds(180, 50, 300, 250);
        btn1.setBounds(180, 350, 90, 30);
        btn2.setBounds(390, 350, 90, 30);
        jl.setBounds(320, 400, 90, 30);
		charsNum.setBounds(180, 400, 200, 30);
		j2.setBounds(292, 420, 90, 30);
		caretLoc.setBounds(180, 420, 200, 30);
        this.add(ta);
        this.add(btn1);
        this.add(btn2);
        this.add(jl);
		this.add(charsNum);
		this.add(j2);
		this.add(caretLoc);
		//close safely
		this.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {

                int option=JOptionPane.showConfirmDialog(WordCharacterCounter.this, "Do you want to exit?", "confirmation message",JOptionPane.YES_NO_OPTION);
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
		//find cursor location
		ta.addCaretListener(new CaretListener() {
            
            public void caretUpdate(CaretEvent e) {
                int position = e.getDot();
                j2.setText(Integer.toString(position)); 
            }
		});
        //label shows no of chars
        ta.getDocument().addDocumentListener(new DocumentListener(){
        
            int count = 0;
            public void insertUpdate(DocumentEvent e) {
                count++;
                jl.setText(Integer.toString(count));
            }

            
            public void removeUpdate(DocumentEvent e) {
                count--;
                jl.setText(Integer.toString(count));
            }

            
            public void changedUpdate(DocumentEvent e) {

            }
        
        });
		//get num of words
        btn1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {

                StringTokenizer st = new StringTokenizer(ta.getText(), " ");
                JOptionPane.showMessageDialog(WordCharacterCounter.this, st.countTokens());
            }
        });
		//get num of chars
        btn2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
                String input = ta.getText();
                int charNum = input.length();
                JOptionPane.showMessageDialog(WordCharacterCounter.this, charNum);
            }
        });	
	}
	public static void main(String args[])
	{
		WordCharacterCounter obj =new WordCharacterCounter();
		obj.setSize(690, 500);
		obj.setResizable(false);
		obj.setVisible(true);
	}
}	
