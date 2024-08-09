package faang.school.godbless.amazonwarehouse;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shoes", "Clothes"));
        products.add(new Product(3, "Perfume", "Cosmetics"));
        products.add(new Product(4, "Camera", "Electronics"));
        products.add(new Product(5, "Sofa", "Furniture"));
        products.add(new Product(6, "Jacket", "Clothes"));
        products.add(new Product(7, "Microwave", "Electronics"));
        products.add(new Product(8, "Chair", "Furniture"));
        products.add(new Product(9, "Lipstick", "Cosmetics"));
        products.add(new Product(10, "Bicycle", "Sport"));

        productService.showProductsByCategory(products);
    }
}
