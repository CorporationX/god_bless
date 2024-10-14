package org.example.model.recommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    private long userId;
    private long productId;
    private String orderDate;
}
