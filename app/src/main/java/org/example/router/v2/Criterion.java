package org.example.router.v2;

import lombok.Data;

import java.util.List;

@Data
class Criterion {
    private String dataPointName;
    private String comparisonOperator;
    private List<String> dataPointValueList;
    private String dataPointValue;
    private String dataPointLowValue;
    private String dataPointHighValue;
}
