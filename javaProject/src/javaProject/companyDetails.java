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

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class companyDetails extends JFrame
{
	private static JFrame frame,frame2,frame3;
	//private static JPanel panel1;
		//private static JButton btn2;
		private static JButton btn3,btn4;
		private static JButton btn1;
		private static JLabel label,all;
		private static JLabel label1,label2;
		static JComboBox b;
	
	//private static JPanel panel;
	static JTable table2,table3;
	
	static String driverName = "com.mysql.jdbc.Driver";	
	static String url = "jdbc:mysql://localhost:3306/javaproject";
	static String userName = "root";
	static String password = "";
	static String[] columnNames2= {"Name","For_Branch","Percentage","Backlogs","Requirements","Seats","DateOfDrive","Email","Package"};
	
	public void createUI()
	{
		
		label=new JLabel(" YOU HAVE SUCCESSFULLY LOGGED IN.... !!  ");
		label.setBounds(40,60,700,60);
		Font labelFontt2=label.getFont();
		String labelTextt2=label.getText();
		label.setFont(new Font(labelFontt2.getName(),Font.PLAIN,28));
	
		label1=new JLabel(" (Now you can view company details)  ");
		label1.setBounds(40,130,700,60);
		Font labelFont12=label.getFont();
		String labelText12=label.getText();
		label1.setFont(new Font(labelFont12.getName(),Font.PLAIN,15));
	
		label2=new JLabel("Select your branch:");
		label2.setBounds(300,250,200,20);
		Font labelFont3=label2.getFont();
		String labelText3=label2.getText();
		label2.setFont(new Font(labelFont3.getName(),Font.PLAIN,18));
	
		
		frame=new JFrame("COMPANY DETAILS");
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		b=new JComboBox();
		b.setBounds(300,300,200,20);
		DefaultComboBoxModel empModel1=new DefaultComboBoxModel();
		empModel1.addElement("--SELECT--");
		empModel1.addElement("CS/IT");
		empModel1.addElement("MECH");
		empModel1.addElement("ELECTRICAL");
		empModel1.addElement("ELECTRONICS");
		empModel1.addElement("CIVIL");
		b.setModel(empModel1);
		b.setSelectedIndex(0);
		b.setEditable(true);
		
		
		
	/*	btn2=new JButton("Log Out");
		btn2.setBounds(550,600,120,25);
		Font labelFontttt=btn2.getFont();
		String labelTextttt=btn2.getText();
		btn2.setFont(new Font(labelFontttt.getName(),Font.PLAIN,20));
		
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ev2)
			{
				frame.dispose();
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			}
			
		});*/
		btn4=new JButton("Home Page");
		btn4.setBounds(600,700,100,40);
		Border border= BorderFactory.createLineBorder(Color.CYAN);
		btn4.setBorder(border);
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new homePage();
				frame.dispose();
			}
		});
		
		btn1=new JButton("Show Company Details");
		btn1.setBounds(200,400,400,60);
		Border border1= BorderFactory.createLineBorder(Color.WHITE);
		btn1.setBorder(border1);
		
		Font labelFontt1=btn1.getFont();
		String labelTextt1=btn1.getText();
		btn1.setFont(new Font(labelFontt1.getName(),Font.PLAIN,20));
		
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				System.out.println("Showing Table Data.....");
				showCompanyTableData();
			}
			
		});
		
		btn3=new JButton("Companies Visited");
		btn3.setBounds(200,550,400,60);
		//sBorder border1= BorderFactory.createLineBorder(Color.WHITE);
		btn3.setBorder(border1);
		
		Font labelFontt5=btn3.getFont();
		String labelTextt5=btn3.getText();
		btn3.setFont(new Font(labelFontt5.getName(),Font.PLAIN,20));
		
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ev2)
			{
				System.out.println("Showing Companies Visited.....");
				showCompanyVisitedData();
		
			}
			
		});
		
	
		
		//frame.add(btn2);
		frame.add(btn1);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(label);
		frame.add(label2);
		frame.add(label1);
		frame.add(b);
		frame.add(all);
		frame.setSize(800,800);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	////////////////////Companies Visited///////////////////////
	
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
				
				JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,all1;
		    	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
		    	JButton btn2;
		    	
		    	btn2=new JButton("Back");
				btn2.setBounds(50,700,100,40);
				Font labelFontt1=btn2.getFont();
				String labelTextt1=btn2.getText();
				btn2.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
				btn2.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e)
						{
							
							
							f.dispose();
						}
				});
				
		    	
		    	 ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
					all1=new JLabel("",img,JLabel.CENTER);
					all1.setBounds(0,0,800,800);
				 
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
				f.add(all1);
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
			String value1=b.getSelectedItem().toString();
			if(value1.equals("CS/IT") || value1.equals("MECH") || value1.equals("ELECTRICAL") || value1.equals("ELECTRONICS") || value1.equals("CIVIL"))
			{
			
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql3="select * from company_visited where c_branch='"+b.getSelectedItem().toString()+"'";
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
				frame3.setVisible(true);
			}
			if(i3 <1)
			{
				//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
				//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
			if(i3 ==1)
			{	
				System.out.println(i3+" Record Found");
			}
			else
			{
				System.out.println(i3+" Records Found");
			}
			}else
			{
				//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(null, "Please enter proper branch","Error",
						JOptionPane.ERROR_MESSAGE);
				//frame3.dispose();
				//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			}
		}catch(Exception exxx)
		{
			//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(null, exxx.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
			//frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//frame3.dispose();
		}
		frame3.add(scroll3);
		//frame3.setVisible(true);
		frame3.setSize(800,400);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	
	///////////////////Company table data///////////////////////
	protected static void showCompanyTableData() 
	{
		
		
		frame2=new JFrame("Database Search Result");
		frame2.setLayout(new BorderLayout());
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DefaultTableModel model2=new DefaultTableModel();
		model2.setColumnIdentifiers(columnNames2);
		table2=new JTable();
		table2.setModel(model2);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table2.setFillsViewportHeight(true);
		
		
		table2.setDefaultEditor(Object.class,null);
		//int i=table2.getSelectedRow();
		table2.addMouseListener(new MouseListener()
		{

			
			public void mouseClicked(MouseEvent e)
			{
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
					JFrame f=new  JFrame("");
				
				JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,all1;
		    	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
		    
		    	
		    	JButton btn2;
		    	
		    	btn2=new JButton("Back");
				btn2.setBounds(50,700,100,40);
				Font labelFontt1=btn2.getFont();
				String labelTextt1=btn2.getText();
				btn2.setFont(new Font(labelFontt1.getName(),Font.PLAIN,10));
				btn2.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e)
						{
							
							
							f.dispose();
						}
				});
				
		    	frame= new JFrame("COMPANY");
		    	frame.setResizable(false);
		    	
		    	 ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
				all1=new JLabel("",img,JLabel.CENTER);
				all1.setBounds(0,0,800,800);
				
		    
		    	//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
				f.add(all1);
				
				f.setSize(800,800);
				f.setLayout(null);
				f.setVisible(true);
			
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				//f.dispose();
				
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
			String value=b.getSelectedItem().toString();
			if(value.equals("CS/IT") || value.equals("MECH") || value.equals("ELECTRICAL") || value.equals("ELECTRONICS") || value.equals("CIVIL"))
			{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql2="select * from company_table where c_branch='"+b.getSelectedItem().toString()+"'";
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
				frame2.setVisible(true);
				
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
			}else
			{
				JOptionPane.showMessageDialog(null, "Please select proper branch","Error",
						JOptionPane.ERROR_MESSAGE);
		
			}
		}catch(Exception exx)
		{
			JOptionPane.showMessageDialog(null, exx.getMessage(),"Error",
			JOptionPane.ERROR_MESSAGE);
		
		
			
		
		}
		frame2.add(scroll2);
		
		//frame2.setVisible(true);
		frame2.setResizable(false);
		frame2.setSize(800,400);
		//frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		
	}

	//f.dispose();
	
	/*public demomenuform()
	{
	}*/
	
	public static void main(String args[])
	{
		companyDetails dm=new companyDetails();
		dm.createUI();
		
		
	}

}
