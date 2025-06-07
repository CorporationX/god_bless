package school.faang.bjs279877;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int id = 0;

    private void add(Category category, String name) {
        Product product = new Product(id++, name, category);
        products.add(product);
        log.info("Продукт добавлен");
    }

    private boolean exitIfEmpty() {
        if (products.isEmpty()) {
            log.info("База данных пока пустая.");
            return true;
        }
        return false;
    }

    public void addProduct(Category category, String name) {
        if (name == null || name.isEmpty()) {
            log.warn("не можно использовать пустое имя или строку");
            return;
        }
        if (products.isEmpty()) {
            add(category, name);
        } else {
            for (Product product : products) {
                if (product.getName().equals(name) && product.getCategory().equals(category)) {
                    System.out.println("Товар с таким именем уже существует в категории " + category);
                    return;
                }
            }
            add(category, name);
        }
    }

    public void removeProduct(Category category, String name) {
        if (name == null || name.isEmpty()) {
            log.warn("не может быть пустого значения или строка");
            return;
        }
        if (exitIfEmpty()) {
            return;
        }
        for (Product product : products) {
            if (product.getName().equals(name)) {
                if (product.getCategory() == category) {
                    products.remove(product);
                    log.info("Продукст под именем {} удален из категории: {}", name, category);
                    return;
                }
            }
        }
        log.info("В категории {} такого товара и так нет", category);
    }

    public List<String> findProductsByCategory(Category category) {
        if (exitIfEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product.getName());
            }
        }
        log.info("Товара в этом каталоге пока нет.");
        return null;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        if (exitIfEmpty()) {
            return null;
        }

        Map<Category, List<Product>> result = new HashMap<>();
        for (Category category : Category.values()) {
            for (Product product : products) {
                result.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
            }
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> map;
        map = groupProductsByCategory();
        if (map == null) {
            return;
        }
        for (Map.Entry<Category, List<Product>> entry : map.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}
