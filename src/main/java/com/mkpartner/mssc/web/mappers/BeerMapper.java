package com.mkpartner.mssc.web.mappers;

import com.mkpartner.mssc.services.domain.Beer;
import com.mkpartner.mssc.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
