package com.github.adetiamarhadi.msscbeerservice.events;

import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
