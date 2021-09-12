package br.com.sergioamim.customer.repositories;

import br.com.sergioamim.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, String> {
}
