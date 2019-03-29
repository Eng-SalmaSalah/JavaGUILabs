/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Gui extends JFrame {
    
    public Gui() {
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JTextArea ta = new JTextArea();
        JButton btn1 = new JButton("word");
        JButton btn2 = new JButton("character");
        JLabel jl = new JLabel();
        JLabel x = new JLabel();
        JLabel y = new JLabel();
        ta.setBounds(180, 50, 300, 250);
        btn1.setBounds(180, 350, 90, 30);
        btn2.setBounds(390, 350, 90, 30);
        jl.setBounds(390, 400, 90, 30);
        x.setBounds(390, 420, 90, 30);
        y.setBounds(190, 420, 90, 30);
        this.add(ta);
        this.add(btn1);
        this.add(btn2);
        this.add(jl);
        this.add(x);
        
        this.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {

                int option=JOptionPane.showConfirmDialog(Gui.this, "Do you eant to exit?", "confirmation message",JOptionPane.YES_NO_OPTION);
                if (option==0) 
                {
                    dispose();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        
        
        ta.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int position = e.getDot();
                x.setText(Integer.toString(position)); 
            }
        });
        ta.getDocument().addDocumentListener(new DocumentListener() {
            
            int count = 0;
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                count++;
                jl.setText(Integer.toString(count));
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                count--;
                jl.setText(Integer.toString(count));
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
        });
        btn1.addActionListener((ActionEvent ae) -> {
            StringTokenizer st = new StringTokenizer(ta.getText(), " ");
            JOptionPane.showMessageDialog(Gui.this, st.countTokens());
        });
        btn2.addActionListener((ActionEvent ae) -> {
            String input = ta.getText();
            int charNum = input.length();
            JOptionPane.showMessageDialog(Gui.this, charNum);
        });
        
    }
    
    public static void main(String args[]) {
        Gui obj = new Gui();
        obj.setSize(690, 500);
        obj.setResizable(false);
        obj.setVisible(true);
    }
}
