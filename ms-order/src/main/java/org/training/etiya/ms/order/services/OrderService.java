package org.training.etiya.ms.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.training.etiya.ms.order.db.OrderDao;
import org.training.etiya.ms.order.integrations.accounting.AccountingIntegration;
import org.training.etiya.ms.order.integrations.accounting.models.PaymentRequest;
import org.training.etiya.ms.order.integrations.notifier.NotifierInt;
import org.training.etiya.ms.order.models.Order;

@Service
// @RefreshScope
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountingIntegration accountingIntegration;

    @Autowired
    private NotifierInt notifierInt;

    public String placeOrder(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        String pay = accountingIntegration.pay(paymentRequest);
        notifierInt.sendSMS(order.getCustomerNumber(),
                            "İşleminiz alındı");
        return pay;
    }

    public String placeOrder2(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay2(paymentRequest);
    }

    public String placeOrder3(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay3(paymentRequest);

    }
}
