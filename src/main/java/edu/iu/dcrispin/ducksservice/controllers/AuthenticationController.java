package edu.iu.dcrispin.ducksservice.controllers;

import edu.iu.dcrispin.ducksservice.model.Customer;
import edu.iu.dcrispin.ducksservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    CustomerRepository customerRepository;

    public AuthenticationController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer){
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
