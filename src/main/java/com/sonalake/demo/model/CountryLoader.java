package com.sonalake.demo.model;

import com.sonalake.demo.system.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public class CountryLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    CountryRepository countryRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        addCountry( "POL", "Poland",         "PLN", BigDecimal.valueOf(19), BigDecimal.valueOf(1200) );
        addCountry( "GBR", "United Kingdom", "GBP", BigDecimal.valueOf(25), BigDecimal.valueOf(600)  );
        addCountry( "GER", "Germany",        "EUR", BigDecimal.valueOf(20), BigDecimal.valueOf(800)  );
    }

    private void addCountry( String code, String nameOfCountry, String currencyCode, BigDecimal tax, BigDecimal costs ) {
        Country country = new Country( code, nameOfCountry );
        country = countryRepository.save(country);
        country.setCurrency( new Currency(currencyCode) );
        country.setTaxation( new Taxation(tax, costs));
        countryRepository.save(country);
    }
}
