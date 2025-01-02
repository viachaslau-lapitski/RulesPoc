package org.example.router.v2;

import org.example.router.v2.FieldHandler;
import org.example.router.v2.Order;

import java.util.function.Function;

public class StringFieldHandler extends FieldHandler<String> {
    private final Function<Order, String> extractor;

    public StringFieldHandler(Function<Order, String> extractor) {
        this.extractor = extractor;
    }

    @Override
    public String extractValue(Order order) {
        return extractor.apply(order);
    }

    @Override
    public String parseValue(String value) {
        return value;
    }
}
