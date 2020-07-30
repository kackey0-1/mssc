package com.mkpartner.mssc.services;

import com.mkpartner.mssc.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
