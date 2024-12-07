package school.faang.bjs245160;

public enum ProductData {
    PRODUCT_A("A", "home"),
    PRODUCT_B("B", "games"),
    PRODUCT_C("C", "bla-bla-bla");

    private final String name;
    private final String category;

    ProductData(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Product createProduct() {
        return new Product(name, category);
    }
}
