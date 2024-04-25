package faang.school.godbless.sprint_2.recommendation_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private static int startId = 0;
    private int id;
    private String name;
    private String category;
    private double price;
    private List<String> tags;

    public Product(String name, String category, double price, List<String> tags) {
        this.id = startId++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }
}