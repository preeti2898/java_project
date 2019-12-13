package javaProject;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class table extends JFrame 
{

 private static JFrame frame;
  private static  JTextField name;
 private static  JTextField email;
 private static JTextField comp;
//private JTextField app;
// private JTextField placed;
 private JComboBox app1;
 private JComboBox placed1;
  private JButton btnInsert;
 private JButton btnExit;
 
 
 
 public static void main(String[] args) 
 {
	
	EventQueue.invokeLater(new Runnable()
	 {
		 public void run() 
		 {
			 try 
			 {
				 table window = new table();
				 window.frame.setVisible(true);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 });
 }
 	public table()
 	{
 		initialize();
 	}

 /**
  * Initialize the contents of the frame.
  */private static JTable table = new JTable();
  	public void initialize()
  
  	{
	  
  JTable table = new JTable();
  frame = new JFrame();
  //frame.setBounds(50, 100, 700, 380);
  frame.setBounds(50, 100, 700, 420);
  frame.setVisible(true);
  
  JLabel all = new JLabel("");
  ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
	all=new JLabel("",img,JLabel.CENTER);
	all.setBounds(0,0,800,800);
	
	
 // table window = new table();
  //frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setLayout(null);
  
  Object [] colomns={"S_name","S_email","Company_name","Appeared or Not","S_placed"};
  DefaultTableModel model= new DefaultTableModel();
  model.setColumnIdentifiers(colomns);
  table.setModel(model);
  
 
  
  name = new JTextField();
  name.setBounds(10, 11, 180, 20);
  frame.getContentPane().add(name);
  name.setColumns(10);
  
  
  email = new JTextField();
  email.setBounds(10, 42, 180, 20);
  frame.getContentPane().add(email);
  email.setColumns(10);
  
  comp = new JTextField(company_login.cname.getText());
  comp.setBounds(10, 73, 180, 20);
  frame.getContentPane().add(comp);
  comp.setColumns(10);
  
/*  app = new JTextField();
  app.setBounds(10, 104, 180, 20);
  frame.getContentPane().add(app);
  app.setColumns(10);
  
  placed= new JTextField();
  placed.setBounds(10, 135, 180, 20);
  frame.getContentPane().add(placed);
  placed.setColumns(10);*/
  
    app1=new JComboBox();
	app1.setBounds(10, 104, 180, 20);
	DefaultComboBoxModel empModel1=new DefaultComboBoxModel();
	empModel1.addElement("YES");
	empModel1.addElement("NO");
	app1.setModel(empModel1);
	app1.setSelectedIndex(0);
	app1.setEditable(false);
	 frame.getContentPane().add(app1);
	// app1.setColumns(10);
	 
	 	placed1=new JComboBox();
		placed1.setBounds(10, 135, 180, 20);
		DefaultComboBoxModel empModel2=new DefaultComboBoxModel();
		empModel2.addElement("YES");
		empModel2.addElement("NO");
		placed1.setModel(empModel2);
		placed1.setSelectedIndex(0);
		placed1.setEditable(false);
		 frame.getContentPane().add(placed1);
		
  
  JLabel lbl1 = new JLabel("Enter Student Details Here");
  lbl1.setForeground(Color.GRAY);
  lbl1.setBounds(400, 11, 250, 40);
  frame.getContentPane().add(lbl1);
  Font labelFont=lbl1.getFont();
  String labelText=lbl1.getText();
  lbl1.setFont(new Font(labelFont.getName(),Font.PLAIN,20));
  lbl1.setForeground(Color.WHITE);
  
  JLabel lbl2 = new JLabel("(For Company Use Only)");
  lbl2.setForeground(Color.GRAY);
  lbl2.setBounds(450, 41, 250, 20);
  frame.getContentPane().add(lbl2);
  Font labelFont1=lbl2.getFont();
  String labelText1=lbl2.getText();
  lbl2.setFont(new Font(labelFont1.getName(),Font.PLAIN,10));
  lbl2.setForeground(Color.WHITE);
  
  JLabel lblName = new JLabel("Student Name");
  lblName.setBounds(200, 11, 95, 20);
  frame.getContentPane().add(lblName);
  lblName.setForeground(Color.WHITE);
  
  JLabel lblEmail = new JLabel("Student Email");
  lblEmail.setBounds(200, 42, 95, 20);
  frame.getContentPane().add(lblEmail);
  lblEmail.setForeground(Color.WHITE);
  
  JLabel lblComp = new JLabel("Company Name");
  lblComp.setBounds(200, 73, 95, 20);
  frame.getContentPane().add(lblComp);
  lblComp.setForeground(Color.WHITE);
  
  JLabel lblApp = new JLabel("Appeared or Not");
  lblApp.setBounds(200, 104, 95, 20);
  frame.getContentPane().add(lblApp);
  lblApp.setForeground(Color.WHITE);
 
  JLabel lblPlaced = new JLabel("Placed or Not");
  lblPlaced.setBounds(200, 135, 95, 20);
  frame.getContentPane().add(lblPlaced);
  lblPlaced.setForeground(Color.WHITE);
 
  JScrollPane scrollPane = new JScrollPane(table);
 // scrollPane.setBounds(10, 200, 764, 150);
  scrollPane.setBounds(10, 200, 668, 175);
  frame.getContentPane().add(scrollPane);
  table.setDefaultEditor(Object.class,null);
  
  
   
  JButton btnInsert = new JButton("Insert");
  Object [] row = new Object[5];
  btnInsert.addActionListener(new ActionListener() 
  {
	  public void actionPerformed(ActionEvent arg0)
	  {
		 /* row[0]=name.getText();
		  row[1]=email.getText();
		  row[2]=comp.getText();
		  row[3]=app.getText();
		  row[4]=placed.getText();*/
		  
		
		 // model.addRow(row);
		  try
		  {
			 
			/*  boolean status=Validation.email_Validation(email.getText());
				if(status)
				{*/
				
			  String name1=name.getText();
			  String email1=email.getText();
			  String comp1=comp.getText();
			  String app11=app1.getSelectedItem().toString(); 				//String value=year2.getSelectedItem().toString();
			  String placed11=placed1.getSelectedItem().toString();
			  
			/* if(name1.length()==0)
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
			  }else if(email1.length()==0)
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
			  }else if(comp1.length()==0)
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
			  }else if(app1.length()==0)
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
			  }else if(placed1.length()==0)
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
			  }*/
			  if(name1.length()!=0 && email1.length()!=0 && comp1.length()!=0 && app11.length()!=0 && placed11.length()!=0)
			  {
				  boolean status=Validation.email_Validation(email.getText());
					if(status)
					{
				
				  row[0]=name.getText();
				  row[1]=email.getText();
				  row[2]=comp.getText();
				  row[3]=app1.getSelectedItem().toString();
				  row[4]=placed1.getSelectedItem().toString();
				  
				  model.addRow(row);
				 
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
				String sqll="insert into placed_students"+"(s_name,s_email,s_company,s_appear,s_placed)"+"values(?,?,?,?,?)";
				PreparedStatement pstt=con.prepareStatement(sqll);
				
					 
				pstt.setString(1,name.getText());
				pstt.setString(2,email.getText());
				pstt.setString(3,comp.getText());
				pstt.setString(4,app1.getSelectedItem().toString());
				pstt.setString(5,placed1.getSelectedItem().toString());
				pstt.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Student Entered", "MESSAGE",JOptionPane.INFORMATION_MESSAGE);
				name.setText("");
				email.setText("");
				//comp.setText("");
				
				
				
				
					 }else
						{
						JOptionPane.showMessageDialog(null,"Invalid Email", "Error",JOptionPane.ERROR_MESSAGE);
						}
					
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null,"Can't take null values", "ERROR",JOptionPane.ERROR_MESSAGE);
				 			
			  }
		/*  }else
			{
			JOptionPane.showMessageDialog(null,"Invalid Email", "Error",JOptionPane.ERROR_MESSAGE);
			}*/
			
		  }catch(Exception e)
		  {
			  JOptionPane.showMessageDialog(null,"Re-Enter Details", "ERROR",JOptionPane.ERROR_MESSAGE);
		  }
		  
	  }
  });
  	btnInsert.setBounds(350, 135, 89, 23);
  	frame.getContentPane().add(btnInsert);
  	
  	JButton btnExit = new JButton("Exit");
  	btnExit.setBounds(450, 135, 89, 23);
  	frame.getContentPane().add(btnExit); 
  	 btnExit.addActionListener(new ActionListener() 
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