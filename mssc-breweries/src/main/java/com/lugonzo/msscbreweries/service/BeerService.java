package com.lugonzo.msscbreweries.service;

import com.lugonzo.msscbreweries.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto orderBeer(BeerDto newBeer);

    void updateBeer(UUID beerId, BeerDto updateBeer);

    void deleteBeer(UUID beerId);
}
