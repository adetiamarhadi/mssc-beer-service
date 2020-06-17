package com.github.adetiamarhadi.msscbeerservice.repositories;

import com.github.adetiamarhadi.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
