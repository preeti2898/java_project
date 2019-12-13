package javaProject;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class studentStatus extends JFrame
{
	 private static JFrame frame;
	 private static JButton btn1,btn2;
	 private static JComboBox cat;
	 private static JLabel l1,l2,l3;
	 static String driverName = "com.mysql.jdbc.Driver";	
	 static String url = "jdbc:mysql://localhost:3306/javaproject";
	 static String userName = "root";
	 static String password = "";
		

	 public static void main(String[] args) 
	 {
		
		EventQueue.invokeLater(new Runnable()
		 {
			 public void run() 
			 {
				 try 
				 {
					 studentStatus window = new studentStatus();
					 window.frame.setVisible(true);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });
	 }

	public studentStatus()
	{
		initialize1();
	}
	
	private static JTable table = new JTable();
  	public void initialize1()
  	{
  	  JTable table = new JTable();
  	  frame = new JFrame();
  	 
  	//frame.setBounds(10, 200, 668, 175);
  	 frame.setBounds(50, 100, 700, 420);
  	 
  	  frame.setVisible(true);
  	  
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    JLabel all = new JLabel("");
    ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
  	all=new JLabel("",img,JLabel.CENTER);
  	all.setBounds(0,0,800,800);

    
    Object [] colomns={"Student name","Student email","Company_name","Appeared(YES/NO)","Placed(YES/NO)"};
    DefaultTableModel model= new DefaultTableModel();
    model.setColumnIdentifiers(colomns);
    table.setModel(model);
    JScrollPane scrollPane = new JScrollPane(table);
	//scrollPane.setBounds(10, 200, 764, 150);
	 scrollPane.setBounds(10, 200, 668, 175);
	frame.getContentPane().add(scrollPane);
	scrollPane.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setVerticalScrollBarPolicy(
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	table.setDefaultEditor(Object.class,null);
	//table.setFillsViewportHeight(true);
	
    
    cat=new JComboBox();
	cat.setBounds(10, 135, 180, 20);
	DefaultComboBoxModel empMode=new DefaultComboBoxModel();
	empMode.addElement("ALL");
	empMode.addElement("Appeared for drive");
	empMode.addElement("Didnt appear for drive");
	empMode.addElement("Got placed");
	empMode.addElement("Not placed");
	cat.setModel(empMode);
	cat.setSelectedIndex(0);
	cat.setEditable(false);
	frame.getContentPane().add(cat);
	
	JLabel l3 = new JLabel("Student Status Panel");
	  l3.setForeground(Color.WHITE);
	  l3.setBounds(200, 20, 500, 60);
	  frame.getContentPane().add(l3);
	  Font labelFont=l3.getFont();
	  String labelText=l3.getText();
	  l3.setFont(new Font(labelFont.getName(),Font.PLAIN,40));
		
	
	JLabel l2 = new JLabel("Select Student Category:");
	l2.setBounds(10, 100, 300, 20);
	l2.setForeground(Color.WHITE);
	frame.getContentPane().add(l2);
	  
	
	/*JLabel l1 = new JLabel("Select Category");
	l1.setBounds(200, 135, 95, 20);
	frame.getContentPane().add(l1);*/
	 
	  
	JButton btn1 = new JButton("Show");
	btn1.setBounds(450, 135, 89, 23);
	frame.getContentPane().add(btn1);
	 btn1.addActionListener(new ActionListener() 
	  {
		  public void actionPerformed(ActionEvent arg1)
		  {
			  String s1="";
			  String s2="";
			  String s3="";
			  String s4="";
			  String s5="";
			  try
				{
				  
				  	String val=cat.getSelectedItem().toString();
					Class.forName(driverName);
					Connection con=DriverManager.getConnection(url,userName,password);
					if(val.equals("ALL"))
					{
						model.setRowCount(0);
						String sql="select * from placed_students ";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						int i=0;
						while(rs.next())
						{
							s1=rs.getString("s_name");
							s2=rs.getString("s_email");
							s3=rs.getString("s_company");
							s4=rs.getString("s_appear");
							s5=rs.getString("s_placed");
							model.addRow(new Object[]{s1,s2,s3,s4,s5});
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
						
						
					}
					 if(val.equals("Appeared for drive"))
					{
						 model.setRowCount(0);
						String sql="select * from placed_students where s_appear='YES'";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						int i=0;
						while(rs.next())
						{
							s1=rs.getString("s_name");
							s2=rs.getString("s_email");
							s3=rs.getString("s_company");
							s4=rs.getString("s_appear");
							s5=rs.getString("s_placed");
							model.addRow(new Object[]{s1,s2,s3,s4,s5});
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
						
					}
					 
					 if(val.equals("Didnt appear for drive"))
						{
							 model.setRowCount(0);
							String sql="select * from placed_students where s_appear='NO'";
							PreparedStatement ps=con.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							int i=0;
							while(rs.next())
							{
								s1=rs.getString("s_name");
								s2=rs.getString("s_email");
								s3=rs.getString("s_company");
								s4=rs.getString("s_appear");
								s5=rs.getString("s_placed");
								model.addRow(new Object[]{s1,s2,s3,s4,s5});
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
							
						}
						
					 if(val.equals("Got placed"))
					{
						 model.setRowCount(0);
						String sql="select * from placed_students where s_placed='YES'";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						int i=0;
						while(rs.next())
						{
							s1=rs.getString("s_name");
							s2=rs.getString("s_email");
							s3=rs.getString("s_company");
							s4=rs.getString("s_appear");
							s5=rs.getString("s_placed");
							model.addRow(new Object[]{s1,s2,s3,s4,s5});
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
						
					}
					 if(val.equals("Not placed"))
						{
							 model.setRowCount(0);
							String sql="select * from placed_students where s_placed='NO'";
							PreparedStatement ps=con.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							int i=0;
							while(rs.next())
							{
								s1=rs.getString("s_name");
								s2=rs.getString("s_email");
								s3=rs.getString("s_company");
								s4=rs.getString("s_appear");
								s5=rs.getString("s_placed");
								model.addRow(new Object[]{s1,s2,s3,s4,s5});
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
							
						}
					//String sql="select * from placed_students where s_appear='"+cat.getSelectedItem().toString()+"'";
					/*PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int i=0;
					while(rs.next())
					{
						s1=rs.getString("s_name");
						s2=rs.getString("s_email");
						s3=rs.getString("s_company");
						s4=rs.getString("s_appear");
						s5=rs.getString("s_placed");
						model.addRow(new Object[]{s1,s2,s3,s4,s5});
						i++;
						
					}*/
					/*if(i <1)
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
					}*/
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
				}

			  
		  }
	  });

	  	
	JButton btn2 = new JButton("Exit");
	btn2.setBounds(550, 135, 89, 23);
	frame.getContentPane().add(btn2);
	 btn2.addActionListener(new ActionListener() 
 	  {
 		  public void actionPerformed(ActionEvent arg1)
 		  {
 			  
 			frame.dispose();
 			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			  
 		  }
 	  });
		frame.getContentPane().add(all);
	  	
  	}
  
	

}
