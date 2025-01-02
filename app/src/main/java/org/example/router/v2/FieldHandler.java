package org.example.router.v2;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class FieldHandler<T extends Comparable<T>> {
    public abstract T extractValue(Order order);
    public abstract T parseValue(String value);

    public Predicate<Order> equalsPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(parsedValue) == 0;
        };
    }

    public Predicate<Order> notEqualsPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue == null || orderValue.compareTo(parsedValue) != 0;
        };
    }

    public Predicate<Order> greaterThanPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(parsedValue) > 0;
        };
    }

    public Predicate<Order> lessThanPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(parsedValue) < 0;
        };
    }

    public Predicate<Order> greaterEqualsPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(parsedValue) >= 0;
        };
    }

    public Predicate<Order> lessEqualsPredicate(String value) {
        T parsedValue = parseValue(value);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(parsedValue) <= 0;
        };
    }

    public Predicate<Order> inPredicate(List<String> values) {
        Set<T> parsedValues = values.stream()
                .map(this::parseValue)
                .collect(Collectors.toSet());
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && parsedValues.contains(orderValue);
        };
    }

    public Predicate<Order> betweenPredicate(String lowValue, String highValue) {
        T low = parseValue(lowValue);
        T high = parseValue(highValue);
        return order -> {
            T orderValue = extractValue(order);
            return orderValue != null && orderValue.compareTo(low) >= 0 && orderValue.compareTo(high) <= 0;
        };
    }
}
