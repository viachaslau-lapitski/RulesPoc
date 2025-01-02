package org.example.router.v2;

import org.example.router.v2.FieldHandler;
import org.example.router.v2.Order;

import java.util.function.Function;

public class IntFieldHandler extends FieldHandler<Integer> {
    private final Function<Order, Integer> extractor;

    public IntFieldHandler(Function<Order, Integer> extractor) {
        this.extractor = extractor;
    }

    @Override
    public Integer extractValue(Order order) {
        return extractor.apply(order);
    }

    @Override
    public Integer parseValue(String value) {
        return Integer.parseInt(value);
    }
}
