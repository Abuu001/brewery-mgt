package com.lugonzo.msscbreweries.service.v2;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServicev2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 orderBeer(BeerDto newBeer);

    void updateBeer(UUID beerId, BeerDtoV2 updateBeer);

    void deleteBeer(UUID beerId);
}
