package org.example.router.v1;

import java.util.function.Predicate;

public abstract class FieldHandler<T extends Comparable<T>> {
    public abstract T extractValue(Order order);
    public abstract T parseValue(String value);

    public Predicate<Order> getPredicate(String operation, String value) {
        T matcherValue = parseValue(value);

        return order -> {
            T orderValue = extractValue(order);
            if (orderValue == null) {
                return false; // or handle nulls as per your requirement
            }

            return switch (operation) {
                case "eq" -> orderValue.compareTo(matcherValue) == 0;
                case "neq" -> orderValue.compareTo(matcherValue) != 0;
                case "gt" -> orderValue.compareTo(matcherValue) > 0;
                case "lt" -> orderValue.compareTo(matcherValue) < 0;
                case "ge" -> orderValue.compareTo(matcherValue) >= 0;
                case "le" -> orderValue.compareTo(matcherValue) <= 0;
                default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
            };
        };
    }
}
