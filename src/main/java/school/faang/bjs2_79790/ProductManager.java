package school.faang.bjs2_79790;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public boolean addProduct(Category category, String name) {
        return products.add(new Product(name, category));
    }

    public boolean removeProduct(Category category, String name) {
        return products.remove(new Product(name, category));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), (category) -> new ArrayList<>()).add(product);
        }

        return productsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();

        for (var entrySet : productsByCategory.entrySet()) {
            log.info("Категория: {}", entrySet.getKey());
            log.info("Продукты:");

            for (Product product : entrySet.getValue()) {
                log.info("- {}", product.getName());
            }
        }
    }
}
