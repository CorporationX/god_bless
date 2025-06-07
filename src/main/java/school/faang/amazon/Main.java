package school.faang.amazon;

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
        var productManager = new ProductManager();
        addProducts(productManager);
        removeProducts(productManager);
        findProducts(productManager);
        productManager.printAllProducts();
    }

    private static void addProducts(ProductManager productManager) {
        productManager.addProduct(CLOTHING, "Рубашка");
        productManager.addProduct(CLOTHING, TROUSERS);
        productManager.addProduct(CLOTHING, "Джинсы");
        productManager.addProduct(FOOD, "Банан");
        productManager.addProduct(FOOD, "Авокадо");
        productManager.addProduct(FOOD, BROCCOLI);
        productManager.addProduct(ELECTRONICS, "Samsung Galaxy S24");
        productManager.addProduct(ELECTRONICS, "iPhone 12");
        productManager.addProduct(ELECTRONICS, "Samsung Galaxy Book 4");
        productManager.addProduct(OTHER, FLAT_KEYS);
    }

    private static void removeProducts(ProductManager productManager) {
        productManager.removeProduct(OTHER, FLAT_KEYS);
        productManager.removeProduct(FOOD, BROCCOLI);
        productManager.removeProduct(CLOTHING, TROUSERS);
        System.out.println();
    }

    private static void findProducts(ProductManager productManager) {
        var productsByCategory = productManager.findProductsByCategory(ELECTRONICS);
        System.out.println(productsByCategory);
        System.out.println();
    }
}
