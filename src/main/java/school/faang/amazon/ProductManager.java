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
        boolean resultOfAdd = products.add(new Product(name, category));

        if (resultOfAdd) {
            log.info("Продукт {} по категории {} был добавлен", name, category);
        } else {
            log.info("Продукт {} по категории {} уже есть в списке", name, category);
        }
    }

    public void removeProduct(Category category, String name) {
        boolean resultOfRemoval = products.remove(new Product(name, category));

        if (resultOfRemoval) {
            log.info("Продукт {} по категории {} был удален", name, category);
        } else {
            log.info("Продукта {} по категории {} не было в списке", name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory() == category) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsByCategory.get(product.getCategory()).add(product);
        }

        return productsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> categoryListEntry : productsByCategory.entrySet()) {
            log.info("Категория: {}", categoryListEntry.getKey());
            log.info("Продукты:");
            for (Product product : categoryListEntry.getValue()) {
                log.info("- {}", product.getName());
            }
        }
    }
}
