package com.lugonzo.msscbeerservice.bootstrap;

import com.lugonzo.msscbeerservice.model.BeerDto;
import com.lugonzo.msscbeerservice.model.BeerStyleEnum;
import com.lugonzo.msscbeerservice.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
 import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC="01378238136137";
    public static final String BEER_2_UPC="08131731733137";
    public static final String BEER_3_UPC="05131371381378";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
         loadBeerObjects();
    }

    private void loadBeerObjects(){

        log.info("#########   Inserting dummy data ######## ");
        if(beerRepository.count() == 0){
            beerRepository.save(BeerDto.builder()
                    .id(UUID.randomUUID())
                    .beerName("Mongo pops")
                    .beerStyle(BeerStyleEnum.IPA)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(BeerDto.builder()
                    .id(UUID.randomUUID())
                    .beerName("Galaxy cat")
                    .beerStyle(BeerStyleEnum.GOSE)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(BeerDto.builder()
                    .id(UUID.randomUUID())
                    .beerName("Smirnof")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());

        }
    }
}
