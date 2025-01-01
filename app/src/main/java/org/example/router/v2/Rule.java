package org.example.router.v2;

import lombok.Data;

import java.util.List;

@Data
public class Rule {
    private int ruleId;
    private int priority;
    private List<Criterion> criteria;
    private String omsRoute;
}
