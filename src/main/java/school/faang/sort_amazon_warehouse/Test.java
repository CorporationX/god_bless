package school.faang.sort_amazon_warehouse;

import static school.faang.sort_amazon_warehouse.Category.ELECTRONICS;
import static school.faang.sort_amazon_warehouse.Category.FOOD;

public class Test {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        
        productManager.addProduct(FOOD, "Apple");
        productManager.addProduct(FOOD, "Bread");
        productManager.addProduct(ELECTRONICS, "Laptop");
        productManager.addProduct(ELECTRONICS, "Smartphone");

        productManager.printAllProducts();

        delimiter();

        System.out.println(productManager.findProductsByCategory(FOOD));

        delimiter();

        productManager.removeProduct(FOOD, "Apple");

        productManager.printAllProducts();
    }

    private static void delimiter() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
    }
}
