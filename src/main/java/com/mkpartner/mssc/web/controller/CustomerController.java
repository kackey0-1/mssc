package com.mkpartner.mssc.web.controller;

import com.mkpartner.mssc.web.model.CustomerDto;
import com.mkpartner.mssc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity getCustomerById(@PathVariable UUID customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity postCustomer(@RequestBody CustomerDto customerDto){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer" + UUID.randomUUID().toString());
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity putCustomerById(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable UUID customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
