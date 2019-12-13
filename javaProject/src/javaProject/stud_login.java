package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class stud_login extends JFrame
{
	private static JFrame frame;
	private static JLabel label1;
	private static JLabel label3;
	private static JLabel label2,all;
	private static JTextField uname;
	
	private static JPasswordField upass;
	private static JButton btn,btn2;
	
	public stud_login()
	{
		frame=new JFrame();
		frame.setResizable(false);
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		btn2=new JButton("Back");
		btn2.setBounds(50,700,100,40);
		Font labelFontt1=btn2.getFont();
		String labelTextt1=btn2.getText();
		btn2.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
		btn2.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
				{
					
					new student_page();
					frame.dispose();
				}
		});
		
		
		
		label1=new JLabel("Your Email_id");
		label1.setBounds(50,200,300,30);
		Font labelFont=label1.getFont();
		String labelText=label1.getText();
		label1.setFont(new Font(labelFont.getName(),Font.BOLD,20));
		
		label3=new JLabel("Password");
		label3.setBounds(50,300,400,30);
		Font labelFont4=label3.getFont();
		String labelText4=label3.getText();
		label3.setFont(new Font(labelFont4.getName(),Font.BOLD,20));
		
		
		label2=new JLabel("_Enter your email_id and password for login_");
		label2.setBackground(Color.DARK_GRAY);
		label2.setBounds(5,5,400,30);
		Font labelFont1=label2.getFont();
		String labelText1=label2.getText();
		label2.setFont(new Font(labelFont1.getName(),Font.PLAIN,15));
		
		uname=new JTextField(250);
		uname.setBounds(300,200,400,30);
		Font labelFont2=uname.getFont();
		String labelText2=uname.getText();
		uname.setFont(new Font(labelFont2.getName(),Font.PLAIN,15));
		
		upass=new JPasswordField(250);
		upass.setBounds(300,300,400,30);
		Font labelFont5=upass.getFont();
		String labelText5=upass.getText();
		upass.setFont(new Font(labelFont5.getName(),Font.PLAIN,15));
		
		btn=new JButton("LOGIN");
		btn.setBounds(350,400,100,40);
		Font labelFont3=btn.getFont();
		String labelText3=btn.getText();
		btn.setFont(new Font(labelFont3.getName(),Font.BOLD,15));
		
		/*btn.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) 
			{
				new companyDetails();
				
			}
			
		});*/
		
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String em=uname.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					String sql="Select ss_email,ss_pass from student_signup where ss_email='"+uname.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
					String p1=upass.getText();
					String p2=rs.getString("ss_pass");
				 //   rs.beforeFirst();
					//rs.next();
					//if(em.equals(rs.getString("s_email")))
				//	if(!rs.next())
					if(p1.equals(p2))
					{
					//if(rs.next())
					//{
						
						companyDetails d=new companyDetails();
						d.createUI();
						System.out.println("login successfully");
						frame.dispose();
					}
					else
					{
							
						System.out.println("account doesn't exist");
						JOptionPane.showMessageDialog(null,"Wrong Password", "ERROR",JOptionPane.ERROR_MESSAGE);
						
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Account doesnt exist", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					/*else
					{
						JOptionPane.showMessageDialog(null,"Account doesnt exist", "ERROR",JOptionPane.ERROR_MESSAGE);
					}*/
				}catch(Exception ev)
				{
					System.out.println(ev);
				}
			}
			
		});
		
		frame.add(btn);
		frame.add(btn2);
		frame.add(uname);
		frame.add(upass);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		
		frame.add(all);
		frame.setSize(800,800);
		frame.setLayout(null);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String args[])
	{
		new stud_login();
		
	}

}
