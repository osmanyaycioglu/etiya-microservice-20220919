package org.training.etiya.ms.order.db;

import org.springframework.stereotype.Service;
import org.training.etiya.ms.order.models.Order;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderDao {
    private AtomicLong atomicLong = new AtomicLong();
    public void insertOrder(Order order){
        order.setOrderId(atomicLong.incrementAndGet());
        // Db
    }

}
