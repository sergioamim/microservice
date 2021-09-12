package br.com.sergioamim.customer;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 8284110009963658253L;

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;

}