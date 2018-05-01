package com.sonalake.demo.system;

import com.sonalake.demo.model.Country;
import com.sonalake.demo.system.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {


    @Autowired
    CountryRepository countryRepository;



    @RequestMapping(value = "/country/")
    public Country countryByCode(@RequestParam("countryCode") String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }
}