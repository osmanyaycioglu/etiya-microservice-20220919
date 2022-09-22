package org.training.etiya.ms.order.obj.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.training.etiya.ms.order.models.Meal;
import org.training.etiya.ms.order.models.Order;
import org.training.etiya.ms.order.rest.models.MealRest;
import org.training.etiya.ms.order.rest.models.OrderRest;

@Mapper
public interface OrderMapping {

    OrderMapping ORDER_MAPPING = Mappers.getMapper(OrderMapping.class);

    Order toOrder(OrderRest orderRest);

    OrderRest toOrderRest(Order order);

    Meal toMeal(MealRest mealRest);

    MealRest toMealRest(Meal meal);

}
