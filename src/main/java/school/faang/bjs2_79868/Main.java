package school.faang.bjs2_79868;

import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_79868.Category.CLOTHING;
import static school.faang.bjs2_79868.Category.ELECTRONICS;
import static school.faang.bjs2_79868.Category.FOOD;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(ELECTRONICS, "Smartphone");
        productManager.addProduct(ELECTRONICS, "Laptop");
        productManager.addProduct(FOOD, "Apple");
        productManager.addProduct(FOOD, "Bread");

        productManager.addProduct(CLOTHING, "T-shirt");
        log.info("{}", productManager);

        productManager.removeProduct(CLOTHING, "T-shirt");
        log.info("{}", productManager);

        log.info("{}", productManager.findProductsByCategory(ELECTRONICS));
        log.info("{}", productManager.findProductsByCategory(CLOTHING));

        log.info("{}", productManager.groupProductsByCategory());
        productManager.printAllProducts();
    }
}
