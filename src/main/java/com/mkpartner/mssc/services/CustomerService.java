package com.mkpartner.mssc.services;

import com.mkpartner.mssc.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
