package org.mls.surveyconduct.exception;

/**
 * This class defines Custom Exception for application
 * 
 * @author Devender Kumar
 * @version 1.0
 * @since 1.0
 */
public class ResourceNotFoundException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
