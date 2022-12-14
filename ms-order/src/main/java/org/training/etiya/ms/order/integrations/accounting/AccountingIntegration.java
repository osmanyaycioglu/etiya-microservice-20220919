package org.training.etiya.ms.order.integrations.accounting;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.training.etiya.ms.order.integrations.accounting.models.PaymentRequest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccountingIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient ec;

    @Autowired
    private IAccountInt accountInt;

    public String pay3(PaymentRequest paymentRequest) {
        return accountInt.pay(paymentRequest);
    }

    @Retry(name = "accounting_retry")
    public String pay(PaymentRequest paymentRequest) {
        String result = restTemplate.postForObject("http://ACCOUNTING/api/v1/payment/service/pay",
                                                   paymentRequest,
                                                   String.class);
        return result;
    }

    private AtomicInteger index = new AtomicInteger();

    public String pay2(PaymentRequest paymentRequest) {
        Application accounting = ec.getApplication("ACCOUNTING");
        List<InstanceInfo> instances = accounting.getInstances();
        for (InstanceInfo instanceInfo : instances) {
            System.out.println(instanceInfo);
        }
        int i = index.incrementAndGet() % instances.size();
        InstanceInfo instanceInfo = instances.get(i);
        RestTemplate template = new RestTemplate();
        String result = template.postForObject("http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/api/v1/payment/service/pay",
                                               paymentRequest,
                                               String.class);
        return result;
    }

}
