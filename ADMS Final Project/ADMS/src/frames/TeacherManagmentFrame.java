package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;

public class TeacherManagmentFrame extends JFrame implements ActionListener
{
	private JLabel sysLabel, teachIdLabel, teachNameLabel, teachDeptNameLabel, teachSalLabel, teachMailComLabel, teachContactLabel;
	private JButton addBtn, updateBtn, searchBtn, removeBtn, backBtn, logoutBtn, getAllBtn, refreshBtn;
	private JTextField teachIdTF, teachNameTF, teachDeptNameTF, teachSalTF, teachMailComTF, teachContactTF;
	private JPanel panel;
	private JTable teachTable;
	private JScrollPane teachTableSP;
	
	private Person person;
	private TeacherRepo tr;
	private PersonRepo pr;


	
	public TeacherManagmentFrame(Person person)
	{
		super("Teacher Managment Home");
		this.setSize(850, 550);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.person = person;
		
		tr = new TeacherRepo();
		pr = new PersonRepo();
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setLayout(null);
		
		sysLabel = new JLabel("Teacher Managment Home");
		sysLabel.setBounds(5, 5, 300, 60);
		panel.add(sysLabel);
		
		teachIdLabel = new JLabel("ID : ");
        teachIdLabel.setBounds(20, 70, 70, 20);
        panel.add(teachIdLabel);
		
		teachIdTF = new JTextField();
        teachIdTF.setBounds(100, 70, 120, 20);
        panel.add(teachIdTF);
		
		teachNameLabel = new JLabel("Name : ");
        teachNameLabel.setBounds(20, 100, 70, 20);
        panel.add(teachNameLabel);
		
		teachNameTF = new JTextField();
        teachNameTF.setBounds(100, 100, 120, 20);
        panel.add(teachNameTF);
		
		teachDeptNameLabel = new JLabel("Dept. Name : ");
        teachDeptNameLabel.setBounds(20, 130, 70, 20);
        panel.add(teachDeptNameLabel);
		
		teachDeptNameTF = new JTextField();
        teachDeptNameTF.setBounds(100, 130, 120, 20);
        panel.add(teachDeptNameTF);
		
		teachSalLabel = new JLabel("Salary : ");
        teachSalLabel.setBounds(20, 160, 70, 20);
        panel.add(teachSalLabel);
		
		teachSalTF = new JTextField();
        teachSalTF.setBounds(100, 160, 120, 20);
        panel.add(teachSalTF);
		
		teachMailComLabel = new JLabel("Email : ");
		teachMailComLabel.setBounds(20, 190, 70, 20);
		panel.add(teachMailComLabel);
		
		teachMailComTF = new JTextField();
		teachMailComTF.setBounds(100, 190, 120, 20);
		panel.add(teachMailComTF);
		
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
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(680,20,100,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(370,400,100,30);
		removeBtn.setEnabled(false);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);
		
		String data[][]={{"","","","",""}};
		String head[]={"ID","Name", "Dept. Name","Salary", "Email Address"};
		teachTable = new JTable(data,head);
		teachTableSP = new JScrollPane(teachTable);
		teachTableSP.setBounds(230,60,565,320);
		teachTable.setEnabled(false);
		panel.add(teachTableSP);

		getContentPane().add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(backBtn.getText()))
		{
			ManageHome mh = new ManageHome(person);
			mh.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(searchBtn.getText()))
		{
			if(!teachIdTF.getText().equals("") || !teachIdTF.getText().equals(null))
			{
				Teacher t = tr.searchTeacher(teachIdTF.getText());
				if(t!= null)
				{
					teachNameTF.setText(t.getTeacherName());
					teachDeptNameTF.setText(t.getTeacher_deptname());
					teachSalTF.setText(t.getSalary()+"");
					teachMailComTF.setText(t.getMail_address());
					
					teachIdTF.setEnabled(false);
					teachNameTF.setEnabled(true);
					teachDeptNameTF.setEnabled(true);
					teachSalTF.setEnabled(true);
					teachMailComTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					removeBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					addBtn.setEnabled(false);
					searchBtn.setEnabled(false);
					backBtn.setEnabled(true);
	
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Teacher ID!");
				}
			}
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			teachIdTF.setText("");
			teachNameTF.setText("");
			teachDeptNameTF.setText("");
			teachSalTF.setText("");
			teachMailComTF.setText("");
			
			String data[][]={{"","","","",""}};
			String head[]={"ID","Name", "Dept. Name","Salary", "Email Address"};
			
			teachTable = new JTable(data,head);
			teachTableSP = new JScrollPane(teachTable);
			teachTableSP.setBounds(230,60,565,320);
			teachTable.setEnabled(false);
			panel.add(teachTableSP);

			
			teachIdTF.setEnabled(true);
			searchBtn.setEnabled(true);
			addBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			removeBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			backBtn.setEnabled(true);
		}
		
