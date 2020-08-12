package com.mkpartner.mssc.web.mappers;

import com.mkpartner.mssc.services.domain.Customer;
import com.mkpartner.mssc.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerToCustomerDto(Customer customer);

    CustomerDto customerDtoToCustomer(CustomerDto customerDto);
}
