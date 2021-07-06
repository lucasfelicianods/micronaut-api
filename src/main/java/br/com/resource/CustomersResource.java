package br.com.resource;

import br.com.entity.Customers;
import br.com.repository.CustomersRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller("/name")
public class CustomersResource {

    @Inject
    private CustomersRepository customersRepository;

    @Get(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Iterable<Customers> getName(){
        return  customersRepository.findAll();
    }

    @Get("/{id}")
    public Customers findByName(Long id){
        return customersRepository.findById(id).get();
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Customers> saveCustormes(@Body Customers customers){
        return HttpResponse.created(customersRepository.save(customers));
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id){
        var customer = customersRepository.findById(id);

         if(customer.isEmpty()){
             return HttpResponse.notFound().body("Id não encontrado");
         }
        customersRepository.delete(customer.get());
        return HttpResponse.noContent();
    }
}
