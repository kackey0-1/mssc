package com.mkpartner.mssc.services.impl;

import com.mkpartner.mssc.services.BeerService;
import com.mkpartner.mssc.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                                .beerName("Galaxy Cat")
                                .beerStyle("Pale Ale")
                                .upc(100l)
                                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //TODO code real impl to update beer
    }
}
