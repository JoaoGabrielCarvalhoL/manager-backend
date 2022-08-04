package br.com.carv.manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carv.manager.entity.dto.EmailDto;
import br.com.carv.manager.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	private EmailService emailService;
	
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void sendEmail(@RequestBody EmailDto email) {
		emailService.send(email);
	}

}
