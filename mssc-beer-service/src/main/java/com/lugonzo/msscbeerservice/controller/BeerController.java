package com.lugonzo.msscbeerservice.controller;

import com.lugonzo.msscbeerservice.model.BeerDto;
import com.lugonzo.msscbeerservice.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<Optional<BeerDto>> getBeerById(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveBeer(@RequestBody @Validated BeerDto newBeer){

        return new ResponseEntity<>(beerService.saveNewBeer(newBeer), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId") UUID beerId,
                                   @RequestBody @Validated BeerDto updateBeer ){
        //TODO impl
        return new ResponseEntity<>(beerService.updateBeer(beerId,updateBeer), HttpStatus.NO_CONTENT);
    }
}
