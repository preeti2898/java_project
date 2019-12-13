package javaProject;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 class aboutUs extends JFrame {
     
	private static final Component JTextField = null;
	private static JLabel l;
	private static JLabel all;
	private static JTextField tf;
	private static JButton b,btn3;
	private static JFrame frame;
	private static JTextArea t;
	 
	
	public aboutUs() {
		
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
		JTextField tf1,tf2,tf3,tf4,tf5;
        JTextArea t1,t2,t3,t4,t5,t6;
      
		frame =new JFrame("");
		frame.setResizable(false);
		
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image2.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		
		btn3=new JButton("Back");
		btn3.setBounds(20,680,100,40);
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
		
		
		
		String Text= "<html> <p> This College Placements & Assistance System application is a smart web application which helps students to find easy placements and internships for different companies which are registered in the application. The application main aim is to unite the students and companies on a platform so that the searching of jobs will be easy for students and searching for employees will be easy for companies also. In this application, companies will register and login into the application and post the notice of job by specifying all the details, like how many vacancies and requirements.\r\n" + 
				"\r\n" + 
				"The company will also conduct the internships so that also will be posted by adding internship details like whether it is full-time or part-time, etc. The students must also have registered and login into the application and the student can view the notices of internship and job available for that company so the student can apply by uploading a resume. Here in this application admin will give the placement assistance by providing training. Admin will upload a document for training that can be seen by the student and they can follow and get assistance.  </p> </html>";
		l2= new JLabel(Text);
		l2.setBounds(40,40,730,150);
		
		l1=new JLabel("ABSTRACT :");
		 Font labelFont1=l1.getFont();
 		 String labelText1=l1.getText();
 		 l1.setFont(new Font(labelFont1.getName(),Font.BOLD,20));
		l1.setBounds(30,5,200,50);
		
		l3=new JLabel("THIS APPLICATION HAS THREE MODULES :");
		 Font labelFont3=l3.getFont();
 		 String labelText3=l3.getText();
 		 l3.setFont(new Font(labelFont3.getName(),Font.BOLD,15));
		l3.setBounds(30,180,250,50);
		
		String Tex= "<html> <p>1.Admin <br>2.Student <br> 3.Company     </p></html>";
		l4= new JLabel(Tex);
		l4.setBounds(60,170,150,150);
		
		l5=new JLabel("Student");
		 Font labelFont5=l5.getFont();
 		 String labelText5=l5.getText();
 		 l5.setFont(new Font(labelFont5.getName(),Font.BOLD,15));
		l5.setBounds(30,280,150,50);
		
		String Te= "<html> <p> Student must be registered to get login, after registering the student must login and he can view the basic functionalities of student on the home page the student can view the notices of jobs posted by different companies and also he can view the internships posted by the companies so that student can apply for company by uploading resume . A student can also get placement assistance from the admin the admin will upload a document regarding company placement so that student can follow that get assistance. </p></html>";
		l6= new JLabel(Te);
		l6.setBounds(40,280,730,150);
		
		l7=new JLabel("Company");
		 Font labelFont7=l7.getFont();
		 String labelText7=l7.getText();
		 l7.setFont(new Font(labelFont5.getName(),Font.BOLD,15));
		l7.setBounds(30,380,150,50);
		
		String T= "<html> <p>The company must also be registered and get login, After login, the company will post the number of vacancies in the company for a position and also they will offer internships for students. </p></html>";
		l8= new JLabel(T);
		l8.setBounds(40,360,730,150);
         
		l9=new JLabel("Admin");
		 Font labelFont9=l9.getFont();
		 String labelText9=l9.getText();
		 l9.setFont(new Font(labelFont9.getName(),Font.BOLD,15));
		l9.setBounds(30,440,150,50);
	
		String Texts= "<html> <p> Admin will log in with the default username and password after logging he can view the users registered and companies registered. He will provide the placement assistance to students by uploading a document regarding how to train for placements.</p></html>";
		l10= new JLabel(Texts);
		l10.setBounds(40,420,730,150);
		
		l11=new JLabel("Existing System :");
		 Font labelFont11=l11.getFont();
		 String labelText11=l11.getText();
		 l11.setFont(new Font(labelFont11.getName(),Font.BOLD,20));
		l11.setBounds(30,540,250,50);
		
		
		String Textss= "<html> <p> In the existing system the student need to go companies for joining in internships or for applying for jobs so they need to search the companies and go to company and apply for the job this is very long and time taking process, and also companies need to publish the ads or they contact consultancies to fil their vacancies this process takes time. So these all problems are resolved with this application. </p></html>";
		l12= new JLabel(Textss);
		l12.setBounds(40,540,730,150);
		
		
		
		
		
		frame.add(l1); frame.add(l2); frame.add(l3);frame.add(l4); frame.add(l5); frame.add(l6); frame.add(l7); frame.add(l8);
		frame.add(l9); frame.add(l10); frame.add(l11);frame.add(l12); 
		
		 frame.setSize(800, 800);
		 frame.add(all);
	        frame.setLayout(null);
	        frame.add(btn3);
	       // frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		 
	                new aboutUs();  
	         
	    }  
		
	}
	
	

