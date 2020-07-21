package com.github.adetiamarhadi.msscbeerservice.events;

import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 6641778200282761010L;

    private final BeerDto beerDto;
}
