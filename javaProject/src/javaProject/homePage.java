package javaProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class homePage extends JFrame {
	private static JFrame f1;
	private static JButton b1;
	private static JButton b2;
	private static JButton b3;
	private static JButton b4;
	private static JLabel all,l1,l2,l3,l4;
	
	
	public homePage()
	{
		f1= new JFrame("HOME PAGE");
       
		ImageIcon img=new ImageIcon("C:\\Users\\HP\\Desktop\\image1.jpg");
		all=new JLabel("",img,JLabel.CENTER);
		all.setBounds(0,0,800,800);
		//C:\Users\HP\Desktop*/
		
		l2=new JLabel(" COLLEGE  PLACEMENTS");
		l2.setBounds(70,50,670,60);
		Font labelFont4=l2.getFont();
		String labelText4=l2.getText();
		l2.setFont(new Font(labelFont4.getName(),Font.ROMAN_BASELINE,50));
		l2.setForeground(Color.WHITE);
		
		l3=new JLabel("&");
		l3.setBounds(350,120,670,100);
		Font labelFont41=l3.getFont();
		String labelText41=l3.getText();
		l3.setFont(new Font(labelFont41.getName(),Font.ROMAN_BASELINE,60));
		l3.setForeground(Color.WHITE);
		
		l4=new JLabel("   ASSISTANCE  SYSTEM");
		l4.setBounds(70,200,670,60);
		Font labelFont42=l4.getFont();
		String labelText42=l4.getText();
		l4.setFont(new Font(labelFont42.getName(),Font.ROMAN_BASELINE,50));
		l4.setForeground(Color.WHITE);
		
		b1=new JButton("Admin");
		b1.setBounds(250,400,300,50);
		//Border border= BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		//b1.setBorder(border);
		//b1.setBackground(Color.LIGHT_GRAY);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				new adminLogin();
				f1.dispose();
			}
			
		});
		
		b2=new JButton("Student");
		b2.setBounds(250,470,300,50);
		//Border borde= BorderFactory.createLineBorder(Color.LIGHT_GRAY);
	//	b2.setBorder(borde);
		//b2.setBackground(Color.LIGHT_GRAY);
		b2.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent ev)
					{
						new student_page();
						f1.dispose();
					}
			
				}
		);
		
		b3=new JButton("Company");
		b3.setBounds(250,540,300,50);
		//Border bord= BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		//b3.setBorder(bord);
		//b3.setBackground(Color.LIGHT_GRAY);
		b3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent evv)
			{
				new company_page();
				f1.dispose();
				
			}
			
		});
		
		b4=new JButton("About us");
		b4.setBounds(250,610,300,50);
		//Border bor= BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		//b4.setBorder(bor);
		//b4.setBackground(Color.LIGHT_GRAY);
		b4.addActionListener(new ActionListener()
		{

			
			public void actionPerformed(ActionEvent evvv)
			{
				
				new aboutUs();
				f1.dispose();
				
			}
			
		});
		
		
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(b4);
		f1.add(l2);
		f1.add(l3);
		f1.add(l4);
		f1.add(all);
		f1.setSize(800,800);
		//f1.setMinimumSize(new Dimension(800, 0));
		
		//f1.setUndecorated(true);
		f1.setResizable(false);

	    //f1.setMaximumSize(new Dimension(800, Integer.MAX_VALUE));

		f1.setLayout(null);
		f1.setVisible(true);
		//f1.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String args[])
	{
		 new homePage();
		 
	}
}
