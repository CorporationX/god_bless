package org.example.model.recommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long productId;
    private String name;
    private String category;
    private int price;
    private List<String> tags;
}
