package com.mkpartner.mssc.web.mappers;

import com.mkpartner.mssc.domain.Beer;
import com.mkpartner.mssc.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by k-k on 2020/08/14
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto(Beer beer);
}
