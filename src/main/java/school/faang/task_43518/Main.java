package school.faang.task_43518;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static final HashSet<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        Product product1 = new Product(1, "Apple iPhone 14", "Electronics");
        Product product2 = new Product(2, "Samsung Galaxy S23", "Electronics");
        Product product3 = new Product(3, "Herman Miller Aeron Chair", "Furniture");


        PRODUCTS.add(product1);
        PRODUCTS.add(product2);
        PRODUCTS.add(product3);

        ProductManager productManager = new ProductManager(PRODUCTS);

        productManager.addItem("Fashion", "Fjällräven Kånken Backpack");
        productManager.printAllItems();
        System.out.println();

        productManager.removeItem("Furniture", "Herman Miller Aeron Chair");
        productManager.printAllItems();
        System.out.println();

        productManager.findItemsByCategory("Electronics");
        System.out.println();

        HashMap<String, List<Product>> gropedProducts = ProductManager.groupProductsByCategory(PRODUCTS);
        ProductManager.printProductsByCategory(gropedProducts);
    }
}
