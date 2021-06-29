package com.lugonzo.msscbreweries.service;

import com.lugonzo.msscbreweries.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{


    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy cat")
                .beerStyle("Pale ale")
                .build();
    }

    @Override
    public BeerDto orderBeer(BeerDto newBeer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto updateBeer) {
        //TODO impl of update beer
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
