package com.mkpartner.mssc.services;

import com.mkpartner.mssc.web.model.BeerDto;
import com.mkpartner.mssc.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);

    void updateCustomer(UUID customerId, CustomerDto customerDto);
}
