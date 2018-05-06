package com.sonalake.demo.controller;

import com.sonalake.demo.model.Country;
import com.sonalake.demo.system.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class CountryController {


    @Autowired
    CountryRepository countryRepository;


    @RequestMapping( value = "/country/", produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody
    Country countryByCode(@RequestParam("countryCode") String countryCode) {

        return countryRepository.selectByCountryCode(countryCode);
    }

    @RequestMapping( value = "/country/all/", produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody
    List<Country> countries() {

        return countryRepository.findAll();
    }



}
