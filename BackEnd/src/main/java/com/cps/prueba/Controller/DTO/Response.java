package com.cps.prueba.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.stereotype.Repository;

@ToString @EqualsAndHashCode @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Response {

    int status;

    String message;

    String token;

    public Response createMessage(int status, String message, String token){
        return new Response(status, message, token);
    }

}
