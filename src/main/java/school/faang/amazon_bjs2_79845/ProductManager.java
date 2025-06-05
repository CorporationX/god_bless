package school.faang.amazon_bjs2_79845;

import jdk.jfr.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductManager {
    Set<Product> products = new HashSet<>();
    private int nextId = 1;
    private final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    public int generateId() {
        return nextId++;
    }

    public int getIdByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product.getId();
            }
        }
        return 0;
    }

    public void addProduct(Product.Category category, String name) {
        int id = generateId();
        Product productToAdd = new Product(id, name, category);
        if (category != null && !name.isBlank()) {
            logger.info("Продукт успешно добавлен");
            products.add(productToAdd);
        } else {
            logger.warn("Продукт или его имя не может быть null\n");
        }
    }

    public void removeProduct(Product.Category category, String name) {
        int id = getIdByName(name);
        if (id != 0) {
            Product productToRemove = new Product(id, name, category);
            products.remove(productToRemove);
            logger.info("Продукт {} удален", name);
        } else {
            logger.warn("Продукт {} не найден\n", name);
        }
    }

    public List<Product> findProductsByCategory(Product.Category category) {
        List<Product> productsInOneCategory = new ArrayList<>();

        System.out.printf("Категория: %s\n", category);
        System.out.printf("Продукты:\n");
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsInOneCategory.add(product);
                System.out.printf("- %s\n", product.getName());
            }
        }
        return productsInOneCategory;
    }

    public void groupProductsByCategory() {
        findProductsByCategory(Product.Category.FOOD);
        findProductsByCategory(Product.Category.ELECTRONICS);
        findProductsByCategory(Product.Category.CLOTHING);
        findProductsByCategory(Product.Category.OTHER);
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.printf("Элемент: %s\n", product);
        }
    }
}
