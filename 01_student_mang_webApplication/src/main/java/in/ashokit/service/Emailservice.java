package in.ashokit.service;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailservice {
	@Autowired
	private JavaMailSender mailsender; 
	public Emailservice(JavaMailSender mailsender)
	{
		this.mailsender=mailsender;
	}
	
	public void sendemail(String subject,String body,String to)
	{
		try
		{
			 SimpleMailMessage msg = new SimpleMailMessage();
				msg.setSubject(subject);
			  msg.setText(body);
			  msg.setTo(to);
			  mailsender.send(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	  
	}

}
