package school.faang.amazonwarehouse;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "apple");
        productManager.addProduct(Category.FOOD, "chicken");
        productManager.addProduct(Category.FOOD, "beer");
        productManager.addProduct(Category.FOOD, "bread");

        productManager.addProduct(Category.ELECTRONICS, "smartphone");
        productManager.addProduct(Category.ELECTRONICS, "laptop");
        productManager.addProduct(Category.ELECTRONICS, "hairdryer");
        productManager.addProduct(Category.ELECTRONICS, "vacuum cleaner");

        productManager.addProduct(Category.CLOTHING, "jacket");
        productManager.addProduct(Category.CLOTHING, "boots");
        productManager.addProduct(Category.CLOTHING, "shirt");
        productManager.addProduct(Category.CLOTHING, "pants");

        productManager.addProduct(Category.OTHER, "toothpaste");
        productManager.addProduct(Category.OTHER, "wheel");
        productManager.addProduct(Category.OTHER, "brick");
        productManager.addProduct(Category.OTHER, "pliers");

        productManager.printAllProducts();

        productManager.findProductsByCategory(Category.FOOD)
                .forEach(p -> System.out.println(p.getName()));

        productManager.removeProduct(Category.ELECTRONICS, "vacuum cleaner");
        productManager.findProductsByCategory(Category.ELECTRONICS)
                .forEach(p -> System.out.println(p.getName()));

        productManager.printAllProducts();

    }
}
