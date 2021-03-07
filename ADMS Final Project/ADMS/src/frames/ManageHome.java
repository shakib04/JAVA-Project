package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import repository.*;
import entity.*;

public class ManageHome extends JFrame implements ActionListener
{
	JLabel title;
	JButton logoutBtn, schBtn, empBtn, stdBtn, checkBtn, changePassBtn, teacBtn;
	JPanel panel;
	
	Person person;
	
	
	public ManageHome(Person person)
	{
		super("University Management System");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 102, 255));
		panel.setLayout(null);
		
		
		title = new JLabel("University Managment System");
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		title.setBounds(5,5, 300, 60);
		panel.add(title);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(680,20,100,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		empBtn = new JButton("Manage Administration Employee");
		empBtn.setBounds(240, 280, 250, 70);
		empBtn.addActionListener(this);
		panel.add(empBtn);
		
		teacBtn = new JButton("Manage Teacher");
		teacBtn.setBounds(240, 460, 250, 70);
		teacBtn.addActionListener(this);
		panel.add(teacBtn);
		
		stdBtn = new JButton("Manage Students");
		stdBtn.setBounds(240, 370, 250, 70);
		stdBtn.addActionListener(this);
		panel.add(stdBtn);
		
		getContentPane().add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(empBtn.getText()))
		{
			EmployeeManagementFrame emf = new EmployeeManagementFrame(person);
			emf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(teacBtn.getText()))
		{
			TeacherManagmentFrame tmf = new TeacherManagmentFrame(person);
			tmf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(stdBtn.getText()))
		{
			StudentManagmentFrame smf = new StudentManagmentFrame(person);
			smf.setVisible(true);
			this.setVisible(false);
		}
	}
	
}