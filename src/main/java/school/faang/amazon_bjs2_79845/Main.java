package school.faang.amazon_bjs2_79845;

import static school.faang.amazon_bjs2_79845.Product.Category.FOOD;
import static school.faang.amazon_bjs2_79845.Product.Category.ELECTRONICS;
import static school.faang.amazon_bjs2_79845.Product.Category.CLOTHING;
import static school.faang.amazon_bjs2_79845.Product.Category.OTHER;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();

        pm.addProduct(FOOD, "Apple");
        pm.addProduct(FOOD, "Meat");
        pm.addProduct(FOOD, "Fish");
        pm.addProduct(FOOD, "Banana");

        pm.printAllProducts();

        pm.addProduct(ELECTRONICS, "Phone");
        pm.addProduct(ELECTRONICS, "Laptop");

        pm.addProduct(CLOTHING, "Hat");
        pm.addProduct(CLOTHING, "T-Shirt");
        pm.addProduct(CLOTHING, "Jeans");

        pm.addProduct(OTHER, "Car");

        pm.findProductsByCategory(ELECTRONICS);

        pm.removeProduct(FOOD, "Apple");

        pm.groupProductsByCategory();
    }
}