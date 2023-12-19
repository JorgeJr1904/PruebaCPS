package com.cps.prueba.Controller.RestController;

import com.cps.prueba.Controller.DAO.LoginDao;
import com.cps.prueba.Controller.DTO.Response;
import com.cps.prueba.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/login")
public class LoginRest {

    @Autowired
    private LoginDao loginDao;

    @GetMapping
    public List<Client> getClient(){
        return loginDao.get();
    }

    @PostMapping
    public Response login(@RequestBody Client client){
        return loginDao.login(client);
    }

}
