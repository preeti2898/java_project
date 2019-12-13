package javaProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class student_page extends JFrame 
{
	private static JFrame frame2;
	private static JButton btn2;
	private static JButton btn3,btn4;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel all;
	public student_page()
	{
		frame2=new JFrame("Student SignUp page");
		frame2.setResizable(false);
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		btn4=new JButton("LogOut");
		btn4.setBounds(50,700,100,40);
		Font labelFontt1=btn4.getFont();
		String labelTextt1=btn4.getText();
		btn4.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
		btn4.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
				{
					
					new homePage();
					frame2.dispose();
				}
		});
		
		
		btn2=new JButton("Login");
		Font labelFont2=btn2.getFont();
		String labelText2=btn2.getText();
		btn2.setFont(new Font(labelFont2.getName(),Font.PLAIN,20));
		btn2.setBounds(300,200,100,50);
		
		btn2.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) 
			{
				frame2.dispose();
				new stud_login();
				
			}
			
		});
		
		btn3=new JButton("Signup");
		Font labelFont3=btn3.getFont();
		String labelText3=btn3.getText();
		btn3.setFont(new Font(labelFont3.getName(),Font.PLAIN,20));
		btn3.setBounds(300,400,100,50);
		
		btn3.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) 
			{
				frame2.dispose();
				new s_signup();
				
			}
			
		});

		
		label2=new JLabel("Already Registered?");
		Font labelFont4=label2.getFont();
		String labelText4=label2.getText();
		label2.setFont(new Font(labelFont4.getName(),Font.PLAIN,40));
		label2.setBounds(200,100,500,50);
		
		label3=new JLabel("Create new account?");
		Font labelFont5=label2.getFont();
		String labelText5=label2.getText();
		label3.setFont(new Font(labelFont5.getName(),Font.PLAIN,40));
		label3.setBounds(200,300,500,50);
		
		frame2.add(label2);
		frame2.add(label3);
		frame2.add(btn2);
		frame2.add(btn3);
		frame2.add(btn4);
		frame2.add(all);
		
	/*	Font labelFont1=frame2.getFont();
		String labelText1=frame2.getTitle();
		frame2.setFont(new Font(labelFont1.getName(),Font.PLAIN,30));*/
		
		frame2.setSize(800,800);
		frame2.setLayout(null);
		frame2.setVisible(true);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		
		
		
		
		
		
	}
	
	public static void main(String args[])
	{
		new student_page();
	}
}
