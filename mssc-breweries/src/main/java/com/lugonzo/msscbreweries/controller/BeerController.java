package com.lugonzo.msscbreweries.controller;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

//@Deprecated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<BeerDto> orderBeer(@Valid  @RequestBody BeerDto newBeer){
        BeerDto saveBeer = beerService.orderBeer(newBeer);

        HttpHeaders headers = new HttpHeaders();
        //TODO : Add hostname to url
        headers.add("Location","/api/v1/beer/order/" + saveBeer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/update/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,
                                      @Valid @RequestBody BeerDto updateBeer  ){

        beerService.updateBeer(beerId,updateBeer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }
}
