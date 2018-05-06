package com.sonalake.demo.system;

import com.sonalake.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT country FROM Country country WHERE country.code = ?1")
    Country selectByCountryCode(String code);
}
