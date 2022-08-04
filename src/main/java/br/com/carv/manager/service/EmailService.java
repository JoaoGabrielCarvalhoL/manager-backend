package br.com.carv.manager.service;

import br.com.carv.manager.entity.dto.EmailDto;

public interface EmailService {

	void send(EmailDto email);
}
