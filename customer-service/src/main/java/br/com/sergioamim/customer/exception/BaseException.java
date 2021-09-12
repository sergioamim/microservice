package br.com.sergioamim.customer.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * Base class for SOA Exceptions.
 *
 * @author Andrey.Yakubenko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL) // To avoid a compiletime warning
public abstract class BaseException extends RuntimeException {

	/**
	 * Base constructor
	 * @param message Exception title
	 * @param cause Cause of the exception
	 */
	public BaseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Base constructor
	 * @param message Exception title
	 */
	public BaseException(final String message) {
		super(message);
	}

	/**
	 *
	 * @return Default HTTP status for specific exception class.
	 */
	public abstract HttpStatus getHttpStatus();

	/**
	 *
	 * @return A human-readable explanation specific to this occurrence of the problem.
	 */
	public abstract String getDetail();

}
