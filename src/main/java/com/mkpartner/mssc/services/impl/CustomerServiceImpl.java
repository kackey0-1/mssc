package com.mkpartner.mssc.services.impl;

import com.mkpartner.mssc.services.CustomerService;
import com.mkpartner.mssc.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                                    .name("Kentaro kakimoto")
                                    .build();
    }
}
