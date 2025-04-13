package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.CLOTHING, "Coat");
        productManager.addProduct(Category.OTHER, "Paper");
        productManager.addProduct(Category.OTHER, "Pen");
        productManager.addProduct(Category.OTHER, "Pen");

        productManager.printAllProducts();

        productManager.removeProduct(Category.OTHER, "Pen");
        productManager.removeProduct(Category.OTHER, "Pen");
        productManager.removeProduct(Category.FOOD, "Apple");

        productManager.printAllProducts();

        log.info(productManager.findProductsByCategory(Category.ELECTRONICS).toString());
    }
}
