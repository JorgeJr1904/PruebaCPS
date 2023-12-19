package com.cps.prueba.Controller.RestController;

import com.cps.prueba.Controller.DAO.ShippingCostDao;
import com.cps.prueba.Controller.DTO.Package;
import com.cps.prueba.Model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/fee")
public class ShippingRestController {

    @Autowired
    ShippingCostDao shippingCostDao;

    @PostMapping("total/{token}")
    public BigDecimal shippingCost(@PathVariable String token, @RequestBody Package pack){
        if (Objects.equals(token, "")){
            return shippingCostDao.total(pack, "token");
        }else {
            return shippingCostDao.total(pack, token);
        }
    }

}
