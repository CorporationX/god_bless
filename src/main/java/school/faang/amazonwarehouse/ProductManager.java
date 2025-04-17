package school.faang.amazonwarehouse;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private static int generateId = 1;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory() == category) {
                log.info("Товар с таким именем уже существует в категории {}", category);
                return;
            }
        }
        int id = getGenerate();
        Product product = new Product(id, name, category);
        products.add(product);
        log.info("Продукт: '{}', категория: '{}' успешно добавлен", name, category);
    }

    private static int getGenerate() {
        return generateId++;
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> findProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                findProduct.add(product);
                log.info("Поиск по категории. Найден продукт: '{}'", product.getName());
            }
        }

        if (findProduct.isEmpty()) {
            log.info("Ничего не найдено в категории '{}'", category);
        } else {
            log.info("Всего Найдено: '{}' ед.", findProduct.size());
        }
        return findProduct;
    }

    public Map<Category, List<Product>> productsByCategory() {
        Map<Category, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            groupProducts.computeIfAbsent(category, newKey -> new ArrayList<>()).add(product);
        }
        return groupProducts;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = productsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            log.info("Категория: '{}'", entry.getKey());
            log.info("Продукты:");
            for (Product product : entry.getValue()) {
                log.info("- '{}'", product.getName());
            }
        }
    }
}
