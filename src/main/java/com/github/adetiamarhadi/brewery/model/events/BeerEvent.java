package com.github.adetiamarhadi.brewery.model.events;

import com.github.adetiamarhadi.brewery.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 6641778200282761010L;

    private BeerDto beerDto;
}
