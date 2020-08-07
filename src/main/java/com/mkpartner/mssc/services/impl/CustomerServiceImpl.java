package com.mkpartner.mssc.services.impl;

import com.mkpartner.mssc.web.model.CustomerDto;
import com.mkpartner.mssc.web.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).version(1).CustomerName("New Customer").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("deleting customer ..............................");
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("updating customer ..............................");
    }
}
