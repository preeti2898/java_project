package javaProject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class menuform extends JFrame
{
	private static JFrame frame,frame1,frame2,frame3;
	//private static JPanel panel1;
	private static JMenuBar mb;
	private static JMenu file,company,admin;
	private static JMenuItem m1,m2,m3,m4,m5,m6,m7;
	private static JButton btn2,btn3;
	private static JLabel all;
	
	//private static JPanel panel;
	static JTable table,table2,table3;
	
	static String driverName = "com.mysql.jdbc.Driver";	
	static String url = "jdbc:mysql://localhost:3306/javaproject";
	static String userName = "root";
	static String password = "";
	static String[] columnNames= {"Name","Year","Email","Course","Branch","MobileNo","Date"};
	static String[] columnNames2= {"Name","For_Branch","Percentage","Backlogs","Requirements","Seats","DateOfDrive","Email","Package"};
	
	public void createUI()
	{
		frame=new JFrame("MENU FORM FOR ADMIN");
		frame.setResizable(false);
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		
		//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//panel1=new JPanel();
		mb=new JMenuBar();
		
		file=new JMenu("Student");
		Font labelFont=file.getFont();
		String labelText=file.getText();
		file.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
		
		company=new JMenu("Company");
		Font labelFont1=company.getFont();
		String labelText1=company.getText();
		company.setFont(new Font(labelFont1.getName(),Font.PLAIN,20));
		
		admin=new JMenu("Admin");
		Font labelFont2=admin.getFont();
		String labelText2=admin.getText();
		admin.setFont(new Font(labelFont2.getName(),Font.PLAIN,20));
		
		m1=new JMenuItem("Show Companies visited");
		m2=new JMenuItem("Delete student");
		m3=new JMenuItem("Show list of students");
		m4=new JMenuItem("Check Student Status");
		m5=new JMenuItem("List of companies registered");
		m6=new JMenuItem("Activate/Deactivate company");
		m7=new JMenuItem("Change Password");
		
		btn2=new JButton("Home_Page");
		btn2.setBounds(550,600,200,60);
		Font labelFontt=btn2.getFont();
		String labelTextt=btn2.getText();
		btn2.setFont(new Font(labelFontt.getName(),Font.PLAIN,20));
		
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ev)
			{
				new homePage();
				frame.dispose();
				
			}
			
		});
		
		btn3=new JButton("Back");
		btn3.setBounds(50,620,100,40);
		Font labelFontttt=btn3.getFont();
		String labelTextttt=btn3.getText();
		btn3.setFont(new Font(labelFontttt.getName(),Font.PLAIN,10));
		
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ev)
			{
				new homePage();
				frame.dispose();
			}
			
		});
		
		

		/*m3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				m2=(JMenuItem)e.getSource();
				System.out.println("Showing Table Data.....");
				showStudentTableData();
			}
			
		});
		
		m5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evv)
			{
				m5=(JMenuItem)evv.getSource();
				System.out.println("Showing Table Data.....");
				showCompanyTableData();
			}
			
		});*/
		
		company.add(m1);
		file.add(m2);
		file.add(m3);
		file.add(m4);
		company.add(m5);
		company.add(m6);
		admin.add(m7);
		
		mb.add(file);
		mb.add(company);
		mb.add(admin);
		
		file.setMnemonic(KeyEvent.VK_S);
		company.setMnemonic(KeyEvent.VK_C);
		admin.setMnemonic(KeyEvent.VK_A);
		
		frame.setJMenuBar(mb);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(all);
		frame.setSize(800,800);
		frame.setLayout(null);
		frame.setVisible(true);
		
		m4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e9)
			{
				m4=(JMenuItem)e9.getSource();
				System.out.println("Showing Student Status.....");
				//showStudentTableData();
				studentStatus st=new studentStatus();
			}
			
		});
		
		
		m3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				m3=(JMenuItem)e.getSource();
				System.out.println("Showing Student Table Data.....");
				showStudentTableData();
			}
			
		});
		
		m5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evv)
			{
				m5=(JMenuItem)evv.getSource();
				System.out.println("Showing Company Table Data.....");
				showCompanyTableData();
			}
			
		});
		m1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evv7)
			{
				m1=(JMenuItem)evv7.getSource();
				System.out.println("Showing Companies Visited.....");
				showCompanyVisitedData();
			}
			
		});
		m2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e4)
			{
				m2=(JMenuItem)e4.getSource();
				System.out.println("Deleting Student Table Data.....");
				deleteStudentTableData();
			}
			
		});
		m6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e5)
			{
				m6=(JMenuItem)e5.getSource();
				System.out.println("Deleting Company Table Data.....");
				deleteCompanyTableData();
			}
			
		});
		
		m7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e6)
			{
				m7=(JMenuItem)e6.getSource();
				System.out.println("Change password here.....");
				new changepassword();
				frame.dispose();
			}
			
		});

	
		
	}
	
	
	
	//////////Student table fetch////////////////////////////////////
	protected static void showStudentTableData() 
	{
		frame1=new JFrame("Database Search Result");
		frame1.setLayout(new BorderLayout());
		frame1.setResizable(false);
		
		
		
		//frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table=new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		
		table.setDefaultEditor(Object.class,null);
		
		table.addMouseListener(new MouseListener()
		{
				@Override
			public void mouseClicked(MouseEvent e)
			{
			}
			@Override
			public void mousePressed(MouseEvent e) {
				  JFrame frame;
				  frame=new JFrame();
				  
					 //JLabel label;
					 JLabel label1,all1;
					 JLabel sname;
					 JLabel year;
					 JLabel email;
					 JLabel course;
					JLabel branch;
					 JLabel mob;
					 JLabel date;
					 JButton btn2;
					 JTextField sname1;
					 JTextField year1;
					 JTextField email1;
					 JTextField course1;
					 JTextField branch1;
					 JTextField mob1;
					 JTextField date1;
					// JButton btn;
						
					 ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
						all1=new JLabel("",img,JLabel.CENTER);
						all1.setBounds(0,0,800,800);
					
					 
					 btn2=new JButton("Back");
						btn2.setBounds(50,700,100,40);
						Font labelFontt12=btn2.getFont();
						String labelTextt12=btn2.getText();
						btn2.setFont(new Font(labelFontt12.getName(),Font.PLAIN,10));
						btn2.addActionListener(new ActionListener()
						{
							
							public void actionPerformed(ActionEvent e)
								{
									
									
									frame.dispose();
								}
						});
						
					 
		    	label1=new JLabel("Student Details");
				label1.setBounds(220,20,550,50);
				Font labelFontt1=label1.getFont();
				String labelTextt1=label1.getText();
				label1.setFont(new Font(labelFontt1.getName(),Font.PLAIN,30));
				label1.setForeground(Color.WHITE);
				
				sname=new JLabel("Student Name:");
				sname.setBounds(50,100,200,25);
				Font labelFont=sname.getFont();
				String labelText=sname.getText();
				sname.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
				sname.setForeground(Color.WHITE);
				
				year=new JLabel("Year:");
				year.setBounds(50,180,200,25);
				Font labelFont1=year.getFont();
				String labelText1=year.getText();
				year.setFont(new Font(labelFont1.getName(),Font.PLAIN,20));
				year.setForeground(Color.WHITE);
				
				email=new JLabel("Email Id:");
				email.setBounds(50,260,200,25);
				Font labelFont2=email.getFont();
				String labelText2=email.getText();
				email.setFont(new Font(labelFont2.getName(),Font.PLAIN,20));
				email.setForeground(Color.WHITE);
				
				course=new JLabel("Course:");
				course.setBounds(50,340,200,25);
				Font labelFont3=course.getFont();
				String labelText3=course.getText();
				course.setFont(new Font(labelFont3.getName(),Font.PLAIN,20));
				course.setForeground(Color.WHITE);
				
				branch=new JLabel("Branch:");
				branch.setBounds(50,420,200,25);
				Font labelFont4=branch.getFont();
				String labelText4=branch.getText();
				branch.setFont(new Font(labelFont4.getName(),Font.PLAIN,20));
				branch.setForeground(Color.WHITE);
				
				mob=new JLabel("Mobile No:");
				mob.setBounds(50,500,200,25);
				Font labelFont5=mob.getFont();
				String labelText5=mob.getText();
				mob.setFont(new Font(labelFont5.getName(),Font.PLAIN,20));
				mob.setForeground(Color.WHITE);
				
				date=new JLabel("Date:");
				date.setBounds(50,580,200,25);
				Font labelFonttt=date.getFont();
				String labelTexttt=date.getText();
				date.setFont(new Font(labelFonttt.getName(),Font.PLAIN,20));
				date.setForeground(Color.WHITE);
			
				sname1=new JTextField(300);
				sname1.setBounds(300,100,350,25);
				Font labelFont6=sname1.getFont();
				String labelText6=sname1.getText();
				sname1.setFont(new Font(labelFont6.getName(),Font.PLAIN,13));
				
				
				year1=new JTextField(300);
				year1.setBounds(300,180,350,25);
				Font labelFont7=year1.getFont();
				String labelText7=year1.getText();
				year1.setFont(new Font(labelFont7.getName(),Font.PLAIN,13));
				
				
				email1=new JTextField(300);
				email1.setBounds(300,260,350,25);
				Font labelFont8=email1.getFont();
				String labelText8=email1.getText();
				email1.setFont(new Font(labelFont8.getName(),Font.PLAIN,13));
				
				
				course1=new JTextField(300);
				course1.setBounds(300,340,350,25);
				Font labelFont9=course1.getFont();
				String labelText9=course1.getText();
				course1.setFont(new Font(labelFont9.getName(),Font.PLAIN,13));
				
				
				branch1=new JTextField(300);
				branch1.setBounds(300,420,350,25);
				Font labelFont10=branch1.getFont();
				String labelText10=branch1.getText();
				branch1.setFont(new Font(labelFont10.getName(),Font.PLAIN,13));
				
				
				mob1=new JTextField(300);
				mob1.setBounds(300,500,350,25);
				Font labelFont11=mob1.getFont();
				String labelText11=mob1.getText();
				mob1.setFont(new Font(labelFont11.getName(),Font.PLAIN,13));
				
				date1=new JTextField("year-month-date");
				date1.setBounds(300,580,350,25);
				Font labelFont111=date1.getFont();
				String labelText111=date1.getText();
				date1.setFont(new Font(labelFont111.getName(),Font.PLAIN,13));
			
			
				frame.setSize(800,800);
				frame.setLayout(null);
				frame.setVisible(true);
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			
				 sname1.setText("");
		    	 year1.setText("");
		    	 email1.setText("");
		    	 course1.setText("");
		    	 branch1.setText("");
		    	 mob1.setText("");
		    	 date1.setText("");
		    	
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				sname1.setText(model.getValueAt(i, 0).toString());
				year1.setText(model.getValueAt(i, 1).toString());
				email1.setText(model.getValueAt(i, 2).toString());
				course1.setText(model.getValueAt(i, 3).toString());
				branch1.setText(model.getValueAt(i, 4).toString());
				mob1.setText(model.getValueAt(i, 5).toString());
				date1.setText(model.getValueAt(i, 6).toString());
				
				frame.add(label1);
				frame.add(sname);
				frame.add(sname1);
				frame.add(year);
				frame.add(year1);
				frame.add(email);
				frame.add(email1);
				frame.add(course);
				frame.add(course1);
				frame.add(branch);
				frame.add(branch1);
				frame.add(mob);
				frame.add(mob1);
				frame.add(date);
				frame.add(date1);
				frame.add(btn2);
				
				frame.setSize(800,800);
				frame.setLayout(null);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.add(all1);
				
								
				
			}


			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

						
		});
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String Namee="";
		String Yearr="";
		String Emaill="";
		String Coursee="";
		String Branchh="";
		String Mobb="";
		String Datee="";
		try
		{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql="select * from student_table";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				Namee=rs.getString("s_name");
				Yearr=rs.getString("s_year");
				Emaill=rs.getString("s_email");
				Coursee=rs.getString("s_course");
				Branchh=rs.getString("s_branch");
				Mobb=rs.getString("s_mob");
				Datee=rs.getString("s_date");
				model.addRow(new Object[]{Namee,Yearr,Emaill,Coursee,Branchh,Mobb,Datee});
				i++;
				
			}
			if(i <1)
			{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i ==1)
			{	
				System.out.println(i+" Record Found");
			}
			else
			{
				System.out.println(i+" Records Found");
			}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setSize(800,200);
		//frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//////////////////////////Delete Student Table//////////////////////
	
	protected static void deleteStudentTableData() 
	{
		//int p = JOptionPane.YES_NO_OPTION;
	    int p=JOptionPane.showConfirmDialog (null, "Are you sure you want to delete?","Warning",JOptionPane.YES_NO_OPTION);

	    if (p == 0)
	    {
	
	  try
		{
		 	
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql9="delete from student_table";
			String sql8="delete from student_signup";
			PreparedStatement ps9=con.prepareStatement(sql9);
			PreparedStatement ps8=con.prepareStatement(sql8);
			ps9.executeUpdate();
			ps8.executeUpdate();
			JOptionPane.showMessageDialog(null, "Table Deleted","Message",
						JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception ex1)
		{
			JOptionPane.showMessageDialog(null, ex1.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
	    }else
	    {
	    	System.out.println("Request Cancelled!!");
	    }
		
	    
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setSize(800,200);
		//frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	///////////////////Company table data///////////////////////
	protected static void showCompanyTableData() 
	{
		frame2=new JFrame("Database Search Result");
		frame2.setLayout(new BorderLayout());
		frame2.setResizable(false);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DefaultTableModel model2=new DefaultTableModel();
		model2.setColumnIdentifiers(columnNames2);
		table2=new JTable();
		table2.setModel(model2);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table2.setFillsViewportHeight(true);
		
		table2.setDefaultEditor(Object.class,null);
		
		table2.addMouseListener(new MouseListener()
		{

			JFrame f=new  JFrame("");
			
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
			}
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,all2;
		    	JTextField tf1,tf2,tf3,tf5,tf4,tf6,tf7,tf8,tf9;
		    	JButton btn2;
		    JFrame f=new  JFrame("");
		    
		    ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
			all2=new JLabel("",img,JLabel.CENTER);
			all2.setBounds(0,0,800,800);
		
			 btn2=new JButton("Back");
				btn2.setBounds(50,700,100,40);
				Font labelFontt12=btn2.getFont();
				String labelTextt12=btn2.getText();
				btn2.setFont(new Font(labelFontt12.getName(),Font.PLAIN,10));
				btn2.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e)
						{
							
							
							f.dispose();
						}
				});
				
				
			
		    	//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    	 l1=new JLabel("COMPANY DETAILS");
		    	 Font labelFont3=l1.getFont();
		 		 String labelText3=l1.getText();
		 		 l1.setFont(new Font(labelFont3.getName(),Font.BOLD,20));
		    	 l1.setBounds(350,30,200,60);
		    	 l1.setForeground(Color.WHITE);
		    	 l2=new JLabel("Company Name");
		    	 l2.setBounds(50,110,100,30);
		    	 l2.setForeground(Color.WHITE);
		    	 l3=new JLabel("For Branch");
		    	 l3.setBounds(50,160,100,30);
		    	 l3.setForeground(Color.WHITE);
		    	 l4=new JLabel("Percentage Criteria");
		    	 l4.setBounds(50,210,200,30);
		    	 l4.setForeground(Color.WHITE);
		    	 l5=new JLabel("Backlogs Allowed");
		    	 l5.setBounds(50,260,200,30);
		    	 l5.setForeground(Color.WHITE);
		    	 l6=new JLabel("Requirement/Courses");
		    	 l6.setBounds(50,310,250,30);
		    	 l6.setForeground(Color.WHITE);
		    	 l7=new JLabel("Max Seat");
		    	 l7.setBounds(50,410,100,30);
		    	 l7.setForeground(Color.WHITE);
		    	 l8=new JLabel("Company Drive Date");
		    	 l8.setForeground(Color.WHITE);
		    	 l8.setBounds(50,460,150,30);
		    	 l9=new JLabel("Email");
		    	 l9.setBounds(50,510,100,30);
		    	 l9.setForeground(Color.WHITE);
		    	 l0=new JLabel("Package");
		    	 l0.setBounds(50,560,100,30);
		    	 l0.setForeground(Color.WHITE);
		    	
		    	 
		    	 tf1=new JTextField(" ");
		    	 tf1.setBounds(250,110,500,30);
		    	 tf2=new JTextField(" ");
		    	 tf2.setBounds(250,160,500,30);
		    	 tf3=new JTextField(" ");
		    	 tf3.setBounds(250,210,500,30);
		    	 tf4=new JTextField(" ");
		    	 tf4.setBounds(250,260,500,30);
		    	 tf5=new JTextField(" ");
		    	 tf5.setBounds(250,310,500,30);
		    	
		    	 tf6=new JTextField(" ");
		    	 tf6.setBounds(250,410,500,30);
		    	 tf7=new JTextField("(year-month-date)");
		    	 tf7.setBounds(250,460,500,30);
		    	 tf8=new JTextField(" ");
		    	 tf8.setBounds(250,510,500,30);
		    	 tf9=new JTextField(" ");
		    	 tf9.setBounds(250,560,500,30);
		    	 
		    	 tf1.setText("");
		    	 tf2.setText("");
		    	 tf3.setText("");
		    	 tf4.setText("");
		    	 tf5.setText("");
		    	 tf6.setText("");
		    	 tf7.setText("");
		    	 tf8.setText("");
		    	 tf9.setText("");
		    	
		    	 
		    	
		    			    
				int i=table2.getSelectedRow();
				TableModel model2=table2.getModel();
				tf1.setText(model2.getValueAt(i, 0).toString());
				tf2.setText(model2.getValueAt(i, 1).toString());
				tf3.setText(model2.getValueAt(i, 2).toString());
				tf4.setText(model2.getValueAt(i, 3).toString());
				tf5.setText(model2.getValueAt(i, 4).toString());
				tf6.setText(model2.getValueAt(i, 5).toString());
				tf7.setText(model2.getValueAt(i, 6).toString());
				tf8.setText(model2.getValueAt(i, 7).toString());
				tf9.setText(model2.getValueAt(i, 8).toString());
				
				
				f.add(tf1);
				f.add(tf2);
				f.add(tf3);
				f.add(tf4);
				f.add(tf5);
				f.add(tf6);
				f.add(tf7);
				f.add(tf8);
				f.add(tf9);
				f.add(l1);
				f.add(l2);
				f.add(l3);
				f.add(l4);
				f.add(l5);
				f.add(l6);
				f.add(l7);
				f.add(l8);
				f.add(l9);
				f.add(l0);
				f.add(btn2);
				f.add(all2);
				f.setSize(800,800);
				f.setLayout(null);
				f.setVisible(true);
				
			}


			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

						
		});

		
		JScrollPane scroll2 = new JScrollPane(table2);
		scroll2.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String Namee2="";
		String Branchh2="";
		String Perr2="";
		String Backlog2="";
		String Req2="";
		String Seats2="";
		String Date2="";
		String Email2="";
		String Package2="";
		try
		{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql2="select * from company_table";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ResultSet rs2=ps2.executeQuery();
			int i2=0;
			while(rs2.next())
			{
				Namee2=rs2.getString("c_name");
				Branchh2=rs2.getString("c_branch");
				Perr2=rs2.getString("c_per");
				Backlog2=rs2.getString("c_blog");
				Req2=rs2.getString("c_req");
				Seats2=rs2.getString("c_seats");
				Date2=rs2.getString("c_date");
				Email2=rs2.getString("c_email");
				Package2=rs2.getString("c_package");
			
				model2.addRow(new Object[]{Namee2,Branchh2,Perr2,Backlog2,Req2,Seats2,Date2,Email2,Package2});
				i2++;
				
			}
			if(i2 <1)
			{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i2 ==1)
			{	
				System.out.println(i2+" Record Found");
			}
			else
			{
				System.out.println(i2+" Records Found");
			}
		}catch(Exception exx)
		{
			JOptionPane.showMessageDialog(null, exx.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame2.add(scroll2);
		frame2.setVisible(true);
		frame2.setSize(800,200);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	///////////////////Delete Company Table/////////////////////
	protected static void deleteCompanyTableData() 
	{
		int p = JOptionPane.YES_NO_OPTION;
	    JOptionPane.showConfirmDialog (null, "Are you sure you want to delete?","Warning",p);

	    if (p ==1)
	    {
		try
		{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql2="delete from  company_table";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.executeUpdate();
				JOptionPane.showMessageDialog(null, "Company Table Deleted","Message",
						JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception exx1)
		{
			JOptionPane.showMessageDialog(null, exx1.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
	    }else if(p!=0){
	    	System.out.println("Request cancelled");
	    }
		frame2.setVisible(true);
		frame2.setResizable(false);
		frame2.setSize(1000,400);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//////////////////Company Visited Table///////////////////
	
	protected static void showCompanyVisitedData() 
	{
		frame3=new JFrame("Database Search Result");
		frame3.setLayout(new BorderLayout());
		frame3.setResizable(false);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DefaultTableModel model3=new DefaultTableModel();
		model3.setColumnIdentifiers(columnNames2);
		table3=new JTable();
		table3.setModel(model3);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table3.setFillsViewportHeight(true);
		
		table3.setDefaultEditor(Object.class,null);
		
		table3.addMouseListener(new MouseListener()
		{

			
			public void mouseClicked(MouseEvent e)
			{
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
					JFrame f=new  JFrame("");
					
				JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,all4;
		    	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
		    	JButton b,btn2;
		    	 btn2=new JButton("Back");
					btn2.setBounds(50,700,100,40);
					Font labelFontt12=btn2.getFont();
					String labelTextt12=btn2.getText();
					btn2.setFont(new Font(labelFontt12.getName(),Font.PLAIN,10));
					btn2.addActionListener(new ActionListener()
					{
						
						public void actionPerformed(ActionEvent e)
							{
								
								
								f.dispose();
							}
					});
					
					ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
					all4=new JLabel("",img,JLabel.CENTER);
					all4.setBounds(0,0,800,800);
					
					
		    	 
		    	 l1=new JLabel("COMPANY DETAILS");
		    	 Font labelFont3=l1.getFont();
		 		 String labelText3=l1.getText();
		 		 l1.setFont(new Font(labelFont3.getName(),Font.BOLD,20));
		    	 l1.setBounds(300,30,200,60);
		    	 l1.setForeground(Color.WHITE);
		    	 l2=new JLabel("Company Name");
		    	 l2.setBounds(50,110,100,30);
		    	 l2.setForeground(Color.WHITE);
		    	 l3=new JLabel("For Branch");
		    	 l3.setBounds(50,160,100,30);
		    	 l3.setForeground(Color.WHITE);
		    	 l4=new JLabel("Percentage Criteria");
		    	 l4.setBounds(50,210,200,30);
		    	 l4.setForeground(Color.WHITE);
		    	 l5=new JLabel("Backlogs Allowed");
		    	 l5.setBounds(50,260,200,30);
		    	 l5.setForeground(Color.WHITE);
		    	 l6=new JLabel("Requirement/Courses");
		    	 l6.setBounds(50,310,250,30);
		    	 l6.setForeground(Color.WHITE);
		    	 l7=new JLabel("Max Seat");
		    	 l7.setBounds(50,410,100,30);
		    	 l7.setForeground(Color.WHITE);
		    	 l8=new JLabel("Company Drive Date");
		    	 l8.setBounds(50,460,150,30);
		    	 l8.setForeground(Color.WHITE);
		    	 l9=new JLabel("Email");
		    	 l9.setBounds(50,510,100,30);
		    	 l9.setForeground(Color.WHITE);
		    	 l0=new JLabel("Package");
		    	 l0.setBounds(50,560,100,30);
		    	 l0.setForeground(Color.WHITE);
		    	
		    	 
		    	 tf1=new JTextField(" ");
		    	 tf1.setBounds(250,110,500,30);
		    	 tf2=new JTextField(" ");
		    	 tf2.setBounds(250,160,500,30);
		    	 tf3=new JTextField(" ");
		    	 tf3.setBounds(250,210,500,30);
		    	 tf4=new JTextField(" ");
		    	 tf4.setBounds(250,260,500,30);
		    	 tf5=new JTextField(" ");
		    	 tf5.setBounds(250,310,500,30);
		    	
		    	 tf6=new JTextField(" ");
		    	 tf6.setBounds(250,410,500,30);
		    	 tf7=new JTextField("(year-month-date)");
		    	 tf7.setBounds(250,460,500,30);
		    	 tf8=new JTextField(" ");
		    	 tf8.setBounds(250,510,500,30);
		    	 tf9=new JTextField(" ");
		    	 tf9.setBounds(250,560,500,30);
		    	 
		    	 tf1.setText("");
		    	 tf2.setText("");
		    	 tf3.setText("");
		    	 tf4.setText("");
		    	 tf5.setText("");
		    	 tf6.setText("");
		    	 tf7.setText("");
		    	 tf8.setText("");
		    	 tf9.setText("");
		    	
		    	 
		    	
		    	
		    	
				int i=table3.getSelectedRow();
				TableModel model3=table3.getModel();
				tf1.setText(model3.getValueAt(i, 0).toString());
				tf2.setText(model3.getValueAt(i, 1).toString());
				tf3.setText(model3.getValueAt(i, 2).toString());
				tf4.setText(model3.getValueAt(i, 3).toString());
				tf5.setText(model3.getValueAt(i, 4).toString());
				tf6.setText(model3.getValueAt(i, 5).toString());
				tf7.setText(model3.getValueAt(i, 6).toString());
				tf8.setText(model3.getValueAt(i, 7).toString());
				tf9.setText(model3.getValueAt(i, 8).toString());
				f.add(tf1);
				f.add(tf2);
				f.add(tf3);
				f.add(tf4);
				f.add(tf5);
				f.add(tf6);
				f.add(tf7);
				f.add(tf8);
				f.add(tf9);
				f.add(l1);
				f.add(l2);
				f.add(l3);
				f.add(l4);
				f.add(l5);
				f.add(l6);
				f.add(l7);
				f.add(l8);
				f.add(l9);
				f.add(l0);
				f.add(btn2);
				f.add(all4);
				f.setSize(800,800);
				f.setLayout(null);
				f.setVisible(true);
			
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//f.dispose();
				
			}

						
		});


		
		JScrollPane scroll3 = new JScrollPane(table3);
		scroll3.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll3.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String Namee3="";
		String Branchh3="";
		String Perr3="";
		String Backlog3="";
		String Req3="";
		String Seats3="";
		String Date3="";
		String Email3="";
		String Package3="";
		try
		{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql3="select * from company_visited";
			PreparedStatement ps3=con.prepareStatement(sql3);
			ResultSet rs3=ps3.executeQuery();
			int i3=0;
			while(rs3.next())
			{
				Namee3=rs3.getString("c_name");
				Branchh3=rs3.getString("c_branch");
				Perr3=rs3.getString("c_per");
				Backlog3=rs3.getString("c_blog");
				Req3=rs3.getString("c_req");
				Seats3=rs3.getString("c_seats");
				Date3=rs3.getString("c_date");
				Email3=rs3.getString("c_email");
				Package3=rs3.getString("c_package");
			
				model3.addRow(new Object[]{Namee3,Branchh3,Perr3,Backlog3,Req3,Seats3,Date3,Email3,Package3});
				i3++;
				
			}
			if(i3 <1)
			{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i3 ==1)
			{	
				System.out.println(i3+" Record Found");
			}
			else
			{
				System.out.println(i3+" Records Found");
			}
		}catch(Exception exxx)
		{
			JOptionPane.showMessageDialog(null, exxx.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		frame3.add(scroll3);
		frame3.setVisible(true);
		frame3.setSize(800,200);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		menuform dm=new menuform();
		dm.createUI();
	}
}
