package br.com.resource;

import br.com.entity.Customers;
import br.com.repository.CustomersRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/name")
public class CustomersResource {

    @Inject
    private CustomersRepository customersRepository;

    @Get(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public void getName(){
        customersRepository.findAll();
    }

    @Get("/{id}")
    public Customers findByName(Long id){
        return customersRepository.findById(id).get();
    }

    @Post(value = " /{name}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public void saveCustormes(@Body Customers customers){
         customersRepository.save(customers);
    }
}
