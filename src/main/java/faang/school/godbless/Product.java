package faang.school.godbless;

public class Product {
    private int id;
    private String name, category;

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
