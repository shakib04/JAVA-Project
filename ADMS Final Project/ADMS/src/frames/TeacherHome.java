package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;

public class TeacherHome extends JFrame implements ActionListener
{
	private JLabel sysLabel;
	private JButton logoutBtn;
	private JPanel panel;
	
	private Person person;
	private TeacherRepo tr;
	private PersonRepo pr;
	DatabaseConnection dbc;
	
	
	public TeacherHome(Person person)
	{
		super("Teacher Home");
		this.setSize(950, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		tr = new TeacherRepo();
		pr = new PersonRepo();
		dbc = new DatabaseConnection();
		
		Teacher t = tr.searchTeacher(person.getPersonId());
		
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setLayout(null);
		
		sysLabel = new JLabel("Teacher HomePage");
		sysLabel.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		sysLabel.setForeground(new Color(204, 51, 0));
		sysLabel.setBounds(5, 5, 167, 36);
		panel.add(sysLabel);
		
		JLabel nameLabel = new JLabel("Hello,");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameLabel.setBounds(32, 52, 78, 36);
		panel.add(nameLabel);
		
		JLabel Name = new JLabel();
		Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		Name.setBounds(94, 58, 102, 25);
		Name.setText(t.getTeacherName());
		panel.add(Name);
		
		getContentPane().add(panel);
		
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLabel.setBounds(250, 63, 46, 14);
		panel.add(idLabel);
		
		JLabel ID = new JLabel("New label");
		ID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ID.setBounds(290, 59, 195, 25);
		ID.setText(t.getTeacher_Id());
		panel.add(ID);
		
		JLabel deptLabel = new JLabel("Dept. Name:");
		deptLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		deptLabel.setBounds(533, 59, 167, 23);
		panel.add(deptLabel);
		
		JLabel Dept = new JLabel("New label");
		Dept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Dept.setBounds(628, 60, 195, 23);
		Dept.setText(t.getTeacher_deptname());
		panel.add(Dept);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(250, 152, 46, 14);
		panel.add(lblEmail);
		
		JLabel Email = new JLabel("New label");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Email.setBounds(325, 148, 283, 25);
		Email.setText(t.getMail_address());
		panel.add(Email);
		
		
		
		
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
	}
}