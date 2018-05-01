package com.sonalake.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country implements Serializable {

    @Id
    String codeOfCountry;

    @Column(name="country")
    String nameOfCountry;

    @OneToOne(cascade=CascadeType.ALL)
    ForeignExchange foreignExchange;


    @OneToOne(cascade=CascadeType.ALL)
    Taxation taxation;


    public Country( String code, String name) {
        this.nameOfCountry = nameOfCountry;
        this.codeOfCountry = codeOfCountry;

    }



}
