package com.github.adetiamarhadi.msscbeerservice.bootstrap;

import com.github.adetiamarhadi.msscbeerservice.domain.Beer;
import com.github.adetiamarhadi.msscbeerservice.repositories.BeerRepository;
import com.github.adetiamarhadi.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {

        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
        Beer beer1 = beerRepository.save(Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle(BeerStyleEnum.IPA.name())
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("12.95"))
                .build());

        Beer beer2 = beerRepository.save(Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("12.95"))
                .build());

        Beer beer3 = beerRepository.save(Beer.builder()
                .beerName("Pinball Porter")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("11.95"))
                .build());

        beerRepository.save(beer1);
        beerRepository.save(beer2);
        beerRepository.save(beer3);
    }
}
