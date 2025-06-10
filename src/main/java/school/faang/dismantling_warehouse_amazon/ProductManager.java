package school.faang.dismantling_warehouse_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        Product productRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productRemove = product;
            }
        }
        if (productRemove != null) {
            products.remove(productRemove);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(),
                    key -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> categoryListMap = groupProductsByCategory();
        for (Category category : Category.values()) {
            if (!categoryListMap.containsKey(category)) {
                continue;
            }
            System.out.printf("Категория: %s\nПродукты:\n %s", category, categoryListMap
                    .computeIfAbsent(category, key -> new ArrayList<>()));
            System.out.println();
        }
    }
}