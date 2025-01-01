package org.example.router.v1;

import java.util.function.Predicate;

public class Matcher {
    private final String fieldName;
    private final String operation;
    private final String value;
    private final Predicate<Order> matcherFunction;
    private final FieldHandler<?> fieldHandler;

    public Matcher(String fieldName, String operation, String value) {
        this.fieldName = fieldName;
        this.operation = operation;
        this.value = value;

        // Get the appropriate FieldHandler
        this.fieldHandler = FieldHandlers.getFieldHandler(fieldName);
        if (this.fieldHandler == null) {
            throw new IllegalArgumentException("Unknown field: " + fieldName);
        }

        // Compile the matcher function using the FieldHandler
        this.matcherFunction = fieldHandler.getPredicate(operation, value);
    }

    public Predicate<Order> getMatcherFunction() {
        return matcherFunction;
    }
}
