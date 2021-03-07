import java.lang.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener
{
	private JLabel label1,passLabel;
	private JTextField userTF;
	private JPasswordField passTF;
	private JButton logBtn,signupBtn,exitBtn;
	private JRadioButton r1,r2;
	private JComboBox combo;
	private JPanel panel;
	
	public Frame()
	{
		super("Hello world");
		this.setSize(900,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label1 = new JLabel("User Name");
		label1.setBounds(300,100,100,30);
		panel.add(label1);
		
		userTF = new JTextField();
		userTF.setBounds(400,100,100,25);
		panel.add(userTF);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(300,125,100,30);
		panel.add(passLabel);
		
		passTF = new JPasswordField();
		passTF.setBounds(400,125,100,25);
		passTF.setEchoChar('#');
		panel.add(passTF);
		
		logBtn = new JButton("Log In");
		logBtn.setBounds(350,180,70,30);
		panel.add(logBtn);
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(260,180,85,30);
		panel.add(signupBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(430,180,75,30);
		panel.add(exitBtn);
		
		r1 = new JRadioButton("Laptop");
		r1.setBounds(600,100,70,30);
		panel.add(r1);
		
		r2 = new JRadioButton("Desktop");
		r2.setBounds(600,130,85,30);
		panel.add(r2);
		
		String items[] = new String [] {"MAYER DUA","BABAR DUA","BONER DUA","VAIYER DUA"};
		combo = new JComboBox(items);
		combo.setBounds(600,180,100,30);
		panel.add(combo);
		

		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(exitBtn.getText()