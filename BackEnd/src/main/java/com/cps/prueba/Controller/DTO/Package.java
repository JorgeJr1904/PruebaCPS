package com.cps.prueba.Controller.DTO;

import com.cps.prueba.Model.Fee;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@Getter @Setter @ToString @EqualsAndHashCode
public class Package {

    int weight;

    int width;

    int height;

    int large;

    Fee fee;

}
