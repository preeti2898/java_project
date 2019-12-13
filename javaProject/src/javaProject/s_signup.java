package javaProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class s_signup extends JFrame
{
	JFrame frame;
	private static JLabel label;
	private static JLabel label1;
	private static JLabel sname;
	private static JLabel year;
	private static JLabel email;
	private static JLabel course;
	private static JLabel all;
	private static JLabel branch;
	private static JLabel mob;
	private static JLabel date;
	private static JTextField sname1;
	//private static JTextField year1;
	private static JComboBox year2;
	private static JTextField email1;
	private static JTextField course1;
	//private static JTextField branch1;
	private static JComboBox branch2;
	private static JTextField mob1;
	private static JTextField date1;
	private static JButton btn,btn4;
	
	///////////////////sign up///////////////////
	private static JFrame frame1;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JTextField field2;
	private static JPasswordField field3;
	private static JPasswordField field4;
	private static JButton btn2,btn3;
	
	public s_signup()
	{
		frame1=new JFrame();
		frame1.setResizable(false);
		frame1.setTitle("Create new Account");
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		label5=new JLabel("Sign_up into Account");
		label5.setBounds(200,100,400,50);
		Font labelFont888=label5.getFont();
		String labelText888=label5.getText();
		label5.setFont(new Font(labelFont888.getName(),Font.PLAIN,30));
		
		
		label2=new JLabel("Email_id");
		label2.setBounds(50,200,200,25);
		Font labelFont111=label2.getFont();
		String labelText111=label2.getText();
		label2.setFont(new Font(labelFont111.getName(),Font.PLAIN,20));
		
		label3=new JLabel("Password");
		label3.setBounds(50,300,200,25);
		Font labelFont222=label3.getFont();
		String labelText222=label3.getText();
		label3.setFont(new Font(labelFont222.getName(),Font.PLAIN,20));
		
		label4=new JLabel("Confirm Password");
		label4.setBounds(50,400,200,25);
		Font labelFont333=label4.getFont();
		String labelText333=label4.getText();
		label4.setFont(new Font(labelFont333.getName(),Font.PLAIN,20));
		
		field2=new JTextField("");
		field2.setBounds(450,200,300,25);
		Font labelFont444=field2.getFont();
		String labelText444=field2.getText();
		field2.setFont(new Font(labelFont444.getName(),Font.PLAIN,12));
		
		
		field3=new JPasswordField("");
		field3.setBounds(450,300,300,25);
		Font labelFont555=field3.getFont();
		String labelText555=field3.getText();
		field3.setFont(new Font(labelFont555.getName(),Font.PLAIN,12));
		
		field4=new JPasswordField("");
		field4.setBounds(450,400,300,25);
		Font labelFont666=field4.getFont();
		String labelText666=field4.getText();
		field4.setFont(new Font(labelFont666.getName(),Font.PLAIN,12));
		
		btn3=new JButton("Back");
		btn3.setBounds(50,700,100,40);
		Font labelFontt1=btn3.getFont();
		String labelTextt1=btn3.getText();
		btn3.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
		btn3.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
				{
					
					new student_page();
					frame1.dispose();
				}
		});
		
		
		
		btn2=new JButton("Next");
		btn2.setBounds(600,700,100,40);
		Font labelFont777=btn2.getFont();
		String labelText777=btn2.getText();
		btn2.setFont(new Font(labelFont777.getName(),Font.PLAIN,10));
		
		
		btn2.addActionListener(new ActionListener() 
		{

			
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					boolean status=Validation.email_Validation(field2.getText());
					if(status)
					{
						
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					String sql9="Select ss_email,ss_pass from student_signup where ss_email='"+field2.getText()+"'";
					PreparedStatement pst9=conn.prepareStatement(sql9);
					ResultSet rst9=pst9.executeQuery();
					String pass1=field3.getText();
					String pass2=field4.getText();
					final String pass3=field3.getText();
					int l=pass3.length();
					if(l>=4)
					{	
					if(pass1.equals(pass2))
					{
				 	if(!rst9.next())
					{
							String sql8="insert into student_signup"+"(ss_email,ss_pass)"+"values(?,?)";
							PreparedStatement pst8=conn.prepareStatement(sql8);
							
							
							pst8.setString(1,field2.getText());
							pst8.setString(2,field3.getText());
							pst8.executeUpdate();
							
							System.out.println("Successfully signed up!!");
							
							JOptionPane.showMessageDialog(null,"Successfully signed-up!!", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							//frame.dispose();
							reg();
							frame1.dispose();
							
						}
						else
						{
							System.out.println("account already exists from this email");
							dispose();
						}
				}else
				{
					JOptionPane.showMessageDialog(null,"Password Mismatched", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				}else if(l<4)
				{
					JOptionPane.showMessageDialog(null,"Minimum 4 char required for password", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
					}else
					{
					JOptionPane.showMessageDialog(null,"Invalid Email", "Error",JOptionPane.ERROR_MESSAGE);
					}
					
						//new stud_register();
				}catch(Exception ev1)
				{
					System.out.println(ev1);
				}
				

				
			}
		});
		frame1.add(label2);
		frame1.add(label3);
		frame1.add(label4);
		frame1.add(label5);
		frame1.add(field2);
		frame1.add(field3);
		frame1.add(field4);
		frame1.add(btn2);
		frame1.add(btn3);
		frame1.add(all);
		frame1.setSize(800,800);
		frame1.setLayout(null);
		frame1.setVisible(true);
		
		
		
		
	}
	
	
	public void reg()
	{
		frame=new JFrame();
		frame.setTitle("student sign_up");
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		
		frame.setResizable(false);
		btn=new JButton("Sign Up");
		btn.setBounds(650,710,100,30);
		Font labelFont12=btn.getFont();
		String labelText12=btn.getText();
		btn.setFont(new Font(labelFont12.getName(),Font.PLAIN,10));
		
		btn4=new JButton("Back");
		btn4.setBounds(50,710,100,30);
		Font labelFontt1=btn4.getFont();
		String labelTextt1=btn4.getText();
		btn4.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
		btn4.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
				{
					
					new s_signup();
					frame.dispose();
				}
		});
		
		
		year2=new JComboBox();
		year2.setBounds(300,180,350,25);
		DefaultComboBoxModel empModel=new DefaultComboBoxModel();
		empModel.addElement("--SELECT--");
		empModel.addElement("First year");
		empModel.addElement("Second year");
		empModel.addElement("Third year");
		empModel.addElement("Fourth year");
		year2.setModel(empModel);
		year2.setSelectedIndex(0);
		year2.setEditable(true);
		
		
		
		mob1=new JTextField(300);
		mob1.setBounds(300,500,350,25);
		Font labelFont11=mob1.getFont();
		String labelText11=mob1.getText();
		mob1.setFont(new Font(labelFont11.getName(),Font.PLAIN,13));
		
		
		mob1.addKeyListener((KeyListener) new KeyListener()
			{
			public void keyPressed(java.awt.event.KeyEvent evt) 
			{
				date1.setEditable(true);
				final String phoneNumber=mob1.getText();
				int length=phoneNumber.length();
				char c=evt.getKeyChar();
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
				{
					if(length<10)
					{
						mob1.setEditable(true);
					}
					else
					{
						mob1.setEditable(false);
					}
				}
				else
				{
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
					{
						mob1.setEditable(true);
					}
					else
					{
						mob1.setEditable(false);
					}
				}
		
			}
			public void keyTyped(KeyEvent e) 
			{	}
			public void keyReleased(KeyEvent e)
			{
			}
	});
	

		btn.addActionListener(new ActionListener() 
		{

			
			public void actionPerformed(ActionEvent e) 
			{
			/*	public void actionPerformed(ActionEvent e)
				{
					String pass=password2.getText();
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
						String sql="Select a_name,a_password from admin_table where a_password='"+password2.getText()+"'";
						PreparedStatement pst=con.prepareStatement(sql);
						ResultSet rs=pst.executeQuery();
					 //   rs.beforeFirst();
						rs.next();
						if(pass.equals(rs.getString("a_password")))
						{
							new menuForm();
							System.out.println("login successfully");
						}
						else
						{
							System.out.println("wrong password");
							
						}
					}catch(Exception ev)
					{
						System.out.println(ev);
					}
				}*/
				String emaill=email1.getText();
				try
				{
					String s1=sname1.getText();int i11=s1.length();
					String s2=email1.getText();int i22=s2.length();
					String s3=course1.getText();int i33=s3.length();
					String s4=date1.getText();int i44=s4.length();
					String s5=mob1.getText();int i55=s5.length();
					String value1=branch2.getSelectedItem().toString();
					String valuee=year2.getSelectedItem().toString();
					if(i11!=0 && i22!=0 && i33!=0 && i44!=0 && i55!=0)
					{
					if(value1.equals("CS/IT") || value1.equals("MECH") || value1.equals("ELECTRICAL") || value1.equals("ELECTRONICS") || value1.equals("CIVIL"))
					{
					if(valuee.equals("First year") || valuee.equals("Second year") || valuee.equals("Third year") || valuee.equals("Fourth year"))
					{
						
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					String sql="Select s_name,s_year,s_email,s_course,s_branch,s_mob,s_date from student_table where s_email='"+email1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rst=pst.executeQuery();
				  /*rst.next();
			        rs.beforeFirst();
				    if(rst.next())
				    if(emaill.equals(rst.getString("s_email")))
				    if(rst==null)
				    if(rst.getString("s_email")==null)
				    if(emaill.equals(rst.getString("s_email")))*/
						if(!rst.next())
						{
							String sqll="insert into student_table"+"(s_name,s_year,s_email,s_course,s_branch,s_mob,s_date)"+"values(?,?,?,?,?,?,?)";
							PreparedStatement pstt=con.prepareStatement(sqll);
							
							
							pstt.setString(1,sname1.getText());
							String value=year2.getSelectedItem().toString();
							pstt.setString(2,value);
							pstt.setString(3,email1.getText());
							pstt.setString(4,course1.getText());
							String value2=branch2.getSelectedItem().toString();
							pstt.setString(5,value2);
							
							pstt.setString(6,mob1.getText());
							pstt.setString(7,date1.getText());
							pstt.executeUpdate();
							
							System.out.println("account created");
							//frame.dispose();
							JOptionPane.showMessageDialog(null,"Student Registered", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							//frame.dispose();
							//new stud_register();
							JOptionPane.showMessageDialog(null,"Your Email_id will be your user_name for login", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							new student_page();
							frame.dispose();
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account already exists from this email", "ERROR",JOptionPane.ERROR_MESSAGE);
							System.out.println("account already exists from this email");
							dispose();
						}
						
					}else
					{
						JOptionPane.showMessageDialog(null,"Please select proper year", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					}else
					{
						JOptionPane.showMessageDialog(null,"Please select proper branch", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					
						//new stud_register();
				}catch(Exception ev1)
				{
					System.out.println(ev1);
					JOptionPane.showMessageDialog(null,"Check Details OR check 'Date'", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
	
		

		label1=new JLabel("Student Registration Form");
		label1.setBounds(180,20,550,50);
		Font labelFontt1111=label1.getFont();
		String labelTextt1111=label1.getText();
		label1.setFont(new Font(labelFontt1111.getName(),Font.PLAIN,30));
		
		
		label=new JLabel("Enter your details for sign_in into app");
		label.setBounds(5,5,300,15);
		Font labelFontt=label.getFont();
		String labelTextt=label.getText();
		label.setFont(new Font(labelFontt.getName(),Font.PLAIN,10));
		
		
		sname=new JLabel("Student Name:");
		sname.setBounds(50,100,200,25);
		Font labelFont=sname.getFont();
		String labelText=sname.getText();
		sname.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
		
		
		year=new JLabel("Year:");
		year.setBounds(50,180,200,25);
		Font labelFont1=year.getFont();
		String labelText1=year.getText();
		year.setFont(new Font(labelFont1.getName(),Font.PLAIN,20));
		
		
		email=new JLabel("Email Id:");
		email.setBounds(50,260,200,25);
		Font labelFont2=email.getFont();
		String labelText2=email.getText();
		email.setFont(new Font(labelFont2.getName(),Font.PLAIN,20));
		
		
		course=new JLabel("Course:");
		course.setBounds(50,340,200,25);
		Font labelFont3=course.getFont();
		String labelText3=course.getText();
		course.setFont(new Font(labelFont3.getName(),Font.PLAIN,20));
		
		
		branch=new JLabel("Branch:");
		branch.setBounds(50,420,200,25);
		Font labelFont4=branch.getFont();
		String labelText4=branch.getText();
		branch.setFont(new Font(labelFont4.getName(),Font.PLAIN,20));
		
		
		mob=new JLabel("Mobile No:");
		mob.setBounds(50,500,200,25);
		Font labelFont5=mob.getFont();
		String labelText5=mob.getText();
		mob.setFont(new Font(labelFont5.getName(),Font.PLAIN,20));
		
		
		date=new JLabel("Date:");
		date.setBounds(50,580,200,25);
		Font labelFonttt=date.getFont();
		String labelTexttt=date.getText();
		date.setFont(new Font(labelFonttt.getName(),Font.PLAIN,20));
	
	
		sname1=new JTextField(300);
		sname1.setBounds(300,100,350,25);
		Font labelFont6=sname1.getFont();
		String labelText6=sname1.getText();
		sname1.setFont(new Font(labelFont6.getName(),Font.PLAIN,13));
		
		
		/*year1=new JTextField(300);
		year1.setBounds(300,180,350,25);
		Font labelFont7=year1.getFont();
		String labelText7=year1.getText();
		year1.setFont(new Font(labelFont7.getName(),Font.PLAIN,13));*/
		
		
		email1=new JTextField(field2.getText());
		email1.setBounds(300,260,350,25);
		Font labelFont8=email1.getFont();
		String labelText8=email1.getText();
		email1.setFont(new Font(labelFont8.getName(),Font.PLAIN,13));
		
		
		course1=new JTextField("Btech");
		course1.setBounds(300,340,350,25);
		Font labelFont9=course1.getFont();
		String labelText9=course1.getText();
		course1.setFont(new Font(labelFont9.getName(),Font.PLAIN,13));
		
		
		branch2=new JComboBox();
		branch2.setBounds(300,420,350,25);
		DefaultComboBoxModel empModel1=new DefaultComboBoxModel();
		empModel1.addElement("--SELECT--");
		empModel1.addElement("CS/IT");
		empModel1.addElement("MECH");
		empModel1.addElement("ELECTRICAL");
		empModel1.addElement("ELECTRONICS");
		empModel1.addElement("CIVIL");
		branch2.setModel(empModel1);
		branch2.setSelectedIndex(0);
		branch2.setEditable(true);
		
		/*branch1=new JTextField(300);
		branch1.setBounds(300,420,350,25);
		Font labelFont10=branch1.getFont();
		String labelText10=branch1.getText();
		branch1.setFont(new Font(labelFont10.getName(),Font.PLAIN,13));*/
		
		
		
		
		date1=new JTextField("year-month-date");
		date1.setBounds(300,580,350,25);
		Font labelFont111=date1.getFont();
		String labelText111=date1.getText();
		date1.setFont(new Font(labelFont111.getName(),Font.PLAIN,13));
		
		date1.addKeyListener((KeyListener) new KeyListener()
		{
			public void keyPressed(java.awt.event.KeyEvent evt) 
			{
				String phoneNumber=mob1.getText();
				if(phoneNumber.length()<10)
				{
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number","ERROR",
					JOptionPane.INFORMATION_MESSAGE);
					date1.setEditable(false);
				}
	
			}
			
				
			
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
					
			}	
	});

		
				
		frame.setSize(800,800);
		frame.setLayout(null);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frame.add(label);
		frame.add(label1);
		frame.add(sname);
		frame.add(sname1);
		frame.add(year);
		//frame.add(year1);
		frame.add(year2);
		frame.add(email);
		frame.add(email1);
		frame.add(course);
		frame.add(course1);
		frame.add(branch);
		//frame.add(branch1);
		frame.add(branch2);
		frame.add(mob);
		frame.add(mob1);
		frame.add(date);
		frame.add(date1);
		frame.add(btn);
		frame.add(btn4);
			frame.add(all);
	}
	public static void main(String args[])
	{
		s_signup s1=new s_signup();
		
		
	}
	

}
