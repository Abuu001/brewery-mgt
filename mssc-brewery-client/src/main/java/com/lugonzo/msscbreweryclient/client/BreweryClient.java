package com.lugonzo.msscbreweryclient.client;

import com.lugonzo.msscbreweryclient.model.BeerDto;
import com.lugonzo.msscbreweryclient.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATHV1 = "/api/v1/beer/";
    public final String CUSTOMER_PATHV1 = "/api/v1/customer";

    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost + BEER_PATHV1 + beerId.toString() , BeerDto.class);
    }

    public URI saveNewBeer(BeerDto newBeer){
        return restTemplate.postForLocation(apihost + BEER_PATHV1 + "order/",newBeer);
    }

    public void updateBeer(UUID beerId,BeerDto updateBeer){
        restTemplate.put(apihost + BEER_PATHV1 +"update/"+beerId.toString(),updateBeer);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost + BEER_PATHV1 +"delete/"+ beerId.toString());
    }

    public void setApiHost(String apiHost) {
        this.apihost = apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
      return  restTemplate.getForObject(apihost + CUSTOMER_PATHV1 +"/"+customerId.toString(),CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATHV1 + "/new" ,customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATHV1 +"/update/"+customerId.toString() , customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATHV1 + "/delete/" + customerId.toString());
    }
}
