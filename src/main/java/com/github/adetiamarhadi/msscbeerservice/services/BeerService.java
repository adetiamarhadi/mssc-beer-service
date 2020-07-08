package com.github.adetiamarhadi.msscbeerservice.services;

import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;
import com.github.adetiamarhadi.msscbeerservice.web.model.BeerPagedList;
import com.github.adetiamarhadi.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest,
                            Boolean showInventoryOnHand);
}
