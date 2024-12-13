package school.faang.sprint_1.task_45180;

import lombok.Getter;

@Getter
public class Product {
    private final int id;
    private final String name;
    private final String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{id=" + id 
                + ", name='" + name 
                + "', category='" + category + "'}";
    }
}
