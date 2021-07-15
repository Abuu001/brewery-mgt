package com.lugonzo.msscbreweries.controller;

import com.lugonzo.msscbreweries.model.CustomerDto;
import com.lugonzo.msscbreweries.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

        return  new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity addCustomer(@Valid @RequestBody CustomerDto newCustomer){
        CustomerDto saveDto = customerService.saveNewCustomer(newCustomer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/new" + saveDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId,
                               @Valid @RequestBody CustomerDto updateCustomer){

        customerService.updateCustomer(customerId,updateCustomer);
    }

    @DeleteMapping("/delete/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }


}
