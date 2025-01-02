package org.example.router.v2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Router {
    private String omsRouteOverride;
    private List<Rule> rules;
    private String defaultOmsRoute;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime lastUpdatedTs;

    public String evaluate(Order order) {
//        if (omsRouteOverride != null) {
//            return omsRouteOverride;
//        }

        // Sort rules by priority
        // rules.sort(Comparator.comparingInt(Rule::getPriority));
        for (Rule rule : rules) {
            if (rule.matches(order)) {
                return rule.getOmsRoute();
            }
        }
        return defaultOmsRoute != null ? defaultOmsRoute : "DefaultOMS";
    }
}
