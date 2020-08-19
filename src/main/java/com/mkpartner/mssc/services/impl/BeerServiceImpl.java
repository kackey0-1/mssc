package com.mkpartner.mssc.services.impl;

import com.mkpartner.mssc.domain.Beer;
import com.mkpartner.mssc.repositories.BeerRepository;
import com.mkpartner.mssc.services.BeerService;
import com.mkpartner.mssc.web.handlers.NotFoundException;
import com.mkpartner.mssc.web.mappers.BeerMapper;
import com.mkpartner.mssc.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
       Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
       beer.setBeerName(beerDto.getBeerName());
       beer.setBeerStyle(beerDto.getBeerStyle().name());
       beer.setPrice(beerDto.getPrice());
       beer.setUpc(beerDto.getUpc());

       return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public void deleteById(UUID beerId) {
        beerRepository.findById(beerId).ifPresent(beer -> {
            beerRepository.delete(beer);
        });
    }
}
