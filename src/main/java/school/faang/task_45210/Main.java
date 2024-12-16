package school.faang.task_45210;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product("Smartphone", "Electronics"));
        products.add(new Product("Gaming Laptop", "Electronics"));
        products.add(new Product("Refrigerator", "Home Appliances"));
        products.add(new Product("Office Chair", "Furniture"));
        products.add(new Product("Dining Table", "Furniture"));
        products.add(new Product("Microwave Oven", "Home Appliances"));

        ProductManager productManager = new ProductManager();

        logger.info("### Adding products:");
        productManager.addItem("Kitchenware", "Blender");
        productManager.addItem("Electronics", "Tablet");
        productManager.addItem("Electronics", "Phone");
        productManager.addItem("Garden", "Lawn Mower");
        productManager.addItem("Furniture", "Dining Table");
        
        logger.info("### Find products by category:");
        productManager.findItemsByCategory("Electronics");
        productManager.findItemsByCategory("Garden");

        logger.info("### Remove products:");
        productManager.removeItem("Electronics", "Tablet");
        productManager.removeItem("Furniture", "Dining Table");
        productManager.removeItem("Garden", "Lawn Mower");

        logger.info("### Print all products:");
        productManager.printProducts();

        logger.info("### Group products by category:");
        Map<String, List<Product>> productsByCategory = groupProductsByCategory(products);
        printProductsByCategory(productsByCategory);
    }

    protected static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("No products found");
        }

        Map<String, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }

        return productsByCategory;
    }

    protected static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            logger.info("{}: {}", entry.getKey(), entry.getValue().size());
            entry.getValue().forEach(product -> logger.info("\t{}", product.toString()));
        }
    }
}