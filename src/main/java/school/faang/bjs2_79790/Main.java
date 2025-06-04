package school.faang.bjs2_79790;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(ProductCategory.FOOD, "Сосиска");
        productManager.addProduct(ProductCategory.CLOTHING, "Платье");
        productManager.addProduct(ProductCategory.FOOD, "Яйцо");
        productManager.addProduct(ProductCategory.CLOTHING, "Брюки");
        productManager.addProduct(ProductCategory.ELECTRONICS, "Ноутбук");
        productManager.addProduct(ProductCategory.ELECTRONICS, "Планшет");
        productManager.addProduct(ProductCategory.ELECTRONICS, "Смартфон");

        String productName = "Платье";
        boolean isAdded = productManager.addProduct(ProductCategory.CLOTHING, "Платье");
        log.info("Продукт '{}' добавлен? - {}", productName, isAdded);

        boolean isRemoved = productManager.removeProduct(ProductCategory.CLOTHING, "Платье");
        log.info("Продукт '{}' удален? - {}", productName, isRemoved);

        isAdded = productManager.addProduct(ProductCategory.CLOTHING, "Платье");
        log.info("Продукт '{}' добавлен? - {}", productName, isAdded);

        ProductCategory productCategory = ProductCategory.ELECTRONICS;
        List<Product> productsByCategory = productManager.findProductsByCategory(productCategory);
        log.info("Продукты категории '{}':\n{}", productCategory, productsByCategory);

        Map<ProductCategory, List<Product>> groupProducts = productManager.groupProductsByCategory();
        log.info("Продукты по категориям: {}", groupProducts);

        productManager.printAllProducts();
    }
}
