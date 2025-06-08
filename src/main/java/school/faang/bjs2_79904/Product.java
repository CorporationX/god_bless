package school.faang.bjs2_79904;

public class Product {
    private int id = 1;
    private final String name;
    private final Category category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Product(String name, Category category) {
        this.id += 1;
        this.name = name;
        this.category = category;
    }
}
