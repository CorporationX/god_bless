package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        try {
            productManager.addProduct(Category.FOOD, "Apple");
            productManager.addProduct(Category.FOOD, "Bread");
            productManager.addProduct(Category.FOOD, "Orange");

            productManager.addProduct(Category.CLOTHING, "T-Shirt");

            productManager.addProduct(Category.ELECTRONICS, "IPhone");
            productManager.addProduct(Category.ELECTRONICS, "TV");
            productManager.addProduct(Category.ELECTRONICS, "Xbox");

            productManager.addProduct(Category.OTHER, "Whiteboard");
            System.out.println(productManager.removeProduct(Category.FOOD, "Bread"));

            productManager.printAllProducts();
            productManager.groupProductsByCategory();
            System.out.println(productManager.findProductsByCategory(Category.FOOD));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }

    }
}