package com.google.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send
{
	public static void sendMail(String name,String email,String message)
    {    
		String msg="Thanks for Giving Your Comments";
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(message);
       // Recipient's email ID needs to be mentioned.
       //String to = "@gmail.com";

       // Sender's email ID needs to be mentioned
       String from = "@gmail.com";

       
       // Get system properties
       Properties props = new Properties();
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");
       

       // Get the default Session object.
          
       //Session session = Session.getDefaultInstance(props);

         Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("@gmail.com","xxxxxxxxxxxxx");
                }
              });
          
       try{
          // Create a default MimeMessage object.
          MimeMessage message1 = new MimeMessage(session);
           MimeMessage message2=new MimeMessage(session);
           
          // Set From: header field of the header.
          message1.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message1.addRecipient(Message.RecipientType.TO, new InternetAddress(from));
          message2.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
          //System.out.println("mail is sending to who are gining comments"+email);
          
          // Set Subject: header field
          message1.setSubject("Comments");

          // Now set the actual message
          message1.setText("Name:"+name+"\n"+"Comment:"+message+"\n Email:"+email);
          
          Transport.send(message1);
          System.out.println("Sent message successfully....");
          
          //replying for comments
          message2.setSubject("Reply From Glory of Guntur");
          
          message2.setText("\n\n"+"Hi,  "+name+"\n Thanks for Giving Your Comments ");
          //System.out.println("\n\n"+"Hai, "+name+" Thanks for Giving Your Comments "+" email is "+email+" meassage "+message);
          Transport.send(message2);
       }catch (MessagingException mex) {
          mex.printStackTrace();
       }
    }

}
