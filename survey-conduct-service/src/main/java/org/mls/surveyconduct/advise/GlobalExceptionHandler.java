package org.mls.surveyconduct.advise;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.mls.surveyconduct.bean.JsonResponseBean;
import org.mls.surveyconduct.bean.ValidationErrorResponseBean;
import org.mls.surveyconduct.bean.ViolationBean;
import org.mls.surveyconduct.exception.ApplicationException;
import org.mls.surveyconduct.exception.IllegalArgumentApplicationException;
import org.mls.surveyconduct.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = { IllegalArgumentApplicationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentApplicationException ex,
			WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.BAD_REQUEST.value(), "Validation failed",
				this.prepareValidationErrors(ex));
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<Object> handleResourceNotFoundException(ApplicationException ex, WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.BAD_REQUEST.value(), "Validation failed",
				this.prepareValidationErrors(ex));
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ApplicationException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseEntity<Object> handleApplicationException(ApplicationException ex, WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage());
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage());
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		log.error("", ex);
		JsonResponseBean body = new JsonResponseBean("Failed", HttpStatus.NOT_FOUND.value(),
				String.format("Requested endpoint does not exist: %s", ex.getRequestURL()));
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

	}

	private ValidationErrorResponseBean prepareValidationErrors(ConstraintViolationException ex) {
		ValidationErrorResponseBean error = new ValidationErrorResponseBean();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			error.getViolations()
					.add(new ViolationBean(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}

	private ValidationErrorResponseBean prepareValidationErrors(MethodArgumentNotValidException ex) {
		ValidationErrorResponseBean error = new ValidationErrorResponseBean();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new ViolationBean(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}
}
