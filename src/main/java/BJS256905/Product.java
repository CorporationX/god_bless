package BJS256905;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}