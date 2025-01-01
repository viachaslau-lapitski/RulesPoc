package org.example.router.v1;

import java.util.List;

public class OrderEvaluator {
    public boolean evaluateRule(Order order, Rule rule) {
        for (Matcher matcher : rule.getMatchers()) {
            if (!matcher.getMatcherFunction().test(order)) {
                // If any matcher returns false, the rule does not match
                return false;
            }
        }
        // All matchers returned true
        return true;
    }

    public String evaluateOrder(Order order, List<Rule> rules) {
        // Iterate over rules (assumed ordered by priority)
        for (Rule rule : rules) {
            if (evaluateRule(order, rule)) {
                return rule.getOms();
            }
        }
        // Default OMS if no rules match
        return "DefaultOMS";
    }
}
