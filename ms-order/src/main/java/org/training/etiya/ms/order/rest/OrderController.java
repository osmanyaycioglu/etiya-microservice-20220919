package org.training.etiya.ms.order.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.ms.order.rest.error.ErrorObj;
import org.training.etiya.ms.order.rest.models.OrderRest;
import org.training.etiya.ms.order.rest.models.OrderResult;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @PostMapping("/place")
    public OrderResult placeOrder(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }

        return new OrderResult().setDesc("order alındı")
                                .setOrderId(10L);
    }

    @PostMapping("/cancel/{oid}")
    public String cancelOrder(@PathVariable("oid") Long orderId) {
        return "Order canceled : " + orderId;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exception) {
        return new ErrorObj().setMicroservice("ms-order")
                             .setDesc("test error : " + exception.getMessage())
                             .setCode(1024);
    }

}
