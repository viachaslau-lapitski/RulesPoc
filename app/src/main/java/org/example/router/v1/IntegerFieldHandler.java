package org.example.router.v1;

import java.util.function.Function;

public class IntegerFieldHandler extends FieldHandler<Integer> {
    private final Function<Order, Integer> extractor;

    public IntegerFieldHandler(Function<Order, Integer> extractor) {
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
