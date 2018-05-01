package com.sonalake.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "taxation")
@Data
@NoArgsConstructor
public class Taxation implements Serializable {


    @Column(name="value" )
    BigDecimal value;

    @Column
    BigDecimal constantCosts;

    public Taxation(BigDecimal value, BigDecimal costs) {
        this.value = value;
        this.constantCosts = costs;
    }
}
