import java.lang.*;

import javax.swing.*;

public class MyGUI extends JFrame
{
	private JLabel userLabel,passLabel,imgLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton signUpBtn,loginBtn,exitBtn;
	private JRadioButton r1,r2,r3,r4;
	private JCheckBox c1,c2;
	private JComboBox combo;
	private ImageIcon img;
	
	private JPanel panel;
	
	public MyGUI ( )
	{
		super("My First Application");
		this.setSize(900,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User Name");
		userLabel.setBounds(400,150,70,30);
		panel.add(userLabel);
		
		userTF	= new JTextField ();
		userTF.setBounds(490,150,120,40);
		panel.add(userTF);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(400,200,70,30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setEchoChar('6');
		passPF.setBounds(490,200,70,30);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(400,320,80,30);
		panel.add(loginBtn);
		
		
		this.add(panel);
	}
}