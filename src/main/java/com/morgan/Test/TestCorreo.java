package com.morgan.Test;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class TestCorreo {
	
	static String emailFrom = "morganbank115@gmail.com";
	static String passwordFrom="wldeuirkacurzxuc";
	private String emailTo;
	private String subject;
	private String content;
	Session mSession;
	MimeMessage mCorreo;
	
	public Properties mProperties;
	public static void main(String[] args) {
		String emailFrom = "morganbank115@gmail.com";
		String passwordFrom="wldeuirkacurzxuc";
		String emailTo;
		String subject;
		String content;
		
		Properties mProperties;
		
		mProperties= new Properties();
		
		
		
		
	}
	
	private void createEmail() {
		emailTo = "damianmor3005@gmail.com";
		subject = "Test";
		content = "Funciono";
		
		MimeMessage mCorreo;
		
		// Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        Session.getDefaultInstance(mProperties);


        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");


        } catch (AddressException ex) {
            Logger.getLogger(TestCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(TestCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(TestCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(TestCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
