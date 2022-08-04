package br.com.carv.manager.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.dto.EmailDto;
import br.com.carv.manager.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private final static Logger log = LoggerFactory.logger(EmailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Async
	public void send(EmailDto email) {
		try {
			
			MimeMessage mimeMessage = mailSender.createMimeMessage(); 
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email.getText(), true);
			helper.setTo(email.getEmailTo());
			helper.setSubject(email.getSubject());
			helper.setFrom("testdevelopment70@gmail.com");
			mailSender.send(mimeMessage);
			
		}catch (MessagingException e) {
			log.error("Failed to send email" ,e);
			throw new IllegalStateException("Failed to send email");
		}
	}

}
