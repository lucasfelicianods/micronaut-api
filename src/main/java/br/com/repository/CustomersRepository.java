package br.com.repository;

import br.com.entity.Customers;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Long> {




}
