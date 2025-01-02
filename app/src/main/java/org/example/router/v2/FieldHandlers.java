package org.example.router.v2;

import java.util.HashMap;
import java.util.Map;

public class FieldHandlers {
    private static final Map<String, FieldHandler<?>> fieldHandlers = new HashMap<>();

    static {
        fieldHandlers.put("CUSIP", new StringFieldHandler(Order::getCusip));
        fieldHandlers.put("LIMIT_PRICE", new IntFieldHandler(Order::getLimitPrice));
        fieldHandlers.put("PRICE_TYPE", new StringFieldHandler(Order::getPriceType));
        // Add more mappings as needed
    }

    public static FieldHandler<?> getFieldHandler(String dataPointName) {
        return fieldHandlers.get(dataPointName);
    }
}
