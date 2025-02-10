package school.faang.task_57069;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    public void addProduct(@NonNull String name, @NonNull Category category) {
        for (Product product : products) {
            if (product.isThisProduct(name, category)) {
                logger.warn("Продукт \"{}\" с таким названием уже существует в категории \"{}\".",
                        product.getName(), product.getCategory());
                return;
            }
        }
        Product product = new Product(name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, key -> new ArrayList<>()).add(product);
        logger.info("Продукт \"{}\" добавлен в категорию \"{}\".", product.getName(), product.getCategory());
    }

    public void removeProduct(@NonNull String name, @NonNull Category category) {
        List<Product> products = categoryMap.get(category);
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.isThisProduct(name, category)) {
                this.products.remove(product);
                iterator.remove();
                logger.info("\"{}\" удалён.", product);
            }
        }
        categoryMap.replace(category, products);
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return categoryMap;
    }

    public void printAllProducts() {
        Set<Category> categories = categoryMap.keySet();
        for (Category category : categories) {
            System.out.printf("Категория: %s\nПродукты:\n", category);
            categoryMap.get(category).forEach(product -> System.out.printf("- %s\n", product.getName()));
            System.out.println();
        }
    }
}
