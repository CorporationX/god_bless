package bjs256951;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        generateTestData();
    }

    private static void generateTestData() {
        ProductManager productManager = new ProductManager();
        Set<Product> products = productManager.getProducts();
        Map<Category, List<Product>> categoryMap = productManager.getCategoryMap();

        logger.info("Size of product`s list before adding products: {}", products.size());
        logger.info("Size of categoryMap before adding products: {}", categoryMap.size());
        productManager.addProduct(Category.FOOD, "Meat");
        productManager.addProduct(Category.FOOD, "Fish");
        productManager.addProduct(Category.ELECTRONICS, "Iphone");
        productManager.addProduct(Category.ELECTRONICS, "Notebook");
        productManager.addProduct(Category.CLOTHING, "Cap");
        productManager.addProduct(Category.CLOTHING, "Jacket");
        productManager.addProduct(Category.OTHER, "Drill");
        productManager.addProduct(Category.OTHER, "Wardrobe");
        logger.info("Size of product`s list after adding products: {}", products.size());
        logger.info("Size of categoryMap after adding products: {}", categoryMap.size());

        logger.info("Size of product`s list before removing product: {}", products.size());
        logger.info("Numbers of products in categoryMap before removing product: {}",
                (long) categoryMap.values().size());
        productManager.removeProduct(Category.FOOD, "Meat");
        boolean exists = products.stream()
                .anyMatch(p -> Category.FOOD.equals(p.getCategory()) && "Meat".equals(p.getName()));
        if (exists) {
            logger.error("Product with category: {} and name: {} exists", Category.FOOD, "Meat");
        }
        logger.info("Size of product`s list after removing product: {}", products.size());
        logger.info("Numbers of products in categoryMap after removing product: {}",
                (long) categoryMap.values().size());

        List<Product> productsByCategory = productManager.findProductsByCategory(Category.ELECTRONICS);
        logger.info("Numbers of found products in Category.ELECTRONICS: {}", productsByCategory);

        productManager.printAllProducts();
    }
}
