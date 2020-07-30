package com.mkpartner.mssc.services.impl;

import com.mkpartner.mssc.services.CustomerService;
import com.mkpartner.mssc.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                                    .name("Kentaro kakimoto")
                                    .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                                    .name("post test")
                                    .build();
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
        //TODO will be coded for real implementation
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting customer....");
    }
}
