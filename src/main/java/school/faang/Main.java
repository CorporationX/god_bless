package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Sausage");
        manager.addProduct(Category.FOOD, "Meat");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.CLOTHING, "Dress");

        System.out.println("All products:");
        manager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Sausage");

        System.out.println("\nProducts after removal:");
        manager.printAllProducts();

        System.out.println("\nProducts in FOOD category:");
        List<Product> foodProducts = manager.findProductsByCategory(Category.FOOD);
        for (Product product : foodProducts) {
            System.out.println(product);
        }
    }
}