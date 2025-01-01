package org.example.router.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String ticker;
    private double price;
    private int quantity;
}
