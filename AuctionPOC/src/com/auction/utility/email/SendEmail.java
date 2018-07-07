package com.auction.utility.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public void sendEmail(String to, String _id) {
		String from = "docsaver0@gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "DocumentSaver");
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("abc"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Password change");
			message.setText("Your ID is " + _id
					+ ". Please don't share it with anyone. Visit http://localhost:8082/AuctionPOC/changePassword to change the password");

			Transport.send(message);
			// System.out.println("Message Sent");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
