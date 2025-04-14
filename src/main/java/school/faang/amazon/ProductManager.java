package school.faang.amazon;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Data
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        boolean resultOfAdd = products.add(new Product(IdGenerator.idCounterUp(), name, category));

        if (resultOfAdd) {
            log.info("Продукт {} по категории {} был добавлен", name, category);
        } else {
            log.info("Продукт {} по категории {} уже есть в списке", name, category);
        }
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));
        log.info("Продукты {} по категории {} были удалены", name, category);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();

        products.forEach(product -> {
            if (product.getCategory() == category) {
                productsByCategory.add(product);
            }
        });

        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        products.forEach(product -> {
            productsByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsByCategory.get(product.getCategory()).add(product);
        });
        return productsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();
        productsByCategory.forEach((category, products) -> {
            log.info("Категория: {}", category);
            log.info("Продукты:");
            products.forEach(product -> log.info("- {}", product.getName()));
        });
    }
}
