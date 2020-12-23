package com.anasayfa.baran;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class JavaMailGonderme {
	 public static void sendMail(String recepient) throws Exception {
			Properties properties=new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
		
	      String myAccountEmail="baranbeger7231@gmail.com";
			String password="DhasdaASDASAsdASdASdASdASd";
			
	  
			 Session session = Session.getInstance(properties, new Authenticator() {
				  @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail, password);		
				}
			 
			 });
			 Message message= prepareMessage(session, myAccountEmail, recepient);
			 Transport.send(message);      
			  Alert mesaj=new Alert(AlertType.INFORMATION);
			  mesaj.setTitle("Islem Basarili");
			  mesaj.show();

			
		}
	 
		private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
			try {
				Message message= new MimeMessage(session);
				message.setFrom(new InternetAddress("myAccountEmail"));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				for(HastalarData i:AnaSayfaController.MailGonderilecekListesi) {
					
				message.setSubject("Hasta bilgileri "+i.getAD()+","+i.getSEHIR()+","+i.getMESLEK()+","+i.getCINS()+","+i.getATES()+","+i.getTESHIS()+","+i.getTARIH());
				message.setText("mesaj");
				return message;}
				
			} catch (Exception e) {
				Logger.getLogger(JavaMailGonderme.class.getName()).log(Level.SEVERE,null,e);
				}
			return null;
			
			
		}}
					
