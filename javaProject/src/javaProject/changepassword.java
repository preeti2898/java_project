package javaProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class changepassword extends JFrame
{
	private static JFrame frame;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JLabel all;
	private static JTextField field1;
	private static JPasswordField field2;
	private static JPasswordField field3;
	private static JTextField field4;
	private static JButton btn,btn3;
	
	static String driverName = "com.mysql.jdbc.Driver";	
	static String url = "jdbc:mysql://localhost:3306/javaproject";
	static String userName = "root";
	static String password = "";
	
	

	public changepassword()
	{
		frame =new JFrame("change password");
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		
		label1=new JLabel("Admin Password Change");
		label1.setBounds(180,20,550,50);
		Font labelFontt1=label1.getFont();
		String labelTextt1=label1.getText();
		label1.setFont(new Font(labelFontt1.getName(),Font.PLAIN,30));
		
		label5=new JLabel("User_Name");
		label5.setBounds(50,100,300,50);
		Font labelFont21=label5.getFont();
		String labelText21=label5.getText();
		label5.setFont(new Font(labelFont21.getName(),Font.PLAIN,20));
		
		
		label2=new JLabel("Old Password");
		label2.setBounds(50,200,300,50);
		Font labelFont2=label2.getFont();
		String labelText2=label2.getText();
		label2.setFont(new Font(labelFont2.getName(),Font.PLAIN,20));
		
		label3=new JLabel("New Password");
		label3.setBounds(50,300,300,50);
		Font labelFont3=label3.getFont();
		String labelText3=label3.getText();
		label3.setFont(new Font(labelFont3.getName(),Font.PLAIN,20));
		
		label4=new JLabel("Confirm New Password");
		label4.setBounds(50,400,300,50);
		Font labelFont8=label4.getFont();
		String labelText8=label4.getText();
		label4.setFont(new Font(labelFont8.getName(),Font.PLAIN,20));
		
		
		field1=new JTextField("");
		field1.setBounds(400,200,300,30);
		Font labelFont4=field1.getFont();
		String labelText4=field1.getText();
		field1.setFont(new Font(labelFont4.getName(),Font.PLAIN,20));
	
		field2=new JPasswordField("");
		field2.setBounds(400,300,300,30);
		Font labelFont5=field2.getFont();
		String labelText5=field2.getText();
		field2.setFont(new Font(labelFont5.getName(),Font.PLAIN,20));
	
		field3=new JPasswordField("");
		field3.setBounds(400,400,300,30);
		Font labelFont7=field3.getFont();
		String labelText7=field3.getText();
		field3.setFont(new Font(labelFont7.getName(),Font.PLAIN,20));
		
		field4=new JTextField("");
		field4.setBounds(400,100,300,30);
		Font labelFont9=field4.getFont();
		String labelText9=field4.getText();
		field4.setFont(new Font(labelFont9.getName(),Font.PLAIN,20));
		
		btn3=new JButton("Back");
		btn3.setBounds(20,680,100,40);
		Font labelFontttt=btn3.getFont();
		String labelTextttt=btn3.getText();
		btn3.setFont(new Font(labelFontttt.getName(),Font.PLAIN,10));
		
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evvv)
			{
				
				menuform m=new menuform();
				m.createUI();
				changepassword.frame.dispose();
			}
			
		});
	
	
		
		btn=new JButton("Change");
		btn.setBounds(300,500,130,30);
		Font labelFont6=btn.getFont();
		String labelText6=btn.getText();
		btn.setFont(new Font(labelFont6.getName(),Font.PLAIN,20));
		
		btn.addActionListener(new ActionListener()
		{

			
			public void actionPerformed(ActionEvent e)
			{
				String pass=field1.getText();
				String newpass=field2.getText();
				String newpass1=field3.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					String sql="Select a_name,a_password from admin_table where a_password='"+field1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rst=pst.executeQuery();
					if(newpass.equals(newpass1))
					{
					
					if(rst.next())
						{
							String sqll="UPDATE admin_table SET a_name=?, a_password=? WHERE a_password=?";
							PreparedStatement pstt=con.prepareStatement(sqll);
						
							pstt.setString(1,field4.getText());
							pstt.setString(2,field2.getText());
							pstt.setString(3,field1.getText());
							pstt.executeUpdate();
							
							System.out.println("Password Changed");
							frame.dispose();
							JOptionPane.showMessageDialog(null,"Password Changed", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							//new stud_register();
							
						}
						else
						{
							System.out.println("Account doesnt exist!!");
							dispose();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"New password doesnt match", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
						System.out.println("try again");
					}
					
						//new stud_register();
				}catch(Exception ev1)
				{
					System.out.println(ev1);
				}
			}
			
			
		});

				
		
		
	
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(field1);
		frame.add(field2);
		frame.add(field3);
		frame.add(field4);
		frame.add(btn);
		frame.add(btn3);
		frame.add(all);
		
		frame.setSize(800,800);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	public static void main(String args[])
	{
		new changepassword();
		
	}

}
