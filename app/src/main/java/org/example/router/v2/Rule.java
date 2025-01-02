package org.example.router.v2;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
public class Rule {
    private int ruleId;
    private int priority;
    private List<Criterion> criteria;
    private String omsRoute;

    private List<Predicate<Order>> predicates;

    private void initializePredicates() {
        this.predicates = criteria.stream()
                .map(Criterion::getPredicate)
                .collect(Collectors.toList());
    }

    @JsonSetter("criteria")
    public void setCriteria(List<Criterion> criteria) {
        this.criteria = criteria;
        initializePredicates();
    }

    public boolean matches(Order order) {
        return predicates.stream().allMatch(predicate -> predicate.test(order));
    }
}
