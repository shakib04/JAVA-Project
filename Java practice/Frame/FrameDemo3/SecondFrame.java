import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondFrame extends JFrame implements ActionListener
{
	private JLabel label;
	private JButton b1, b2, backBtn;
	private JPanel panel;
	private FirstFrame ff;
	
	public SecondFrame(FirstFrame ff)
	{
		super("Second Frame");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ff = ff;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		label = new JLabel("");
		label.setBounds(50, 50, 700, 30);
		label.setBackground(Color.CYAN);
		label.setOpaque(true);
		panel.add(label);
		
		
		b1 = new JButton("1");
		b1.setBounds(50, 150, 80, 50);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("2");
		b2.setBounds(150, 150, 80, 50);
		b2.addActionListener(this);
		panel.add(b2);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(50, 350, 700, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(b1.getText()))
		{
			String s = label.getText() + b1.getText();
			label.setText(s);
			//label.setText(label.getText() + b1.getText());
			
		}
		else if(command.equals(b2.getText()))
		{
			String s = label.getText() + b2.getText();
			label.setText(s);
		}
		else if(command.equals(backBtn.getText()))
		{
			//FirstFrame ff = new FirstFrame();
			ff.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
	
	
	
	
	
	
	
}