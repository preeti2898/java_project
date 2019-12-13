	package javaProject;
	import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import java.sql.Driver;

import javax.swing.*;
public	class adminLogin extends JFrame
	{
		
		//static private JPanel contentPane;
		static private JLabel label1;
		static private JLabel user_name1;
		static private JLabel password1;
		static private JLabel label;
		static private JTextField user_name2;
		static private JPasswordField password2;
		static private JButton btn1,btn2;
		static private JLabel all;
		
	/*	private static String driver="com.mysql.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/example";
		private static String user="root";
		private static String passd="";*/

		
		 private static JFrame f;
		
		public adminLogin()
		{
			f=new JFrame("Admin Login Page");
			f.setResizable(false);
			
			ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
			all=new JLabel("",img,JLabel.CENTER);
			all.setBounds(0,0,800,800);
			
			
			label=new JLabel("(Enter your user_name and password to login into the application)");
			label.setBounds(450,720,3900,45);
			Font labelFonttt=label.getFont();
			String labelTexttt=label.getText();
			label.setFont(new Font(labelFonttt.getName(),Font.PLAIN,10));
			
			
			label1=new JLabel("ADMIN LOGIN");
			label1.setBounds(250,50,400,50);
			Font labelFont=label1.getFont(); 
			String labelText=label1.getText();
			label1.setFont(new Font(labelFont.getName(),Font.PLAIN,40));
			
			
			user_name1=new JLabel("User Name:");
			user_name1.setBounds(50,200,380,30);
			Font labelFont2=user_name1.getFont();
			String labelText2=user_name1.getText();
			user_name1.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
			
			password1=new JLabel("Password:");
			password1.setBounds(50,300,380,30);
			Font labelFont3=password1.getFont();
			String labelText3=password1.getText();
			password1.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
			
			user_name2=new JTextField(300);
			user_name2.setBounds(420,200,300,30);
			password2=new JPasswordField(300);
			password2.setBounds(420,300,300,30);
			
			btn2=new JButton("LogOut");
			btn2.setBounds(50,700,100,40);
			Font labelFontt1=btn2.getFont();
			String labelTextt1=btn2.getText();
			btn2.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
			btn2.addActionListener(new ActionListener()
			{
				
				public void actionPerformed(ActionEvent e)
					{
						
						new homePage();
						f.dispose();
					}
			});
			
			btn1=new JButton("Login");
			btn1.setBounds(300,400,200,80);
			Font labelFont1=btn1.getFont();
			String labelText1=btn1.getText();
			btn1.setFont(new Font(labelFont1.getName(),Font.PLAIN,40));
			
			btn1.addActionListener(new ActionListener()
			{
				
				//String pass=password2.getText();

				public void actionPerformed(ActionEvent e)
				{
					//String pass=password2.getText();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
						String sql="Select a_name,a_password from admin_table where a_password='"+password2.getText()+"'";
						PreparedStatement pst=con.prepareStatement(sql);
						ResultSet rs=pst.executeQuery();
						
						if(rs.next())
						{
						String s1=user_name2.getText();
						String s2=rs.getString("a_name");
						
					 //   rs.beforeFirst();
						//rs.next();
					/*	if(pass.equals(rs.getString("a_password")))
						{
							new menuForm();
							System.out.println("login successfully");
						}
						else
						{
							System.out.println("wrong password");
							
						}*/
						if(s1.equals(s2))
						{
							
							menuform m=new menuform();
							m.createUI();
							
							System.out.println("login successfully");
							f.dispose();
							
						
						}else
						{
							JOptionPane.showMessageDialog(null, "User_Name doesn't found","Message",
									JOptionPane.INFORMATION_MESSAGE);
						
						}
						}else
						{
							JOptionPane.showMessageDialog(null, "Password doesn't matched","Message",
									JOptionPane.INFORMATION_MESSAGE);
						
						}
						
					}catch(Exception ev)
					{
						System.out.println(ev);
					}
				}
				
			});
			
		
			f.add(label1);
			f.add(label);
			f.add(user_name1);
			f.add(password1);
			f.add(user_name2);
			f.add(password2);
			f.add(btn1);
			f.add(btn2);
			f.add(all);
			
			f.setLayout(null);
			f.setVisible(true);
			//f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setSize(800,800);
			
		}
		
		
		public static void main(String args[])
		{
			new adminLogin();
					
		
		}

	}

