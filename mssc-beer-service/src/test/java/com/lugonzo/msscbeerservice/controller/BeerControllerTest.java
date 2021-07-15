package com.lugonzo.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lugonzo.msscbeerservice.model.BeerDto;
import com.lugonzo.msscbeerservice.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Supplier;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
@ExtendWith(SpringExtension.class)
class BeerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
       // mockMvc.perform((MockMvcRequestBuilders.get("/api/v1/beer" + UUID.randomUUID().toString())
       //                );

                RequestBuilder request= MockMvcRequestBuilders
                        .get("/api/v1/beer/" + UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON);

                 ResultActions result = mockMvc.perform(request)
                   .andExpect(status().isOk());
                   /*.andExpect(content().string("HellWorld2"))
                     .andReturn();*/
    }

    @Test
    void saveBeer() throws Exception {
        BeerDto beerDto= getValidBeerDto.get();
        beerDto.setId(null);
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJSON))
                        .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto= getValidBeerDto.get();
        beerDto.setId(null);
        String beerDtoJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" +UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJSON))
                .andExpect(status().isNoContent());

    }

   /* BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .price(new BigDecimal("2.99"))
                .beerName("My beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(1212121212121L)
                .build();
    }*/

    static Supplier<BeerDto> getValidBeerDto = ()->  BeerDto.builder()
            .price(new BigDecimal("2.99"))
            .beerName("My beer")
            .beerStyle(BeerStyleEnum.ALE)
            .upc(1212121212121L)
            .build();
}