package org.mls.survey.submission.exception;

/**
 * This class defines Custom Exception for application
 * 
 * @author Devender Kumar
 * @version 1.0
 * @since 1.0
 */
public class IllegalArgumentApplicationException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public IllegalArgumentApplicationException(String message) {
		super(message);
	}
}