		else if(command.equals(removeBtn.getText()))
		{
			if(!teachIdTF.getText().equals(null) || teachIdTF.getText().equals(""))
			{
				tr.deleteTeacher(teachIdTF.getText());
				
				JOptionPane.showMessageDialog(this,"Deleted Teacher!");
				
				teachIdTF.setText("");
				teachNameTF.setText("");
				teachDeptNameTF.setText("");
				teachSalTF.setText("");
				teachMailComTF.setText("");
				
				searchBtn.setEnabled(true);
				addBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				removeBtn.setEnabled(false);
				refreshBtn.setEnabled(true);
				backBtn.setEnabled(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Invalid Id!");
			}
			
			
			
		}
		
		
		else if(command.equals(addBtn.getText()))
		{
			Person pd = new Person();
			if(teachIdTF.getText().equals("") || teachIdTF.getText().equals(null)){
				JOptionPane.showMessageDialog(this,"Invaild ID!");
			}
			else
			{
				Teacher t = new Teacher();
				Person p = new Person();
				Random rd = new Random();
				int x = rd.nextInt(9999)+10000;
				//int y = rd.nextInt(9999)+10000;

				Teacher t1 = new Teacher();
				t1=tr.searchTeacher(teachIdTF.getText());
				if(t1!=null)
				{
					JOptionPane.showMessageDialog(this,"Alreay Teacher Id Exist!");
				}
				
				else if(teachIdTF.getText().equals("") || teachIdTF.getText().equals(null) || teachNameTF.getText().equals("") || teachNameTF.getText().equals(null) || teachDeptNameTF.getText().equals("") || teachDeptNameTF.getText().equals(null) || teachSalTF.getText().equals("")  || teachSalTF.getText().equals(null) ||teachMailComTF.getText().equals("")  || teachMailComTF.getText().equals(null))
					
				{
					JOptionPane.showMessageDialog(this,"One of The Fields Missing!");
				}
				else
				{
					t.setTeacher_Id(teachIdTF.getText());
					t.setTeacherName(teachNameTF.getText());
					t.setTeacher_deptname(teachDeptNameTF.getText());
					t.setSalary(Double.parseDouble(teachSalTF.getText()));
					t.setMail_address(teachMailComTF.getText());
				
					p.setPersonId(teachIdTF.getText());
					p.setPassword(x+"");
					p.setStatus("teacher");
					//p.setCode(y);

				
					tr.insertTeacher(t);
					pr.insertPerson(p);
				
					JOptionPane.showMessageDialog(this, "Inserted Teacher, Id: "+teachIdTF.getText()+"\n and Password:"+x);
					
					//and Password: "+x+"\n Verification Code : "+y+" \nSave the code in case you forget Password.");
				
					teachIdTF.setText("");
					teachNameTF.setText("");
					teachDeptNameTF.setText("");
					teachSalTF.setText("");
					teachMailComTF.setText("");
				
					searchBtn.setEnabled(true);
					addBtn.setEnabled(true);
					updateBtn.setEnabled(false);
					removeBtn.setEnabled(false);
					refreshBtn.setEnabled(false);
					backBtn.setEnabled(true);
				}
			}
			
			
			
			
		}
		
		
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = tr.getAllTeacher();
			String head[]={"ID","Name", "Dept. Name","Salary", "Email Address"};
			
			panel.remove(teachTableSP);
			
			teachTable = new JTable(data,head);
			teachTableSP = new JScrollPane(teachTable);
			teachTableSP.setBounds(230,60,565,320);
			panel.add(teachTableSP);
			
			panel.revalidate();
			panel.repaint();
		}
			
	}
}