package org.jbpm.spring.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	private static Properties props =null;
	
	static {
		 props = new Properties();
		 
		 InputStream inputStream = EmailService.class.getClassLoader()
                 .getResourceAsStream("email.properties");
		 try {
			props.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
	public void sendEmail(String to, String subject,String body){
		
		final String from = props.getProperty("user");
		final String pass = props.getProperty("pass");
		 Session session = Session.getDefaultInstance(props,
			        new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication(from,pass);
			            }
			        });

			    try {

			        Message message = new MimeMessage(session);
			        try {
						message.setFrom(new InternetAddress(from,"customerService"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        message.setRecipients(Message.RecipientType.TO,
			                InternetAddress.parse(to));
			        message.setSubject(subject);
			        message.setText(body);

			        Transport.send(message);

			        System.out.println("Done");

			    } catch (MessagingException e) {
			        throw new RuntimeException(e);
			    }
	}
	
	public static void main(String [] ar){
		EmailService eservice =  new EmailService();
		eservice.sendEmail( props.getProperty("user"), "test", "test");
	}

}
