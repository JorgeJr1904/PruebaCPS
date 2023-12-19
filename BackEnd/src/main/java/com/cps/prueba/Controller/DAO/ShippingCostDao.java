package com.cps.prueba.Controller.DAO;

import com.cps.prueba.Controller.DTO.Package;
import com.cps.prueba.Model.Client;
import com.cps.prueba.Model.Fee;
import com.cps.prueba.Model.TypeClient;
import com.cps.prueba.Utils.JWTUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class ShippingCostDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private ValidTokenDao validTokenDao;

    public BigDecimal total(Package pack, String token){
        int discount = 0;
        try{
            //For Get the shipping price by the region
            Fee fee = entityManager.find(Fee.class, pack.getFee().getIdShipping());

            //Get the client type for discount
            if (validTokenDao.validToken(token)){
                int clientId = Integer.parseInt(jwtUtil.getKey(token));
                System.out.println(Integer.parseInt(jwtUtil.getKey(token)));
                Client client = entityManager.find(Client.class, clientId);
                TypeClient typeClient = entityManager.find(TypeClient.class, client.getIdTypeClient());
                if (typeClient != null){
                    discount = typeClient.getDiscount();
                }
            }


            //total of purchase
            BigDecimal compra = (fee.getPrice().multiply(BigDecimal.valueOf(pack.getWeight()))).add(BigDecimal.valueOf(1.66)).multiply(BigDecimal.valueOf(pack.getHeight() * pack.getLarge() * pack.getWidth()));

            return compra.subtract(discount(compra, discount)).multiply(BigDecimal.valueOf(pack.getWeight()).multiply(BigDecimal.valueOf(0.5)));
        }catch (Exception e){
            return null;

        }

    }

    //method to obtain discount of the client
    public BigDecimal discount(BigDecimal compra, int intDiscount){
        BigDecimal discount = BigDecimal.valueOf(intDiscount);
        return discount.divide(BigDecimal.valueOf(100)).multiply(compra);
    }

}
