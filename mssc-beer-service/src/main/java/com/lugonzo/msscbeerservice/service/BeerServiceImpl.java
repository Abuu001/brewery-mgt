package com.lugonzo.msscbeerservice.service;

import com.lugonzo.msscbeerservice.model.BeerDto;
import com.lugonzo.msscbeerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    @Override
    public Optional<BeerDto> getById(UUID beerId) {
        return beerRepository.findById(beerId);
    }

    @Override
    public BeerDto saveNewBeer(BeerDto newBeer) {
        return beerRepository.save(newBeer);
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto updateBeer) {

        Optional<BeerDto> beer = beerRepository.findById(beerId);

        if(beer.isPresent()){
            beer.get().setBeerName(updateBeer.getBeerName());
            beer.get().setBeerStyle(updateBeer.getBeerStyle());
            //beer.get().setCreatedDate(updateBeer.getCreatedDate());
            beer.get().setPrice(updateBeer.getPrice());
            //beer.get().setLastModifiedDate(updateBeer.getLastModifiedDate());
            //beer.get().setQuantityOnHand(updateBeer.getQuantityOnHand());
           // beer.get().setVersion(updateBeer.getVersion());
            beer.get().setUpc(updateBeer.getUpc());
        }


        return beerRepository.save(beer.get());
    }
}
