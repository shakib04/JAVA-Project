package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;

public class StudentHome extends JFrame implements ActionListener
{
	
	private JLabel sysLabel, stdIdLabel;
	
	private JButton logoutBtn;
	private JPanel panel;
	
	private Person person;
	private StudentRepo sr;
	private PersonRepo pr;
	
	private JLabel stdNameLabel;
	private JLabel Name;
	
	DatabaseConnection dbc;
	private JLabel ID;
	private JLabel deptNameLabel;
	private JLabel DeptName;
	private JLabel semesterLabel;
	private JLabel Semester;
	private JLabel cgpaLabel;
	private JLabel CGPA;
	private JTable courseTable;
	private JLabel courselt;
	private JLabel courseLabel;
	private JLabel lblNewLabel;
	
	
	
	public StudentHome(Person person)
	{
		super("Student Home");
		this.setSize(950, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		sr = new StudentRepo();
		pr = new PersonRepo();
		dbc = new DatabaseConnection();
		
		Student s = sr.searchStudent(person.getPersonId());
		
		String[][] courseLT = sr.courseList(person.getPersonId());
		
		
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setLayout(null);
		
		sysLabel = new JLabel("Student HomePage");
		sysLabel.setBounds(5, 5, 167, 36);
		panel.add(sysLabel);
		
		stdIdLabel = new JLabel("ID : ");
		stdIdLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        stdIdLabel.setBounds(210, 73, 47, 20);
        panel.add(stdIdLabel);
        
        ID = new JLabel();
        ID.setFont(new Font("Candara", Font.BOLD, 12));
        ID.setBounds(267, 76, 72, 14);
        ID.setText(s.getStu_Id());
        panel.add(ID);
        
        stdNameLabel = new JLabel("Hey,");
        stdNameLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
        stdNameLabel.setForeground(new Color(204, 0, 153));
        stdNameLabel.setBounds(10, 73, 47, 20);
        panel.add(stdNameLabel);
        
        Name = new JLabel();
        Name.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
        Name.setBounds(67, 76, 46, 14);
        Name.setText(s.getStudentName());
        panel.add(Name);
        
        logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(680,20,100,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
        
        deptNameLabel = new JLabel("Dept. Name:");
        deptNameLabel.setBounds(409, 76, 100, 14);
        panel.add(deptNameLabel);
        
        DeptName = new JLabel();
        DeptName.setBounds(542, 76, 46, 14);
        DeptName.setText(s.getStu_deptname());
        panel.add(DeptName);
        
        semesterLabel = new JLabel("Semester :");
        semesterLabel.setBounds(211, 122, 72, 14);
        panel.add(semesterLabel);
        
        Semester = new JLabel("New label");
        Semester.setBounds(280, 122, 46, 14);
        Semester.setText(s.getSemester_Name());
        panel.add(Semester);
        
        cgpaLabel = new JLabel("CGPA:");
        cgpaLabel.setBounds(409, 122, 46, 14);
        panel.add(cgpaLabel);
        
        CGPA = new JLabel("");
        CGPA.setBounds(542, 122, 46, 14);
        CGPA.setText(s.getCgpa()+"");
        panel.add(CGPA);
       
        String data[][]= {{""}};
        data = courseLT;
        String head[] = {"Course"};
        courseTable = new JTable(data,head);
        courseTable.setFont(new Font("Nikosh", Font.PLAIN, 14));
        courseTable.setBounds(65, 266, 419, 143);
        panel.add(courseTable);
      
        
        /*courselt = new JLabel("");
        courselt.setBounds(267, 194, 345, 259);
        for(int i=0;i<courseLT.length;i++)
        {
        	courselt.setText(courseLT[i]);
        }
        panel.add(courselt);*/
        
        courseLabel = new JLabel("Course List");
        courseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        courseLabel.setBounds(67, 209, 190, 36);
        panel.add(courseLabel);
        
        getContentPane().add(panel);
        
        JList list = new JList();
        list.setBounds(562, 238, 105, 221);
        list.list();
        panel.add(list);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(67, 474, 161, 14);
        String[] hh = {"A","V","r","6","fg"};
        String hh2=" ";
        for(int i = hh.length-1;i>=0;i--)
        {
        	
        	String name = hh[i] + hh2;
        	lblNewLabel.setText(name);
        	hh2 = name;
        	
        }
        panel.add(lblNewLabel);
        
        
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