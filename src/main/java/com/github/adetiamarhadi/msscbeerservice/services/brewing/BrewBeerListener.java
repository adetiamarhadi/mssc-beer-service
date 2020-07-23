package com.github.adetiamarhadi.msscbeerservice.services.brewing;

import com.github.adetiamarhadi.msscbeerservice.config.JmsConfig;
import com.github.adetiamarhadi.msscbeerservice.domain.Beer;
import com.github.adetiamarhadi.msscbeerservice.events.BrewBeerEvent;
import com.github.adetiamarhadi.msscbeerservice.events.NewInventoryEvent;
import com.github.adetiamarhadi.msscbeerservice.repositories.BeerRepository;
import com.github.adetiamarhadi.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent brewBeerEvent) {

        BeerDto beerDto = brewBeerEvent.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer {} : QOH: {}", beer.getMinOnHand(), beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
