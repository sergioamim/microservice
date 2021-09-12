package br.com.sergioamim.customer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = -5482320589125958471L;

	@GeneratedValue
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;


}
	