package org.example.router.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ComparisonOperator {
    @JsonProperty("EQUALS")
    EQUALS,
    @JsonProperty("NOT_EQUALS")
    NOT_EQUALS,
    @JsonProperty("GREATER_THAN")
    GREATER_THAN,
    @JsonProperty("LESS_THAN")
    LESS_THAN,
    @JsonProperty("GREATER_EQUALS")
    GREATER_EQUALS,
    @JsonProperty("LESS_EQUALS")
    LESS_EQUALS,
    @JsonProperty("IN")
    IN,
    @JsonProperty("BETWEEN")
    BETWEEN;
}
