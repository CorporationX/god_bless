package bjs287104;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        manager.groupProductsByCategory();

        System.out.println("All products by category:");
        manager.printAllProducts();

        System.out.println("Products in FOOD category:");
        List<Product> foodProducts = manager.findProductsByCategory(Category.FOOD);
        for (Product product : foodProducts) {
            System.out.println(product);
        }

        System.out.println("Remove 'Bread'from Category FOOD");
        manager.removeProduct(Category.FOOD, "Bread");

        manager.groupProductsByCategory();
        System.out.println("All products after remove:");
        manager.printAllProducts();
    }
}
