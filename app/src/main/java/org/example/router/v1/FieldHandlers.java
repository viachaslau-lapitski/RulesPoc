package org.example.router.v1;

import java.util.HashMap;
import java.util.Map;

public class FieldHandlers {
    private static final Map<String, FieldHandler<?>> fieldHandlers = new HashMap<>();

    static {
        fieldHandlers.put("ticker", new StringFieldHandler(Order::getTicker));
        fieldHandlers.put("price", new DoubleFieldHandler(Order::getPrice));
        fieldHandlers.put("quantity", new IntegerFieldHandler(Order::getQuantity));
        // Add more fields as needed
    }

    public static FieldHandler<?> getFieldHandler(String fieldName) {
        return fieldHandlers.get(fieldName);
    }
}
