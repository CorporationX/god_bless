package faang.school.godbless.amazon;

public class Product {
    private int ID;
    private String name;
    private String category;

    public Product(int ID, String name, String category) {
        this.ID = ID;
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
