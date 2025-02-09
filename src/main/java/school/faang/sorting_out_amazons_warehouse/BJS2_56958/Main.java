package school.faang.sorting_out_amazons_warehouse.BJS2_56958;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        LOGGER.info("Creating {}", manager);

        manager.addProduct(Category.ELECTRONICS, "Headphones");
        manager.addProduct(Category.ELECTRONICS, "Player");
        manager.addProduct(Category.ELECTRONICS, "Hairdryer");
        manager.addProduct(Category.FOOD, "Ice cream");
        manager.addProduct(Category.FOOD, "Crackers");
        manager.addProduct(Category.FOOD, "Cutlets");
        manager.addProduct(Category.FOOD, "Cream");
        manager.addProduct(Category.CLOTHING, "T-shirt");
        manager.addProduct(Category.CLOTHING, "shorts");
        manager.addProduct(Category.OTHER, "Robot");
        LOGGER.info("Creating product {}", manager);

        manager.printAllProducts();
        LOGGER.info("Printing all products");

        manager.removeProduct(Category.FOOD, "Crackers");
        LOGGER.info("Removing product {}", manager);

        manager.printAllProducts();
        LOGGER.info("Printing all products");

        System.out.println(manager.findProductsByCategory(Category.ELECTRONICS));
        LOGGER.info("Returns a list of all products and prints them");

        manager.groupProductsByCategory();
        LOGGER.info("Updating the grouping of products by category");
        manager.printAllProducts();
        LOGGER.info("Printing all products");

    }
}
