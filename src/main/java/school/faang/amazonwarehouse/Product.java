package school.faang.amazonwarehouse;

import lombok.Getter;

@Getter
public class Product {
    private static int nextId = 1;

    private final int id;
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}