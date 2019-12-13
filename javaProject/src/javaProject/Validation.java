package javaProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
	public static boolean email_Validation(String email)
	{
		boolean status =false;
		
		//String email_Pattern ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		//String email_Pattern= "^(.+)@(.+)$";
		//String email_Pattern= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		//String email_Pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		String email_Pattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern=Pattern.compile(email_Pattern);
		Matcher matcher=pattern.matcher(email);
		
		if(matcher.matches())
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}
	
}
