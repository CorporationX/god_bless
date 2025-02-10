package school.faang.task_56988;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adding of products");
        ProductManager productManager = new ProductManager(new HashSet<>(), new HashMap<>());

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        productManager.printAllProducts();
        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Removal of products");

        productManager.removeProduct(Category.ELECTRONICS, "Smartphone");
        productManager.removeProduct(Category.ELECTRONICS, "Laptop");

        productManager.printAllProducts();
        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Adding multiple products");

        List<Product> productsToAdd = Arrays.asList(
                new Product(productManager.getNextId(), "Apple", Category.FOOD),
                new Product(productManager.getNextId(), "Bread", Category.FOOD),
                new Product(productManager.getNextId(), "Laptop", Category.ELECTRONICS),
                new Product(productManager.getNextId(), "Smartphone", Category.ELECTRONICS),
                new Product(productManager.getNextId(), "Banana", Category.FOOD),
                new Product(productManager.getNextId(), "Smartphone", Category.ELECTRONICS),
                new Product(productManager.getNextId(), "Laptop", Category.ELECTRONICS),
                new Product(productManager.getNextId(), "T-Shirt", Category.CLOTHING),
                new Product(productManager.getNextId(), "Jeans", Category.CLOTHING),
                new Product(productManager.getNextId(), "Book", Category.OTHER),
                new Product(productManager.getNextId(), "Notebook", Category.OTHER),
                new Product(productManager.getNextId(), "Headphones", Category.ELECTRONICS)
        );
        for (Product product : productsToAdd) {
            productManager.addProduct(product.getCategory(), product.getName());
        }
        productManager.printAllProducts();

        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Find products by category");

        List<Product> foodProducts = productManager.findProductsByCategory(Category.FOOD);
        System.out.println(foodProducts);

        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Group products by category");

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
