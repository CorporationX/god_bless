package faang.school.godbless.java_sql.task_6;

import java.util.HashSet;

public class ProductProvider {
    static HashSet<Product> provideProducts() {
        HashSet<Product> products = new HashSet<>();

        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Smartphone", "Electronics"));
        products.add(new Product(3, "Desk Chair", "Furniture"));
        products.add(new Product(4, "Coffee Table", "Furniture"));
        products.add(new Product(5, "Refrigerator", "Appliances"));
        products.add(new Product(6, "Microwave", "Appliances"));
        products.add(new Product(7, "T-Shirt", "Clothing"));
        products.add(new Product(8, "Jeans", "Clothing"));
        products.add(new Product(9, "Running Shoes", "Footwear"));
        products.add(new Product(10, "Sandals", "Footwear"));
        products.add(new Product(11, "Pants", "Clothing"));
        return products;
    }
}
