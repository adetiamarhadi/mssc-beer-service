package com.github.adetiamarhadi.msscbeerservice.services;

import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBer(UUID beerId, BeerDto beerDto);
}
