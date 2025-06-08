package school.faang.module1.bjs2_79853;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static school.faang.module1.bjs2_79853.Category.*;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        addProductWithLog(productManager, FOOD, "Творог");
        addProductWithLog(productManager, FOOD, "Сыр");
        addProductWithLog(productManager, FOOD, "Хлеб");

        addProductWithLog(productManager, ELECTRONICS, "Часы");
        addProductWithLog(productManager, ELECTRONICS, "Ноутбук");
        addProductWithLog(productManager, ELECTRONICS, "Телевизор");

        addProductWithLog(productManager, CLOTHING, "Футболка");
        addProductWithLog(productManager, CLOTHING, "Джинсы");
        addProductWithLog(productManager, CLOTHING, "Брюки");
        addProductWithLog(productManager, CLOTHING, "Брюки");

        productManager.printAllProducts();

        removeProductWithLog(productManager, FOOD, "Сыр");
        removeProductWithLog(productManager, FOOD, "Йогурт");

        productManager.printAllProducts();

        List<Product> productsByCategory = productManager.findProductsByCategory(ELECTRONICS);
        log.info("Продукты категории '{}':\n{}", ELECTRONICS, productsByCategory);

        Map<Category, List<Product>> groupProducts = productManager.groupProductsByCategory();
        log.info("Продукты по категориям: {}", groupProducts);
    }

    private static void addProductWithLog(ProductManager manager, Category category, String name) {
        boolean added = manager.addProduct(category, name);
        if (added) {
            log.info("Продукт '{}' успешно добавлен в категорию {}", name, category);
        } else {
            log.error("Не удалось добавить продукт '{}' в категорию {} — такой продукт уже существует", name, category);
        }
    }

    private static void removeProductWithLog(ProductManager manager, Category category, String name) {
        boolean removed = manager.removeProduct(category, name);
        if (removed) {
            log.info("Продукт '{}' успешно удалён из категории {}", name, category);
        } else {
            log.error("Не удалось удалить продукт '{}' из категории {} — такого продукта нет", name, category);
        }
    }
}