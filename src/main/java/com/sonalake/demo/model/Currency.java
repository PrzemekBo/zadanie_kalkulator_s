package com.sonalake.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "currency")
@NoArgsConstructor
@Data
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="code")
    String code;


    public Currency(String code ){
        this.code = code;
    }

}
