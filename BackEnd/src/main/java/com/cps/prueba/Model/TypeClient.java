package com.cps.prueba.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.naming.Name;

@Entity
@Table(name = "type_client")
@Getter @Setter @ToString @EqualsAndHashCode
public class TypeClient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtypeclient")
    int idTypeClient;

    @Column(name = "vtype")
    String type;

    @Column(name = "discount")
    int discount;

}
