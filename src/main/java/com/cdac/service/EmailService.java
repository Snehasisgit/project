package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	 @Autowired
	 private JavaMailSender emailSender;

	 public void sendEmailForNewRegistration(String email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("fastransbidding@gmail.com");
        message.setTo(email); 
        message.setSubject("Thank you for Registering with us!"); 
        message.setText("Thank you for Registering with us!");
        emailSender.send(message);
	 }
	 
	 public void sendEmailForLogin(String email) {
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("fastransbidding@gmail.com");
	        message.setTo(email); 
	        message.setSubject("Account Login- Fastrans"); 
	        message.setText("Your account has been logged in , if not done by you then contact admin..!");
	        emailSender.send(message);
		 }
	 
	 
	 public void sendOTP(String email,int otp) {
		 SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("fastransbidding@gmail.com");
	        message.setTo(email); 
	        message.setSubject("Verify OTP"); 
	        message.setText("The OTP for verify your account is : "+otp+" ");
	        emailSender.send(message);
	 }
	 
	 public int generateOTP() {
		 return ((int)((Math.random() * ( 999999-100000)) + 100000));
	 }
	 
	 public void sendAcceptOffer(String email, int id, double price) {
		 SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("fastransbidding@gmail.com");
	        message.setTo(email); 
	        message.setSubject("Verify OTP"); 
	        message.setText("Your Bid havind Bid_id="+id+" & Offer Price="+price+" has been accepted by the customer , "
	        		+ "Kindly log in to see further details");
	        emailSender.send(message);
	 }
	 
}
