package org.example.router.v1;

import java.util.List;

public class Rule {
    private List<Matcher> matchers;
    private String oms;

    // Constructor
    public Rule(List<Matcher> matchers, String oms) {
        this.matchers = matchers;
        this.oms = oms;
    }

    // Getters
    public List<Matcher> getMatchers() { return matchers; }
    public String getOms() { return oms; }
}
