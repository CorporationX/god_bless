package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        productManager.addProduct(Category.CLOTHING, "socks");
        productManager.addProduct(Category.CLOTHING, "shorts");
        productManager.addProduct(Category.CLOTHING, "t-short");
        productManager.addProduct(Category.FOOD, "chips");
        productManager.addProduct(Category.FOOD, "potato");
        productManager.addProduct(Category.ELECTRONICS, "telephone");

        System.out.println();
        productManager.printAllProducts();
        System.out.println();

        productManager.removeProduct(Category.ELECTRONICS, "chips");
        productManager.removeProduct(Category.FOOD, "chips");
        productManager.removeProduct(Category.FOOD, "chips");

        System.out.println();
        productManager.printAllProducts();
        System.out.println();

        log.info("Found products by Category.FOOD: {}", productManager.findProductsByCategory(Category.FOOD));
    }
}