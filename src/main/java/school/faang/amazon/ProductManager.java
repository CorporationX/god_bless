package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    Product productToRemove;
    private final Set<Product> products = new HashSet<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        int id = currentId++;
        products.add(new Product(id, name, category));
        log.info("Продукт {} добавлен в категорию {} по следующим id: {}", name, category, id);
    }

    public void removeProduct(Category category, String name) {
        productToRemove = null;
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null && products.remove(productToRemove)) {
            log.info("Продукт {} удален из категории {}", productToRemove.getName(), category);
        } else {
            log.info("Продукт {} не найден в категории {}", name, category);
        }
    }

    public void findProductsByCategory(Category category) {
        int foundCount = 0;
        System.out.println("В категории: " + category);
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println("найден продукт " + product.getName());
                foundCount++;
            }
        }
        if (foundCount == 0) {
            System.out.println(" продукты отсутствуют");
        }
    }

    private Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.putIfAbsent(product.getCategory(), new ArrayList<>());
            groupedProducts.get(product.getCategory()).add(product);
        }
        return groupedProducts;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        System.out.println("Перечень всех продуктов:");
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product.getName());
            }
        }
    }
}


