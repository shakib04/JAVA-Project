package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;

public class StudentManagmentFrame extends JFrame implements ActionListener
{
	private JLabel sysLabel, stdIdLabel, stdNameLabel, stdDeptNameLabel, stdCgpaLabel, stdCreditComLabel, stdContactLabel,stdSemesterLabel;
	private JButton addBtn, updateBtn, searchBtn, removeBtn, backBtn, logoutBtn, getAllBtn, refreshBtn;
	private JTextField stdIdTF, stdNameTF, stdDeptNameTF, stdCgpaTF, stdCreditComTF, stdContactTF;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;
	private JButton trigggerOffButton;
	
	
	private Person person;
	private StudentRepo sr;
	private PersonRepo pr;
	private JTextField stdSemesterTF;
	
	DatabaseConnection dbc;
	private JButton triggerButtonOn;


	
	public StudentManagmentFrame(Person person)
	{
		super("Student Home");
		this.setSize(950, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		sr = new StudentRepo();
		pr = new PersonRepo();
		dbc = new DatabaseConnection();
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setLayout(null);
		
		sysLabel = new JLabel("Student Infromation Home");
		sysLabel.setBounds(5, 5, 300, 60);
		panel.add(sysLabel);
		
		stdIdLabel = new JLabel("ID : ");
        stdIdLabel.setBounds(5, 76, 70, 20);
        panel.add(stdIdLabel);
		
		stdIdTF = new JTextField();
        stdIdTF.setBounds(100, 70, 120, 20);
        panel.add(stdIdTF);
		
		stdNameLabel = new JLabel("Name : ");
        stdNameLabel.setBounds(5, 101, 70, 20);
        panel.add(stdNameLabel);
		
		stdNameTF = new JTextField();
        stdNameTF.setBounds(100, 100, 120, 20);
        panel.add(stdNameTF);
		
		stdDeptNameLabel = new JLabel("Dept. Name : ");
        stdDeptNameLabel.setBounds(5, 131, 70, 20);
        panel.add(stdDeptNameLabel);
		
		stdDeptNameTF = new JTextField();
        stdDeptNameTF.setBounds(100, 130, 120, 20);
        panel.add(stdDeptNameTF);
		
		stdCgpaLabel = new JLabel("CGPA : ");
        stdCgpaLabel.setBounds(5, 161, 70, 20);
        panel.add(stdCgpaLabel);
		
		stdCgpaTF = new JTextField();
        stdCgpaTF.setBounds(100, 160, 120, 20);
        panel.add(stdCgpaTF);
		
		stdCreditComLabel = new JLabel("Credit Complete : ");
		stdCreditComLabel.setBounds(5, 191, 70, 20);
		panel.add(stdCreditComLabel);
		
		stdCreditComTF = new JTextField();
		stdCreditComTF.setBounds(100, 190, 120, 20);
		panel.add(stdCreditComTF);

		stdContactLabel = new JLabel("Contact No : ");
		stdContactLabel.setBounds(5, 252, 70, 20);
		panel.add(stdContactLabel);
		
		stdContactTF = new JTextField();
		stdContactTF.setBounds(100, 252, 120, 20);
		panel.add(stdContactTF);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(250,400,100,30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
		refreshBtn  = new JButton("Refresh");
		refreshBtn.setBounds(600,400,100,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Show All");
		getAllBtn.setBounds(710,400,85,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(20,400,100,30);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(130,400,100,30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(490,400,100,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(370,400,100,30);
		removeBtn.setEnabled(false);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(680,20,100,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		String data[][]={{"","","","","","",""}};
		String head[]={"ID","Name", "Dept. Name","CGPA", "Credit Complete", "Contact No","Semester"};
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(243,61,691,320);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);

		stdSemesterTF = new JTextField();
		stdSemesterTF.setBounds(100, 221, 120, 20);
		panel.add(stdSemesterTF);
		
		stdSemesterLabel = new JLabel("Semester:");
		stdSemesterLabel.setBounds(5, 221, 70, 20);
		panel.add(stdSemesterLabel);
		
		
		
		getContentPane().add(panel);
		
		trigggerOffButton = new JButton("Trigger OFF");
		trigggerOffButton.setBounds(250, 487, 120, 23);
		trigggerOffButton.addActionListener(this);
		panel.add(trigggerOffButton);
		
		triggerButtonOn = new JButton("Trigger On");
		triggerButtonOn.setBounds(421, 487, 125, 23);
		triggerButtonOn.addActionListener(this);
		panel.add(triggerButtonOn);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(searchBtn.getText()))
		{
			if(!stdIdTF.getText().equals("") || !stdIdTF.getText().equals(null))
			{
				Student s = sr.searchStudent(stdIdTF.getText());
				if(s!= null)
				{
					stdNameTF.setText(s.getStudentName());
					stdDeptNameTF.setText(s.getStu_deptname());
					stdCgpaTF.setText(s.getCgpa()+"");
					stdCreditComTF.setText(s.getCredit_complete()+"");
					stdContactTF.setText(s.getContact_no());
					
					stdIdTF.setEnabled(false);
					stdNameTF.setEnabled(true);
					stdDeptNameTF.setEnabled(true);
					stdCgpaTF.setEnabled(true);
					stdCreditComTF.setEnabled(true);
					stdContactTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					removeBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					addBtn.setEnabled(false);
					searchBtn.setEnabled(false);
					backBtn.setEnabled(true);
	
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Student ID!");
				}
			}
		}
		
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = sr.getAllStudent();
			String head[] = {"ID", "Name", "Dept. Name", "CGPA", "Credit Complete", "Contact No","Semester"};
			
			panel.remove(stdTableSP);
			
			stdTable = new JTable(data,head);
			stdTable.setEnabled(false);
			stdTableSP = new JScrollPane(stdTable);
			stdTableSP.setBounds(243,61,691,320);
			panel.add(stdTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(addBtn.getText()))
		{
			Person pd = new Person();
			
			if(stdIdTF.getText().equals("") || stdIdTF.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"Invaild ID!");
			}
			
			Student s = new Student();
			Student s1 = new Student();
			
			Person p = new Person();
			Random rd = new Random();
			int x = rd.nextInt(9999)+10000;
			int y = rd.nextInt(9999)+10000;
			
			s1 = sr.searchStudent(stdIdTF.getText());
			
			if(s1!=null)
			{
				JOptionPane.showMessageDialog(this,"Alreay Student Id Exist!");
			}
			
			else if(stdIdTF.getText().equals("") || stdIdTF.getText().equals(null) || stdNameTF.getText().equals("") || stdNameTF.getText().equals(null) || stdDeptNameTF.getText().equals("") || stdDeptNameTF.getText().equals(null) || stdCgpaLabel.getText().equals("")  || stdCgpaLabel.getText().equals(null) || stdContactTF.getText().equals("") || stdContactTF.getText().equals(null) || stdContactLabel.getText().equals("") || stdContactLabel.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"One of The Fields Missing!");
			}
			
			else
			{
				s.setStu_Id(stdIdTF.getText());
				s.setStudentName(stdNameTF.getText());
				s.setStu_deptname(stdDeptNameTF.getText());
				s.setCgpa(Double.parseDouble(stdCgpaTF.getText()));
				s.setContact_no(stdContactTF.getText());
				s.setCredit_complete(Integer.parseInt(stdCreditComTF.getText()));
				s.setSemester_Name(stdSemesterTF.getText());
				
				p.setPersonId(stdIdTF.getText());
				p.setPassword(x+"");
				p.setStatus("student");
				
				sr.insertStudent(s);
				pr.insertPerson(p);
				
				JOptionPane.showMessageDialog(this, "Inserted Student, Id: "+stdIdTF.getText());
				
				stdIdTF.setText("");
				stdNameTF.setText("");
				stdDeptNameTF.setText("");
				stdCgpaTF.setText("");
				stdCreditComTF.setText("");
				stdContactTF.setText("");
				stdSemesterTF.setText("");
				
				searchBtn.setEnabled(true);
				addBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				removeBtn.setEnabled(false);
				refreshBtn.setEnabled(false);
				backBtn.setEnabled(true);
			}
			
		}
		
		else if(command.equals(updateBtn.getText()))
		{
			if(stdIdTF.getText().equals("") || stdIdTF.getText().equals(null) || stdNameTF.getText().equals("") || stdNameTF.getText().equals(null) || stdDeptNameTF.getText().equals("") || stdDeptNameTF.getText().equals(null) || stdCgpaLabel.getText().equals("")  || stdCgpaLabel.getText().equals(null) || stdContactTF.getText().equals("") || stdContactTF.getText().equals(null) || stdContactLabel.getText().equals("") || stdContactLabel.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"One of The Fields Missing!!");
			}
			
			Student s = new Student();
			Student s1 = new Student();
			
				s.setStu_Id(stdIdTF.getText());
				s.setStudentName(stdNameTF.getText());
				s.setStu_deptname(stdDeptNameTF.getText());
				s.setCgpa(Double.parseDouble(stdCgpaTF.getText()));
				s.setContact_no(stdContactTF.getText());
				s.setCredit_complete(Integer.parseInt(stdCreditComTF.getText()));
				
				sr.updateStudent(s);
				
				JOptionPane.showMessageDialog(this, "Updated Student, Id: "+stdIdTF.getText());
				
				stdIdTF.setText("");
				stdNameTF.setText("");
				stdDeptNameTF.setText("");
				stdCgpaTF.setText("");
				stdCreditComTF.setText("");
				stdContactTF.setText("");
				
				searchBtn.setEnabled(true);
				addBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				removeBtn.setEnabled(false);
				refreshBtn.setEnabled(true);
				backBtn.setEnabled(true);
		}
		
		
		
		
		
		else if(command.equals(backBtn.getText()))
		{
			ManageHome mh = new ManageHome(person);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			stdIdTF.setText("");
			stdNameTF.setText("");
			stdDeptNameTF.setText("");
			stdCgpaTF.setText("");
			stdCreditComTF.setText("");
			stdContactTF.setText("");
			
			String data[][]={{"","","","","",""}};
			String head[]={"ID","Name", "Dept. Name","CGPA", "Credit Complete", "Contact No"};
			stdTable = new JTable(data,head);
			stdTableSP = new JScrollPane(stdTable);
			stdTableSP.setBounds(230,60,565,320);
			stdTable.setEnabled(false);
			panel.add(stdTableSP);

			
			stdIdTF.setEnabled(true);
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
		}
		
		else if(command.equals(removeBtn.getText()))
		{
			if(!stdIdTF.getText().equals(null) || stdIdTF.getText().equals(""))
			{
				sr.deleteStudent(stdIdTF.getText());
				
				JOptionPane.showMessageDialog(this,"Deleted Student!");
				
				stdIdTF.setText("");
				stdNameTF.setText("");
				stdDeptNameTF.setText("");
				stdCgpaTF.setText("");
				stdCreditComTF.setText("");
				stdContactTF.setText("");
				
				searchBtn.setEnabled(true);
				addBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				removeBtn.setEnabled(false);
				refreshBtn.setEnabled(true);
				backBtn.setEnabled(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Invalid Id!!");
			}
			
			
			
		}
		
		
			
		else if(command.equals(trigggerOffButton.getText()))
		
		{
			String query = "alter table student disable all triggers";
			JOptionPane.showMessageDialog(this, "Trigger Disabled on Student Table");
			//System.out.println("hello");
			
			try
			{
				dbc.openConnection();
				dbc.st.executeQuery(query);
				dbc.closeConnection();
			}
			
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		else if(command.equals(triggerButtonOn.getText()))
			
		{
			String query = "alter table student ENABLE all triggers";
			JOptionPane.showMessageDialog(this, "Trigger Enabled on Student Table");
			//System.out.println("hello");
			
			try
			{
				dbc.openConnection();
				dbc.st.executeQuery(query);
				dbc.closeConnection();
			}
			
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		
	}
}