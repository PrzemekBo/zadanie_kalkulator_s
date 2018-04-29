package com.sonalake.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "foreignExchange")
@Data
@NoArgsConstructor
public class ForeignExchange implements Serializable {



    @Column(name="code", nullable = false, unique = true)
    String code;


    public ForeignExchange(String code ){
        this.code = code;
    }

}


