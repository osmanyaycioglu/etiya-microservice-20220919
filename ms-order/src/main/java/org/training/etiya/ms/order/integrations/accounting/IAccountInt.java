package org.training.etiya.ms.order.integrations.accounting;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.etiya.ms.order.integrations.accounting.models.PaymentRequest;

@FeignClient("ACCOUNTING")
public interface IAccountInt {

    @PostMapping("/api/v1/payment/service/pay")
    public String pay(@RequestBody PaymentRequest paymentRequest);

}
