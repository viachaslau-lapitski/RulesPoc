package org.example.router.v1;

import java.util.function.Function;

public class DoubleFieldHandler extends FieldHandler<Double> {
    private final Function<Order, Double> extractor;

    public DoubleFieldHandler(Function<Order, Double> extractor) {
        this.extractor = extractor;
    }

    @Override
    public Double extractValue(Order order) {
        return extractor.apply(order);
    }

    @Override
    public Double parseValue(String value) {
        return Double.parseDouble(value);
    }
}
