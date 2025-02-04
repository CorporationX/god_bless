package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Banana");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("All products:");
        manager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Apple");

        System.out.println("\nProducts after removal:");
        manager.printAllProducts();

        System.out.println("\nProducts in FOOD category:");
        List<Product> foodProducts = manager.findProductsByCategory(Category.FOOD);
        for (Product product : foodProducts) {
            System.out.println(product);
        }
    }
}