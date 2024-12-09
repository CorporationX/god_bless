package school.faang.bjs_45147;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.bjs_45147.enums.Category;
import school.faang.bjs_45147.exception.CategoryNotFoundException;
import school.faang.bjs_45147.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@NoArgsConstructor
public class Store {
    private final Set<Product> products = new HashSet<>();
    private final Map<String, List<Product>> groupedProducts = new HashMap<>();
    private final Set<Category> categories = new HashSet<>();

    public void addItem(String category, String name) {
        validateProductParameters(category, name);

        if (!containsProduct(name, category)) {
            Category productsCategory = Category.valueOfName(category);
            Product product = new Product(name, productsCategory);
            products.add(product);
            categories.add(productsCategory);
            addInGroupedProducts(product);
        }
    }

    public void removeItem(String category, String name) throws ProductNotFoundException {
        validateProductParameters(category, name);
        Product product = findProduct(name, category);
        products.remove(product);
        removeFromGroupedProducts(product);
    }

    public Set<Product> findItemsByCategory(String category) throws CategoryNotFoundException {
        List<Product> productsByCategory = groupedProducts.get(category);

        return Set.copyOf(productsByCategory);
    }

    public void printAllItems() {
        groupedProducts.forEach((key, values) -> {
            List<String> productNames = new ArrayList<>();
            values.forEach(product -> productNames.add(product.getName()));
            log.info(key + ":" + productNames);
        });
    }

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            String category = product.getCategory().getName();
            List<Product> productsByCategory = groupedProducts.computeIfAbsent(category, k -> new ArrayList<>());

            productsByCategory.add(product);
        });

        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.entrySet()
                .forEach(entry -> log.info(entry.toString()));
    }

    private void validateProductParameters(String category, String name) {
        if (category == null || category.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsProduct(String name, String category) {
        return products.stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name)
                && product.getCategory().getName().equalsIgnoreCase(category));
    }

    private Product findProduct(String name, String category) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name)
                && product.getCategory().getName().equalsIgnoreCase(category))
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }


    private void addInGroupedProducts(Product product) {
        groupedProducts.putIfAbsent(product.getCategory().getName(), new ArrayList<>());

        List<Product> productByCategory = groupedProducts.get(product.getCategory().getName());
        if (!isProductIdInList(product.getId(), productByCategory)) {
            productByCategory.add(product);
        }
    }

    private void removeFromGroupedProducts(Product product) {
        List<Product> productByCategory = groupedProducts.get(product.getCategory().getName());
        productByCategory.remove(product);
    }

    private boolean isProductIdInList(int id, List<Product> products) {
        return products.stream()
                .anyMatch(product -> Integer.valueOf(product.getId()).equals(id));
    }
}
