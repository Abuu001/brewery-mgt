package com.lugonzo.msscbeerservice.service;

import com.lugonzo.msscbeerservice.model.BeerDto;


import java.util.Optional;
import java.util.UUID;


public interface BeerService {

    Optional<BeerDto> getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto newBeer);

    BeerDto updateBeer(UUID beerId, BeerDto updateBeer);
}
