package com.github.adetiamarhadi.msscbeerservice.web.mappers;

import com.github.adetiamarhadi.msscbeerservice.domain.Beer;
import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
