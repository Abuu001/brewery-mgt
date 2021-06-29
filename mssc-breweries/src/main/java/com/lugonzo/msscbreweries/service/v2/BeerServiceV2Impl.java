package com.lugonzo.msscbreweries.service.v2;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServicev2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 orderBeer(BeerDto newBeer) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 updateBeer) {

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }
}
