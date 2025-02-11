package school.faang.task57094.warehouse;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ProductManager.class);
    private int counter = 0;

    public void addProduct(@NonNull Category category, @NonNull String name) {
        logger.info("Добавление продукта: {} - {}", category, name);
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                logger.warn("Продукт с категорией {} и именем \"{}\" уже были добавлены.", category, name);
                return;
            }
        }
        counter++;
        Product product = new Product(counter, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        List<Product> categoryList = categoryMap.get(category);
        categoryList.add(product);
        logger.info("Продукт добавлен");
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        logger.info("Удаление продукта: {} - {}", category, name);
        products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
        List<Product> categoryList = categoryMap.get(category);
        if (categoryList != null) {
            categoryList.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
            logger.info("Продукт удалён: {} - {}", category, name);
            return;
        }
        logger.warn("В категории {} пусто", category);
    }

    public List<Product> findProductByCategory(@NonNull Category category) {
        logger.info("Поиск продуктов по категории {}", category);
        if (!categoryMap.isEmpty() && categoryMap.get(category) != null) {
            return categoryMap.get(category);
        } else {
            logger.warn("Категория {} внутри categoryMap не была найдена", category);
        }
        return new ArrayList<>();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        logger.info("Группировка продуктов по категориям");
        if (!categoryMap.isEmpty()) {
            return categoryMap;
        } else {
            logger.warn("categoryMap пуст");
        }
        return categoryMap;
    }

    public void printAllProducts() {
        logger.info("Печать всех продуктов");
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.printf("Категория: %s\nПродукты:\n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();
        }
    }
}
