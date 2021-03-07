package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LoginFrame extends JFrame implements ActionListener
{
    JLabel title, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF;
    JButton loginBtn, exitBtn;
    JComboBox statusCombo;
    JPanel panel;
    private JLabel statusLabel;

    public LoginFrame()
    {
        super("University Managment System - Login Window");

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setForeground(Color.RED);
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);

        title = new JLabel("University System");
        title.setBounds(5,5, 300, 60);
        panel.add(title);

        userLabel = new JLabel("User ID:");
        userLabel.setBounds(290 , 170, 70, 30);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setForeground(Color.DARK_GRAY);
        userTF.setBounds(360, 170, 150, 30);
        panel.add(userTF);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(290, 220, 70, 30);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(360, 220, 150, 30);
        passPF.setEchoChar('*');
        panel.add(passPF);

        loginBtn = new JButton("Login");
        loginBtn.setForeground(Color.BLACK);
        loginBtn.setBackground(Color.GREEN);
        loginBtn.setBounds(360, 300, 80, 30);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBackground(Color.RED);
        exitBtn.setBounds(460, 300, 80, 30);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(115, 249, -36, 16);
        panel.add(layeredPane);
        
        String statusList[] = new String[] {"student","teacher","employee"};
        statusCombo = new JComboBox(statusList);
        statusCombo.setBounds(360, 269, 150, 20);
        panel.add(statusCombo);
        
        statusLabel = new JLabel("Status:");
        statusLabel.setBounds(290, 272, 46, 14);
        panel.add(statusLabel);
        
        getContentPane().add(panel);
    }

    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

            if(command.equals(loginBtn.getText()))
            {
                
                PersonRepo pr = new PersonRepo();
                Person person = pr.getPerson(userTF.getText(), passPF.getText());
                String status = person.getStatus();
                System.out.println(status);
                String student = "student";
         	   	String manager = "manager";

               if(person != null)
               {
            	 
            	   String item = statusCombo.getSelectedItem().toString();
            	   
            	   if(person.getStatus().equals("student"))
            	   {
		            		   StudentHome sh = new StudentHome(person);
		            		   sh.setVisible(true);
		            		   this.setVisible(false);


		            		   /*else
            		   {
            			   JOptionPane.showMessageDialog(this, person.getStatus());
            		   }*/
            	   }
            	   
            	   else if(person.getStatus().equals("teacher"))
            	   {
            		   TeacherHome th = new TeacherHome(person);
            		   th.setVisible(true);
            		   this.setVisible(false);
            	   }
            	   
            	   else if(person.getStatus().equals("manager"))
            	   {
            		  ManageHome mh = new ManageHome(person);
            		  mh.setVisible(true);
            		  this.setVisible(false);
            	   }
            	   
            	   else
            	   {
            		   JOptionPane.showMessageDialog(this, person.getStatus());
            	   }
            	   
               }
                else
                {
                    JOptionPane.showMessageDialog(this, "Invalid Id or Password!");
                }
            }
               
               
            else if(command.equals(exitBtn.getText()))
            {
                System.exit(0);
            }
    }
}