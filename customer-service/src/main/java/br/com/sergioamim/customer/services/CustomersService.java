package br.com.sergioamim.customer.services;

import br.com.sergioamim.customer.CustomerDto;
import br.com.sergioamim.customer.domain.Customer;
import br.com.sergioamim.customer.exception.DataNotFoundException;
import br.com.sergioamim.customer.repositories.CustomersRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@NoArgsConstructor
public class CustomersService {

	private CustomersRepository repository;

	@Autowired
	public CustomersService(CustomersRepository repository) {
		this.repository = repository;
	}

	public CustomerDto createCustomer(CustomerDto dto) {
		dto.setId(UUID.randomUUID().toString());

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Customer customer = modelMapper.map(dto, Customer.class);

		repository.save(customer);

		CustomerDto returnValue = modelMapper.map(customer, CustomerDto.class);

		return returnValue;
	}

	public CustomerDto getCustomerByUserId(String id) {

		Customer data = repository.findById(id).orElseThrow(() -> new DataNotFoundException("Customer not found"));

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(data, CustomerDto.class);
	}
}
