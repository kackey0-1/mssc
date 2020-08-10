package com.mkpartner.mssc.web.controller;

import com.mkpartner.mssc.services.BeerService;
import com.mkpartner.mssc.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + UUID.randomUUID());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) // PUT - update beer
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"}) // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
