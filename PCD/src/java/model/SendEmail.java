/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Youssef
 */

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@ManagedBean(name = "EBean", eager = true)
@RequestScoped

public class SendEmail {
    
    private String nomagent;
     private String prenomagent;
     private String emailagent;
     private String passwordagent;
     
    public String send(){
        final String username = "pcd.e.health@gmail.com";
		final String password = "health3621199";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
                
                AgentMedicalDAO agentDAO = new AgentMedicalDAO();
		String response = agentDAO.verifypswd(emailagent);
                
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pcd.e.health@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailagent));
			message.setSubject("Votre mot de passe oubliée sur le forum e-health");
			message.setText("Bonjour "+nomagent+" "+prenomagent+" Votre mot de passe oubliée est "+response);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
        return "login";
        }

    public SendEmail() {
    }

    public String getNomagent() {
        return nomagent;
    }

    public void setNomagent(String nomagent) {
        this.nomagent = nomagent;
    }

    public String getPrenomagent() {
        return prenomagent;
    }

    public void setPrenomagent(String prenomagent) {
        this.prenomagent = prenomagent;
    }

    public String getEmailagent() {
        return emailagent;
    }

    public void setEmailagent(String emailagent) {
        this.emailagent = emailagent;
    }

    public String getPasswordagent() {
        return passwordagent;
    }

    public void setPasswordagent(String passwordagent) {
        this.passwordagent = passwordagent;
    }
    
    
    
}
