package school.faang.task_43518;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
public class ProductManager implements ProductManagement {
    private static final HashMap<String, List<Product>> PRODUCTS_MAP = new HashMap<>();
    private long id = 0;

    public ProductManager(HashSet<Product> products) {
        for (Product product : products) {
            if (id < product.getId()) {
                id = product.getId();
            }
            PRODUCTS_MAP.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<>()).add(product);
        }
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ": ");
            products.forEach(product -> System.out.println("   " + product));
        });
    }

    @Override
    public void addItem(String category, String name) {
        Product product = new Product(++id, name, category);
        PRODUCTS_MAP.computeIfAbsent(product.getCategory(),
                k -> new ArrayList<>()).add(product);
    }

    @Override
    public void removeItem(String category, String name) {
        Product product = new Product(id, name, category);
        if (PRODUCTS_MAP.containsKey(category)) {
            PRODUCTS_MAP.get(category).remove(product);
        } else {
            log.info("The category {} does not exist", category);
        }
    }

    @Override
    public void findItemsByCategory(String category) {
        if (PRODUCTS_MAP.containsKey(category)) {
            System.out.println(category + ": ");
            PRODUCTS_MAP.get(category)
                    .forEach(product -> System.out.println("   " + product));
        } else {
            log.info("The category {} does not exist", category);
        }
    }

    @Override
    public void printAllItems() {
        PRODUCTS_MAP.values().forEach(products -> products.forEach(System.out::println));
    }


}
