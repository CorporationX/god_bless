package school.faang.amazon;

import java.util.List;

import static school.faang.amazon.Category.CLOTHING;
import static school.faang.amazon.Category.ELECTRONICS;
import static school.faang.amazon.Category.FOOD;
import static school.faang.amazon.Category.OTHER;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static final String FLAT_KEYS = "Ключи от квартиры";
    public static final String BROCCOLI = "Брокколи";
    public static final String TROUSERS = "Брюки";

    public static void main(String[] args) {
        addProducts();
        removeProducts();
        findProducts();
        ProductManager.printAllProducts();
    }

    private static void addProducts() {
        ProductManager.addProduct(CLOTHING, "Рубашка");
        ProductManager.addProduct(CLOTHING, TROUSERS);
        ProductManager.addProduct(CLOTHING, "Джинсы");
        ProductManager.addProduct(FOOD, "Банан");
        ProductManager.addProduct(FOOD, "Авокадо");
        ProductManager.addProduct(FOOD, BROCCOLI);
        ProductManager.addProduct(ELECTRONICS, "Samsung Galaxy S24");
        ProductManager.addProduct(ELECTRONICS, "iPhone 12");
        ProductManager.addProduct(ELECTRONICS, "Samsung Galaxy Book 4");
        ProductManager.addProduct(OTHER, FLAT_KEYS);
    }

    private static void removeProducts() {
        ProductManager.removeProduct(OTHER, FLAT_KEYS);
        ProductManager.removeProduct(FOOD, BROCCOLI);
        ProductManager.removeProduct(CLOTHING, TROUSERS);
        System.out.println();
    }

    private static void findProducts() {
        var productsByCategory = ProductManager.findProductsByCategory(ELECTRONICS);
        System.out.println(productsByCategory);
        System.out.println();
    }
}
