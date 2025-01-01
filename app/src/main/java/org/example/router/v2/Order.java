package org.example.router.v2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String ticker;
    private String cusip;
    private double price;
    private String priceType;
    private int quantity;
    private int limitPrice;
}


