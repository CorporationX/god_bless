package school.faang.amazonstorage;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.ELECTRONICS, "iPhone");
        productManager.addProduct(Category.ELECTRONICS, "MacBook");
        productManager.addProduct(Category.ELECTRONICS, "iPad");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.FOOD, "Orange");

        productManager.removeProduct(Category.FOOD, "Orange");
        productManager.removeProduct(Category.ELECTRONICS, "iPad");

        List<Product> products = productManager.findProductsByCategory(Category.ELECTRONICS);
        if (!products.isEmpty()) {
            products.forEach(System.out::println);
        }

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
