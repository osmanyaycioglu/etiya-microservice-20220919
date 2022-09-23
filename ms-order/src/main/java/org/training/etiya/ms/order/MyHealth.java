package org.training.etiya.ms.order;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import org.training.etiya.ms.order.models.Order;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status(Status.UP)
                     .withDetail("myh",
                                 new Order())
                     .build();
    }
}
