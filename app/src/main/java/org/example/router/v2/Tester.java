package org.example.router.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class Tester {
    public void runTests() {
        test2();
    }

    public void test1() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            Router router = objectMapper.readValue(json, Router.class);
            System.out.println(router);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            Router router = objectMapper.readValue(json, Router.class);
            //router.initialize();

            // Create sample orders
            Order order1 = Order.builder()
                    .cusip("111111111")
                    .priceType("LIMIT_PRICE")
                    .limitPrice(150)
                    .build();

            Order order2 = Order.builder()
                    .cusip("444444444")
                    .priceType("LIMIT_PRICE")
                    .limitPrice(50)
                    .build();

            // Evaluate orders
            String omsRoute1 = router.evaluate(order1);
            String omsRoute2 = router.evaluate(order2);

            System.out.println("Order 1 should be routed to: " + omsRoute1); // Should print "OMS_1"
            System.out.println("Order 2 should be routed to: " + omsRoute2); // Should print "OMS_2"

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    String json = """  
        {  
            "omsRouteOverride": "OMS_1",  
            "rules": [  
                {  
                    "ruleId": 1,  
                    "priority": 1,  
                    "criteria": [  
                        {  
                            "dataPointName": "CUSIP",  
                            "comparisonOperator": "IN",  
                            "dataPointValueList": ["111111111", "222222222", "333333333"],  
                            "dataPointValue": null,  
                            "dataPointLowValue": null,  
                            "dataPointHighValue": null  
                        }  
                    ],  
                    "omsRoute": "OMS_1"  
                },  
                {  
                    "ruleId": 2,  
                    "priority": 2,  
                    "criteria": [  
                        {  
                            "dataPointName": "PRICE_TYPE",  
                            "comparisonOperator": "EQUALS",  
                            "dataPointValueList": null,  
                            "dataPointValue": "LIMIT_PRICE",  
                            "dataPointLowValue": null,  
                            "dataPointHighValue": null  
                        },  
                        {  
                            "dataPointName": "LIMIT_PRICE",  
                            "comparisonOperator": "BETWEEN",  
                            "dataPointValueList": null,  
                            "dataPointValue": null,  
                            "dataPointLowValue": "100",  
                            "dataPointHighValue": "999"  
                        }  
                    ],  
                    "omsRoute": "OMS_2"  
                }  
            ],  
            "defaultOmsRoute": "OMS_2",  
            "lastUpdatedTs": "2024-12-13T08:15:05.674"  
        }""";
}
