package com.mkpartner.mssc.web.client;

import com.mkpartner.mssc.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void testGetBeerById() {
        CustomerDto customerDto = customerClient.getBeerById(UUID.randomUUID());
        assertThat(customerDto).isNotNull();
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().CustomerName("new customer").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void testUpdateCustomerById() {
        CustomerDto customerDto = CustomerDto.builder().CustomerName("new customer").build();
        customerClient.updateCustomerById(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomerById() {
        customerClient.deleteCustomerById(UUID.randomUUID());
    }

}