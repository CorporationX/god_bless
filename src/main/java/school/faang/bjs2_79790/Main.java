package school.faang.bjs2_79790;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Сосиска");
        productManager.addProduct(Category.CLOTHING, "Платье");
        productManager.addProduct(Category.FOOD, "Яйцо");
        productManager.addProduct(Category.CLOTHING, "Брюки");
        productManager.addProduct(Category.ELECTRONICS, "Ноутбук");
        productManager.addProduct(Category.ELECTRONICS, "Планшет");
        productManager.addProduct(Category.ELECTRONICS, "Смартфон");

        String productName = "Платье";
        boolean isAdded = productManager.addProduct(Category.CLOTHING, "Платье");
        log.info("Продукт '{}' добавлен? - {}", productName, isAdded);

        boolean isRemoved = productManager.removeProduct(Category.CLOTHING, "Платье");
        log.info("Продукт '{}' удален? - {}", productName, isRemoved);

        isAdded = productManager.addProduct(Category.CLOTHING, "Платье");
        log.info("Продукт '{}' добавлен? - {}", productName, isAdded);

        Category category = Category.ELECTRONICS;
        List<Product> productsByCategory = productManager.findProductsByCategory(category);
        log.info("Продукты категории '{}':\n{}", category, productsByCategory);

        Map<Category, List<Product>> groupProducts = productManager.groupProductsByCategory();
        log.info("Продукты по категориям: {}", groupProducts);

        productManager.printAllProducts();

    }
}
