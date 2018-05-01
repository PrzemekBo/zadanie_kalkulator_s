package com.sonalake.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
