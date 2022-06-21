package br.com.carv.manager.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(NotFoundException exception, HttpServletRequest request) {
		String error = "Resource not found"; 
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = exception.getMessage();
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
		
}
