package com.sonalake.demo;

import com.sonalake.demo.model.Country;
import com.sonalake.demo.model.ForeignExchange;
import com.sonalake.demo.model.Taxation;
import com.sonalake.demo.system.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;

public class CountryGenerator {

    @Autowired
    CountryRepository countryRepository;



    public void eventOnApplication(ContextRefreshedEvent event) {


        addNewCountry("Poland","POL","PLN",BigDecimal.valueOf(19),BigDecimal.valueOf(1200));
        addNewCountry("Germany","GER","EUR",BigDecimal.valueOf(20),BigDecimal.valueOf(800));
        addNewCountry("United Kingdom","GBR","GBP",BigDecimal.valueOf(25),BigDecimal.valueOf(600));

    }



    private void addNewCountry(String nameOfCountry,String codeOfCountry, String currencyCode, BigDecimal tax, BigDecimal costs ) {
        Country country = new Country( nameOfCountry, codeOfCountry );
        country = countryRepository.save(country);
        country.setCurrency( new ForeignExchange(currencyCode) );
        country.setTaxation( new Taxation(tax, costs));
        countryRepository.save(country);
    }
}

