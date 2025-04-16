package school.faang.amazon;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        System.out.println("--- Test Case 1: Adding and Printing Products ---");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.FOOD, "Apples");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.CLOTHING, "T-Shirt");
        manager.addProduct(Category.OTHER, "Novelty Mug");
        System.out.println(manager.printAllProducst());

        System.out.println("\n--- Test Case 2: Finding Products by Category ---");
        List<Product> electronics = manager.findProductByCategory(Category.ELECTRONICS);
        System.out.println("Electronics: " + electronics);

        List<Product> food = manager.findProductByCategory(Category.FOOD);
        System.out.println("Food: " + food);

        List<Product> clothing = manager.findProductByCategory(Category.CLOTHING);
        System.out.println("Clothing: " + clothing);

        List<Product> other = manager.findProductByCategory(Category.OTHER);
        System.out.println("Other: " + other);

        System.out.println("\n--- Test Case 3: Removing a Product ---");
        manager.removeProduct(Category.ELECTRONICS, "Smartphone");
        System.out.println(manager.findProductByCategory(Category.ELECTRONICS));

        System.out.println("\n--- Test Case 4: Removing Non-Existent Product ---");
        manager.removeProduct(Category.FOOD, "Bananas");
        System.out.println(manager.findProductByCategory(Category.FOOD));

        System.out.println("\n--- Test Case 5: Adding Duplicate Products ---");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        System.out.println("Electronics after adding duplicate: "
                + manager.findProductByCategory(Category.ELECTRONICS));

        System.out.println("\n--- Test Case 6: Grouping Products by Category ---");
        Map<Category, List<Product>> groupedProducts = manager.groupProductByCategory();
        System.out.println("Grouped Products: " + groupedProducts);

        System.out.println("\n--- Test Case 7: Printing All Products After Changes ---");
        System.out.println(manager.printAllProducst());

        System.out.println("\n--- Test Case 8: Adding More Products ---");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.CLOTHING, "Jeans");
        manager.addProduct(Category.OTHER, "Desk Lamp");
        System.out.println(manager.printAllProducst());
    }
}