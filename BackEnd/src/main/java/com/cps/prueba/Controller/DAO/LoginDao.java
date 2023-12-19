package com.cps.prueba.Controller.DAO;

import com.cps.prueba.Controller.DTO.Response;
import com.cps.prueba.Model.Client;
import com.cps.prueba.Model.Fee;
import com.cps.prueba.Utils.JWTUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class LoginDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    Response response;

    @Autowired
    private JWTUtil jwtUtil;

    public Response login(Client client){
        String token = "";
        Client bdClient = validateEmail(client.getEmail());
    if (bdClient != null){
        if (Objects.equals(bdClient.getPassword(), client.getPassword())){
            token = jwtUtil.create(String.valueOf(bdClient.getId()), bdClient.getName());
            return response.createMessage(200, "Login Correcto", token);
        }else {
            return response.createMessage(200, "Correo o Contrasenia Incorrectos", "");
        }
    }else {
        return response.createMessage(200, "Correo o Contrasenia Incorrectos", "");
    }

    }

    public Client validateEmail(String email){
        String sql = "SELECT c From Client c WHERE c.email = :email";
        return entityManager.createQuery(sql, Client.class).setParameter("email", email).getSingleResult();
    }

    public List<Client> get(){
        return entityManager.createQuery("FROM Client").getResultList();
    }
}
