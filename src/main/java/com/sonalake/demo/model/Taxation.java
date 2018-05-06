package com.sonalake.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "taxation")
@NoArgsConstructor
@Data
public class Taxation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="value" )
    BigDecimal value;

    @Column(name="constant_costs" )
    BigDecimal constantCosts;

    public Taxation(BigDecimal value, BigDecimal costs) {
        this.value = value;
        this.constantCosts = costs;
    }
}
