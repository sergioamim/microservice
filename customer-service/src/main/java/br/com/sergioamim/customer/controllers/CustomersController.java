package br.com.sergioamim.customer.controllers;

import br.com.sergioamim.customer.CustomerDto;
import br.com.sergioamim.customer.controllers.ui.CreateCustomerRequestModel;
import br.com.sergioamim.customer.domain.Customer;
import br.com.sergioamim.customer.services.CustomersService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private Environment env;

	@Autowired
	private CustomersService service;

	@GetMapping("/status/check")
	public String status() {
		log.info("Rodando");
		return "Working on port" + env.getProperty("local.server.port");
	}

	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<CustomerDto> createUser(@RequestBody CustomerDto customerDto) {
		CustomerDto createdUser = service.createCustomer(customerDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerDto> getUser(@PathVariable("id") String id) {

		CustomerDto userDto = service.getCustomerByUserId(id);

		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}
}
