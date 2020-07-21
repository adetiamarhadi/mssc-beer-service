package com.github.adetiamarhadi.msscbeerservice.events;

import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
