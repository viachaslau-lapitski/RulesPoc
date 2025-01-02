package org.example.router.v2;

import lombok.Data;

import java.util.List;
import java.util.function.Predicate;


@Data
public class Criterion {
    private String dataPointName;
    private ComparisonOperator comparisonOperator;
    private List<String> dataPointValueList;
    private String dataPointValue;
    private String dataPointLowValue;
    private String dataPointHighValue;

    public Predicate<Order> getPredicate() {
        FieldHandler<?> fieldHandler = FieldHandlers.getFieldHandler(dataPointName);
        if (fieldHandler == null) {
            throw new IllegalArgumentException("Unknown dataPointName: " + dataPointName);
        }

        return switch (comparisonOperator) {
            case EQUALS -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for EQUALS operation");
                }
                yield fieldHandler.equalsPredicate(dataPointValue);
            }
            case NOT_EQUALS -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for NOT_EQUALS operation");
                }
                yield fieldHandler.notEqualsPredicate(dataPointValue);
            }
            case GREATER_THAN -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for GREATER_THAN operation");
                }
                yield fieldHandler.greaterThanPredicate(dataPointValue);
            }
            case LESS_THAN -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for LESS_THAN operation");
                }
                yield fieldHandler.lessThanPredicate(dataPointValue);
            }
            case GREATER_EQUALS -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for GREATER_EQUALS operation");
                }
                yield fieldHandler.greaterEqualsPredicate(dataPointValue);
            }
            case LESS_EQUALS -> {
                if (dataPointValue == null) {
                    throw new IllegalArgumentException("dataPointValue is required for LESS_EQUALS operation");
                }
                yield fieldHandler.lessEqualsPredicate(dataPointValue);
            }
            case IN -> {
                if (dataPointValueList == null) {
                    throw new IllegalArgumentException("dataPointValueList is required for IN operation");
                }
                yield fieldHandler.inPredicate(dataPointValueList);
            }
            case BETWEEN -> {
                if (dataPointLowValue == null || dataPointHighValue == null) {
                    throw new IllegalArgumentException("dataPointLowValue and dataPointHighValue are required for BETWEEN operation");
                }
                yield fieldHandler.betweenPredicate(dataPointLowValue, dataPointHighValue);
            }
            default -> throw new IllegalArgumentException("Unsupported comparisonOperator: " + comparisonOperator);
        };
    }
}
