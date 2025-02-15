package school.faang.AmazonWarehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Tomato");
        manager.addProduct(Category.FOOD, "Milk");
        manager.addProduct(Category.ELECTRONICS, "PC");
        manager.addProduct(Category.ELECTRONICS, "Smartwatch");
        manager.addProduct(Category.CLOTHING, "Hat");
        manager.addProduct(Category.OTHER, "Pen");

        System.out.println("Added products:");
        manager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Milk");

        System.out.println("Products after removing:");
        manager.printAllProducts();

        System.out.println("Products at category 'CLOTHING':");
        List<Product> clothing = manager.findProductsByCategory(Category.CLOTHING);
        for (Product product : clothing) {
            System.out.println(product.getName());
        }

        System.out.println();
        manager.groupProductsByCategory();

        System.out.println("Grouped products:");
        manager.printAllProducts();
    }
}