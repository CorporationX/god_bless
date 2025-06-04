package school.faang.bjs2_79790;

import lombok.Data;

@Data
public class Product {
    private final int id;
    private final String name;
    private final ProductCategory productCategory;

    private static int sequenceId = 1;

    public Product(String name, ProductCategory productCategory) {
        this.id = sequenceId++;
        this.name = name;
        this.productCategory = productCategory;
    }
}
