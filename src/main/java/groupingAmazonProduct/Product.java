package groupingAmazonProduct;

public class Product {
    private String name;
    private String category;
    private int id;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String text = "";
        text += "Name: " + this.name + " ";
        text += "Category: " + this.category + " ";
        text += "ID: " + this.id + " ";

        return text;
    }
    public Product(String setName, String setCategory, int setId) {
        this.name = setName;
        this.category = setCategory;
        this.id = setId;
    }
}