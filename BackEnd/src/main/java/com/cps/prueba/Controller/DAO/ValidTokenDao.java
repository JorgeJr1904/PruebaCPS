package com.cps.prueba.Controller.DAO;

import com.cps.prueba.Utils.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ValidTokenDao {

    @Autowired
    private JWTUtil jwtUtil;

    public boolean validToken(String token){
        try{
                String userId = jwtUtil.getKey(token);
                return userId != null;
        }catch (ExpiredJwtException | MalformedJwtException ex){
                return false;
        }catch(SignatureException ex){
                return false;
        }
     }
}
