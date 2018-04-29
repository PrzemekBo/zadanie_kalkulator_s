package com.sonalake.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country implements Serializable {



    @Column(name="name")
    String name;

    @OneToOne(cascade=CascadeType.ALL)
    ForeignExchange foreignExchange;


    @OneToOne(cascade=CascadeType.ALL)
    Taxation taxation;



}
