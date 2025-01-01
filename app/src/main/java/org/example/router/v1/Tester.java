package org.example.router.v1;

import java.util.Arrays;
import java.util.List;

public class Tester {

    public void runTests() {
        test1();
        test2();
    }

    public void test1() {
        // Example order
        org.example.router.v1.Order order = new org.example.router.v1.Order("1", "AAPL", 150.0, 100);

        // Create matchers for different fields
        Matcher priceMatcher = new Matcher("price", "gt", "100");
        Matcher quantityMatcher = new Matcher("quantity", "eq", "100");
        Matcher tickerMatcher = new Matcher("ticker", "eq", "AAPL");

        // Create a rule with multiple matchers
        Rule rule = new Rule(Arrays.asList(priceMatcher, quantityMatcher, tickerMatcher), "OMS1");

        // List of rules (priority-sorted list)
        List<Rule> rules = List.of(rule);


        // Create an evaluator
        OrderEvaluator evaluator = new OrderEvaluator();

        // Evaluate order
        String oms = evaluator.evaluateOrder(order, rules);

        System.out.println("Order should be routed to: " + oms); // Should print "OMS1"
    }

    public void test2() {
        // Example order
        org.example.router.v1.Order order = new org.example.router.v1.Order("1", "AAPL", 150.0, 100);

        // Create matchers for different fields
        Matcher priceMatcher = new Matcher("price", "gt", "100");
        Matcher quantityMatcher = new Matcher("quantity", "eq", "100");
        Matcher tickerMatcher = new Matcher("ticker", "eq", "AAPL");

        // Test the matchers
        boolean priceMatches = priceMatcher.getMatcherFunction().test(order);
        boolean quantityMatches = quantityMatcher.getMatcherFunction().test(order);
        boolean tickerMatches = tickerMatcher.getMatcherFunction().test(order);

        System.out.println("Price matches: " + priceMatches);       // Should print: Price matches: true
        System.out.println("Quantity matches: " + quantityMatches); // Should print: Quantity matches: true
        System.out.println("Ticker matches: " + tickerMatches);     // Should print: Ticker matches: true
    }
}
