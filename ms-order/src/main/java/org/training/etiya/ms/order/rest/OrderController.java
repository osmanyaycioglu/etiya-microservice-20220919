package org.training.etiya.ms.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.ms.order.obj.mappings.OrderMapping;
import org.training.etiya.ms.order.rest.error.ErrorObj;
import org.training.etiya.ms.order.rest.models.OrderRest;
import org.training.etiya.ms.order.rest.models.OrderResult;
import org.training.etiya.ms.order.services.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public OrderResult placeOrder(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
                                .setOrderId(10L);
    }
    @PostMapping("/place2")
    public OrderResult placeOrder2(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder2(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
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
