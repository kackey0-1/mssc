package com.mkpartner.mssc.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by k-k on 2020/08/17
 */
public class BaseTest {

    BeerDto getDto(){
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyle("Ale")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.93"))
                .upc(1231231231L)
                .myLocalDate(LocalDate.now())
                .build();
    }
}
