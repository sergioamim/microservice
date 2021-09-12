package br.com.sergioamim.customer.controllers.ui;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerResponseModel {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
}
