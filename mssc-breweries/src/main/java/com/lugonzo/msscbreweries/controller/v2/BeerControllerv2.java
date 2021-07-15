package com.lugonzo.msscbreweries.controller.v2;

import com.lugonzo.msscbreweries.model.BeerDto;
import com.lugonzo.msscbreweries.model.v2.BeerDtoV2;
import com.lugonzo.msscbreweries.service.v2.BeerServicev2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerv2 {

    private final BeerServicev2 beerServicev2;

    public BeerControllerv2(BeerServicev2 beerServicev2) {
        this.beerServicev2 = beerServicev2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<BeerDtoV2> orderBeer(@Valid @NotNull @RequestBody BeerDto newBeer){
        BeerDtoV2 saveBeer = beerServicev2.orderBeer(newBeer);

        HttpHeaders headers = new HttpHeaders();
        //TODO : Add hostname to url
        headers.add("Location","/api/v1/beer/order" + saveBeer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/update/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,
                                     @Valid @RequestBody BeerDtoV2 updateBeer  ){

        beerServicev2.updateBeer(beerId,updateBeer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServicev2.deleteBeer(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
