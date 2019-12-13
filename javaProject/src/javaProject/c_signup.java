package javaProject;
import java.awt.Checkbox;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 class c_signup extends JFrame {
	private static JFrame frame;
	private static JPanel p;
	private static JTextField tf;
	private static JLabel l;
	private static JLabel all;
	private static JButton b,btn3;
	//private static Checkbox c;
	private static JComboBox branch2;
	private static JComboBox perC;
	
	private static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0;
	 private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf4;
	private static JTextField tf5;
	private static JTextField tf6;
	private static JTextField tf7;
	private static JTextField tf8;
	private static JTextField tf9;
	
	
	
	////////////////sign up//////////////////////////
	
	private static JFrame frame1;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JTextField field2;
	private static JPasswordField field3;
	private static JPasswordField field4;
	private static JButton btn2,btn1;
	
	public c_signup()
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
		
		btn1=new JButton("Back");
		btn1.setBounds(50,700,100,40);
		Font labelFontt1=btn1.getFont();
		String labelTextt1=btn1.getText();
		btn1.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
		btn1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
				{
					
					new company_page();
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
					String sql9="Select cc_email,cc_pass from company_signup where cc_email='"+field2.getText()+"'";
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
							String sql8="insert into company_signup"+"(cc_email,cc_pass)"+"values(?,?)";
							PreparedStatement pst8=conn.prepareStatement(sql8);
							
							
							pst8.setString(1,field2.getText());
							pst8.setString(2,field3.getText());
							pst8.executeUpdate();
							
							System.out.println("Successfully signed up!!");
							JOptionPane.showMessageDialog(null,"Successfully Signed Up", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							//frame.dispose();
							creg();
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
		frame1.add(btn1);
		frame1.add(all);
		frame1.setSize(800,800);
		frame1.setLayout(null);
		frame1.setVisible(true);
		

	}
	//////////company registration////////////////////////
    public void creg()
    {
    	 JButton b;
    	frame= new JFrame("COMPANY");
    	frame.setResizable(false);
    	//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	JPanel p=new JPanel();
    	
    	
    	ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
    	
    	 l1=new JLabel("COMPANY FORM");
    	 Font labelFont3=l1.getFont();
 		 String labelText3=l1.getText();
 		 l1.setFont(new Font(labelFont3.getName(),Font.BOLD,20));
    	 l1.setBounds(350,30,200,60);
    	 
    	 l2=new JLabel("Company Name");
    	 l2.setBounds(50,120,100,30);
    	 l3=new JLabel("For Branch");
    	 l3.setBounds(50,180,100,30);
    	 l4=new JLabel("Percentage Criteria");
    	 l4.setBounds(50,240,200,30);
    	 l5=new JLabel("Backlogs Allowed");
    	 l5.setBounds(50,300,200,30);
    	 l6=new JLabel("Requirement/Courses");
    	 l6.setBounds(50,360,250,30);
    	 l7=new JLabel("Max Seat");
    	 l7.setBounds(50,420,100,30);
    	 l8=new JLabel("Company Drive Date");
    	 l8.setBounds(50,480,150,30);
    	 l9=new JLabel("Email");
    	 l9.setBounds(50,540,100,30);
    	 l0=new JLabel("Package");
    	 l0.setBounds(50,600,100,30);
    	
    	 
    	 tf1=new JTextField(" ");
    	 tf1.setBounds(250,120,500,30);
    	 
    	 branch2=new JComboBox();
 		branch2.setBounds(250,180,500,30);
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
 		
    	/* tf2=new JTextField(" ");
    	 tf2.setBounds(250,160,500,30);*/
    	/* tf3=new JTextField(" ");
    	 tf3.setBounds(250,240,500,30);*/
 		
 		 perC=new JComboBox();
  		perC.setBounds(250,240,500,30);
  		DefaultComboBoxModel empModel2=new DefaultComboBoxModel();
  		empModel2.addElement("--SELECT--");
  		empModel2.addElement("ALL CLEAR");
  		empModel2.addElement("50 and above");
  		empModel2.addElement("60 and above");
  		empModel2.addElement("70 and above");
  		empModel2.addElement("80 and above");
  		perC.setModel(empModel2);
  		perC.setSelectedIndex(0);
  		perC.setEditable(true);
  	
 		
    	 tf4=new JTextField(" ");
    	 tf4.setBounds(250,300,500,30);
    	 tf5=new JTextField(" ");
    	 tf5.setBounds(250,360,500,30);
    	
    	 tf6=new JTextField(" ");
    	 tf6.setBounds(250,420,500,30);
    	 tf7=new JTextField("(year-month-date)");
    	 tf7.setBounds(250,480,500,30);
    	 tf8=new JTextField(field2.getText());
    	 tf8.setBounds(250,540,500,30);
    	 tf9=new JTextField(" ");
    	 tf9.setBounds(250,600,500,30);
    	
    	 btn3=new JButton("Back");
 		btn3.setBounds(50,700,100,40);
 		Font labelFontt122=btn3.getFont();
 		String labelTextt22=btn3.getText();
 		btn3.setFont(new Font(labelFontt122.getName(),Font.PLAIN,10));
 		btn3.addActionListener(new ActionListener()
 		{
 			
 			public void actionPerformed(ActionEvent e)
 				{
 					
 					new company_page();
 					frame.dispose();
 				}
 		});
 		
    	
   
    	 b=new JButton("Register");
    	 b.setBounds(600,700,100,40);
    	 Font labelFontt1222=b.getFont();
  		String labelTextt222=b.getText();
  		b.setFont(new Font(labelFontt1222.getName(),Font.PLAIN,10));
  		
    	 b.addActionListener(new ActionListener()
    	 {  
    		    public void actionPerformed(ActionEvent e)
    		    {  
    		           // b.setText("Sign-in");
    		    	    String emaill=tf8.getText();
    					try
    					{
    						/*String a=tf1.getText(); int t=a.length();
    						String a1=tf4.getText();int t1=a1.length();
    						String a2=tf5.getText();int t2=a2.length();
    						String a3=tf6.getText();int t3=a3.length();
    						String a4=tf7.getText();int t4=a4.length();
    						String a5=tf8.getText();int t5=a5.length();
    						String a6=tf9.getText();int t6=a6.length();*/
    						
    						
    						String value13=perC.getSelectedItem().toString();
    						String value12=branch2.getSelectedItem().toString();
    						
    					/*	if(a.length()!=0 && a1.length()!=0 && a2.length()!=0 && a3.length()!=0 && a4.length()!=0 && a5.length()!=0 && a6.length()!=0)
    						{*/
    						
    						if(value12.equals("CS/IT") || value12.equals("MECH") || value12.equals("ELECTRICAL") || value12.equals("ELECTRONICS") || value12.equals("CIVIL"))
    						{
    							
    						
    							if(value13.equals("ALL CLEAR") || value13.equals("50 and above") || value13.equals("60 and above") || value13.equals("70 and above") || value13.equals("80 and above"))
        						{
    								
    							Class.forName("com.mysql.jdbc.Driver");
    							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
    							String sql="Select c_name,c_branch,c_per,c_blog,c_req,c_seats,c_date,c_email,c_package from company_table where c_email='"+tf8.getText()+"'";
    							PreparedStatement pst=con.prepareStatement(sql);
    							ResultSet rst=pst.executeQuery();
    								if(!rst.next())
    								{
    									String sqll="insert into company_table"+"(c_name,c_branch,c_per,c_blog,c_req,c_seats,c_date,c_email,c_package)"+"values(?,?,?,?,?,?,?,?,?)";
    									PreparedStatement pstt=con.prepareStatement(sqll);
    									String sql2="insert into company_visited"+"(c_name,c_branch,c_per,c_blog,c_req,c_seats,c_date,c_email,c_package)"+"values(?,?,?,?,?,?,?,?,?)";
    									PreparedStatement psttt=con.prepareStatement(sql2);
    									
    									pstt.setString(1,tf1.getText());
    									String value2=branch2.getSelectedItem().toString();
    									pstt.setString(2,value2);
    									
    									String value3=perC.getSelectedItem().toString();
    									pstt.setString(3,value3);
    									
    									//pstt.setString(2,tf2.getText());
    									//pstt.setString(3,tf3.getText());
    									pstt.setString(4,tf4.getText());
    									pstt.setString(5,tf5.getText());
    									pstt.setString(6,tf6.getText());
    									pstt.setString(7,tf7.getText());
    									pstt.setString(8,tf8.getText());
    									pstt.setString(9,tf9.getText());
    									
    									pstt.executeUpdate();
    									
    									psttt.setString(1,tf1.getText());
    									String value1=branch2.getSelectedItem().toString();
    									psttt.setString(2,value1);
    									String value4=perC.getSelectedItem().toString();
    									psttt.setString(3,value4);
    									
    									//psttt.setString(2,tf2.getText());
    									//psttt.setString(3,tf3.getText());
    									psttt.setString(4,tf4.getText());
    									psttt.setString(5,tf5.getText());
    									psttt.setString(6,tf6.getText());
    									psttt.setString(7,tf7.getText());
    									psttt.setString(8,tf8.getText());
    									psttt.setString(9,tf9.getText());
    									
    									psttt.executeUpdate();
    									
    									
    									System.out.println("account created");
    									JOptionPane.showMessageDialog(null,"Company Registered","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    									
    									//new company_reg();
    									JOptionPane.showMessageDialog(null,"Your email_id will be your user_name for login","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    									new company_page();
    									frame.dispose();
    									
    								}
    								
    								else
    								{
    									System.out.println("account already exists from this email");
    								}
    							
        						}
    							else
    							{
    								JOptionPane.showMessageDialog(null,"Please select proper percentage criteria","ERROR",JOptionPane.ERROR_MESSAGE);
    							}
    						}
    						else
    						{
    							JOptionPane.showMessageDialog(null,"Please select proper branch","ERROR",JOptionPane.ERROR_MESSAGE);
    						}
    						//}
    					/*	else
    						{
    							JOptionPane.showMessageDialog(null,"Can't take null values","ERROR",JOptionPane.ERROR_MESSAGE);
    						}*/
									
    					}catch(Exception ev1)
    					{
    							System.out.println(ev1);
    							JOptionPane.showMessageDialog(null,"Please enter proper details (Check Date!!) ","ERROR",JOptionPane.ERROR_MESSAGE);
    							
    					}
    			}
    					
    	 });  
    	 
    	 frame.add(p);
    	//frame.show();
    	frame.add(l1);
    	frame.add(l2);frame.add(l3);frame.add(l4);frame.add(l5);frame.add(l6);frame.add(l7);frame.add(l8);
    	frame.add(l9);frame.add(l0);
    	frame.add(tf1);
    	//frame.add(tf2);
    	frame.add(branch2);
    	frame.add(perC);frame.add(tf4);
    	frame.add(tf5);
    	frame.add(tf6);frame.add(tf7);
    	frame.add(tf8);frame.add(tf9);
    	//frame.add(c1);frame.add(c2);frame.add(c3);frame.add(c4);frame.add(c5);frame.add(c6);
    	frame.add(b);
    	frame.add(btn3);
    	frame.add(all);
    	
        frame.setSize(800, 800);
        frame.setLayout(null);
       // frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
	public static void main(String[] args)
	{
		new c_signup();
	}
	
	
	
}

 
