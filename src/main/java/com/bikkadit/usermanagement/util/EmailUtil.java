package com.bikkadit.usermanagement.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(String to, String subject, String body) throws Exception {
		boolean isSent = false;
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		messageHelper.setText(body, true);
		javaMailSender.send(mimeMessage);
		isSent=true;
		return isSent;
	}

}
