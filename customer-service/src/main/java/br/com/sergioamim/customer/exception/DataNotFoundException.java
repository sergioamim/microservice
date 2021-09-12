package br.com.sergioamim.customer.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public class DataNotFoundException extends BaseException {

	private final static HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

	private final static String DETAIL = "Resource with specified ID was not found";

	/**
	 * Creates AuthorizationException with dependent cause exception
	 * @param message Exception title
	 * @param cause
	 */
	public DataNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with only title message
	 * @param message
	 */
	public DataNotFoundException(final String message) {
		super(message);
	}

	/**
	 * Returns HTTP status for the exception
	 * @return
	 */
	@Override
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}

	/**
	 * Provides detailed description for this exception type
	 * @return
	 */
	@Override
	public String getDetail() {
		return DETAIL;
	}
}
