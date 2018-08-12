<<<<<<< HEAD
package com.auction.utility.email;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private String from;
	private String host;
	private String starttlsEnable;
	private String hostName;
	private String port;
	private String smtpAuth;
	private String password;

	public void sendEmail(String to, String messageSent) {
		getForgetPasswordDetails();
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.starttls.enable", starttlsEnable);
		props.put("mail.smtp.host", hostName);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", smtpAuth);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Password change");
			message.setText(messageSent);

			Transport.send(message);
			// System.out.println("Message Sent");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void getForgetPasswordDetails() {
		Properties properties = new Properties();
		try {
			File f = new File("C:\\Users\\Kartik\\Desktop\\login.properties");
			properties.load(new FileReader(f));
			from = properties.getProperty("from");
			System.out.print(from);
			host = properties.getProperty("host");
			starttlsEnable = properties.getProperty("starttlsEnable");
			hostName = properties.getProperty("hostName");
			port = properties.getProperty("port");
			smtpAuth = properties.getProperty("smtpAuth");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
=======
package com.auction.utility.email;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private String from;
	private String host;
	private String starttlsEnable;
	private String hostName;
	private String port;
	private String smtpAuth;
	private String password;

	public void sendEmail(String to, String messageSent) {
		getForgetPasswordDetails();
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.starttls.enable", starttlsEnable);
		props.put("mail.smtp.host", hostName);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", smtpAuth);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Password change");
			message.setText(messageSent);

			Transport.send(message);
			// System.out.println("Message Sent");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void getForgetPasswordDetails() {
		Properties properties = new Properties();
		try {
			File f = new File("C:\\Users\\Kartik\\Desktop\\login.properties");
			properties.load(new FileReader(f));
			from = properties.getProperty("from");
			System.out.print(from);
			host = properties.getProperty("host");
			starttlsEnable = properties.getProperty("starttlsEnable");
			hostName = properties.getProperty("hostName");
			port = properties.getProperty("port");
			smtpAuth = properties.getProperty("smtpAuth");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
