package org.training.etiya.ms.order.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderQueryController {

    public String getOrderInfo(Long orderId){
        return "ok";
    }
}
