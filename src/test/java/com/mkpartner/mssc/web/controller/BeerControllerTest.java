package com.mkpartner.mssc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkpartner.mssc.services.BeerService;
import com.mkpartner.mssc.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.JsonPathResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @BeforeEach
    public void setUp(){
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                            .beerName("Beer1")
                            .beerStyle("PALE_ALE")
                            .upc(123456789012l)
                            .build();
    }

    @Test
    void getBeer()  throws Exception {
        given(beerService.getBeerById(any())).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBeer.getId().toString()))
                .andExpect(jsonPath("$.beerName").value(validBeer.getBeerName()));
    }

    @Test
    void handlePost() {
    }

    @Test
    void handleUpdate() {
        //given
    }
}