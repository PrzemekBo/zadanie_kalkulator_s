package com.sonalake.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {


    @Autowired
    CountryRepository countryRepository;
}