package com.cps.prueba.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "fee")
@ToString @EqualsAndHashCode @Getter @Setter
public class Fee {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfee")
    int idShipping;

    @Column(name = "region")
    String region;

    @Column(name = "price")
    BigDecimal price;
}
