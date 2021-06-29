package com.lugonzo.msscbreweries.service;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto newCustomer);

    void updateCustomer(UUID customerId, CustomerDto updateCustomer);

    void deleteCustomerById(UUID customerId);
}
