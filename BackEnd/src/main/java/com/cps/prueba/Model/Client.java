package com.cps.prueba.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client")
@Getter @Setter @ToString
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idclient")
    int id;

    @Column(name = "vname")
    String name;

    @Column(name = "vlastname")
    String lastname;

    @Column(name = "email")
    String email;

    @Column(name = "vpassword")
    String password;

    @Column(name = "idtypeclient")
    int idTypeClient;
}
