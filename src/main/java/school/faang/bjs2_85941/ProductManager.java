package school.faang.bjs2_85941;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> productGroups = new HashMap<>();
    private static int id = 1;

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                log.warn("Продукт с таким именем уже существует в категории {}", category);
                return;
            }
        }

        Product product = new Product(id++, name, category);
        products.add(product);
        log.info("Добавлен продукт {}", product);
    }

    public void removeProduct(Category category, String name) {
        boolean isRemoved = products.removeIf(item ->
                item.getName().equals(name) && item.getCategory().equals(category));

        if (isRemoved) {
            log.info("Продукт {} {} удален", category, name);
        } else {
            log.warn("Продукт {} {} не найден", category, name);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsList = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsList.add(product);
            }
        }

        return productsList;
    }

    private Map<Category, List<Product>> groupProductsByCategory() {
        for (Product product : products) {
            productGroups.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return productGroups;
    }


    public void printAllProducts() {
        Map<Category, List<Product>> productGroups = groupProductsByCategory();

        productGroups.forEach((category, productList) -> {
            log.info("Категория: {}", category);
            log.info("Продукты:");
            productList.forEach(product -> log.info(" - {}", product.getName()));
        });
    }
}
