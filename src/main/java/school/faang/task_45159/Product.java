package school.faang.task_45159;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Product {

    private int id;

    private String name;

    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', category='%s'}", id, name, category);
    }


}
