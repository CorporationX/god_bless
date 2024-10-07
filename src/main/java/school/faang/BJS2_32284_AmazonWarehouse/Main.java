package school.faang.BJS2_32284_AmazonWarehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Set<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        PRODUCTS.add(new Product(1, "Laptop", "Electronics"));
        PRODUCTS.add(new Product(2, "Smartphone", "Electronics"));
        PRODUCTS.add(new Product(3, "Chair", "Furniture"));
        PRODUCTS.add(new Product(4, "Table", "Furniture"));
        PRODUCTS.add(new Product(5, "Notebook", "Stationery"));

        Map<String, List<Product>> groupedProducts = manager.getProductsByCategory(PRODUCTS);
        manager.printProductsByCategory(groupedProducts);
    }
}
