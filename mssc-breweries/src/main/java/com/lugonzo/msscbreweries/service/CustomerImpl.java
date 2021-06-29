package com.lugonzo.msscbreweries.service;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerImpl implements CustomerService{


    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Timm")
                .age(22)
                .isAdult(true)
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto newCustomer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto updateCustomer) {
        //TODO impl update customer
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting customer");
    }

}
