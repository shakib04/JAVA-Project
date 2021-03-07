import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstFrame extends JFrame implements MouseListener, ActionListener
{
	private JLabel userLabel, passLabel, imgLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton signUpBtn, loginBtn, exitBtn;
	private JRadioButton r1, r2, r3, r4;
	private JCheckBox c1, c2;
	private JComboBox combo;
	private ImageIcon img;
	private Color myColor;
	private Font myFont;
	private JPanel panel;

	public FirstFrame()
	{
		super("My First GUI");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myColor = new Color(230,250,160);
		this.myFont = new Font("Cambria", Font.ITALIC | Font.BOLD, 18);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 100, 30);
		userLabel.setBackground(Color.CYAN);
		userLabel.setOpaque(true);
		userLabel.setFont(myFont);
		panel.add(userLabel);
		
		
		userTF = new JTextField();
		userTF.setBounds(410,100,100,30);
		userTF.setBackground(Color.YELLOW);
		panel.add(userTF);
		
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 100, 30);
		passLabel.setForeground(Color.BLUE);
		passLabel.setFont(myFont);
		panel.add(passLabel);
		
		
		passPF = new JPasswordField();
		passPF.setBounds(410, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(360, 300, 80, 30);
		loginBtn.setBackground(Color.GREEN);
		loginBtn.addMouseListener(this);
		panel.add(loginBtn);
		
		
		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(250, 300, 80, 30);
		signUpBtn.setForeground(Color.BLUE);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(470, 300, 80, 30);
		exitBtn.setBackground(Color.RED);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		
		r1 = new JRadioButton("OOP1 K");
		r1.setBounds(550, 50, 70, 30);
		panel.add(r1);
		
		r2 = new JRadioButton("OOP1 Q");
		r2.setBounds(550, 100, 70, 30);
		r2.setOpaque(false);
		panel.add(r2);
		
		r3 = new JRadioButton("OOP1 B");
		r3.setBounds(550, 150, 70, 30);
		panel.add(r3);
		
		r4 = new JRadioButton("OOP1 C");
		r4.setBounds(550, 200, 70, 30);
		panel.add(r4);
		
		c1 = new JCheckBox("Theory");
		c1.setBounds(650, 50, 70, 30);
		panel.add(c1);
		
		c2 = new JCheckBox("Lab");
		c2.setBounds(650, 100, 70, 30);
		panel.add(c2);
		
		
		String items[] = new String []{"CS", "CSE", "CSSE", "CIS", "SE", "COE"};
		combo = new JComboBox(items);
		combo.setBounds(650, 200, 70, 30);
		panel.add(combo);
		
		img = new ImageIcon("oop1q.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(50,100, 200, 112);
		panel.add(imgLabel);
		
		
		this.add(panel);
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(Color.BLUE);
			loginBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(Color.GREEN);
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(signUpBtn.getText()))
		{
			SecondFrame sf = new SecondFrame(this);
			sf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
}