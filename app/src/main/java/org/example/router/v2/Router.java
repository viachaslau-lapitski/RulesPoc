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
}
