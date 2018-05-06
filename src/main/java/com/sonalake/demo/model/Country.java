package com.sonalake.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Data
public class Country implements Serializable {

    @Id
    String code;

    @Column(name="name")
    String name;

    @OneToOne(cascade=CascadeType.ALL)
    Currency currency;

    @OneToOne(cascade=CascadeType.ALL)
    Taxation taxation;

    public Country( String code, String name) {
        this.code = code;
        this.name = name;
    }


}
