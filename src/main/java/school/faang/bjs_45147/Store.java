package school.faang.bjs_45147;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.bjs_45147.exception.CategoryNotFoundException;
import school.faang.bjs_45147.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor
public class Store {
    private final Set<Product> products = new HashSet<>();
    private final Map<String, List<Product>> groupedProducts = new HashMap<>();
    private final Set<String> categories = new HashSet<>();

    public void addItem(String category, String name) {
        validateProductParameters(category, name);

        if (!isProductByNameAndCategory(name, category)) {
            Product product = new Product(name, category);
            products.add(product);
            categories.add(category);
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
        if (!categories.contains(category)) {
            throw new CategoryNotFoundException();
        }

        return products.stream().filter(product -> {
            if (product.getCategory() != null) {
                return product.getCategory().equals(category);
            }

            return false;
        }).collect(Collectors.toUnmodifiableSet());
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
            String category = product.getCategory();
            List<Product> productsByCategory = groupedProducts.computeIfAbsent(category, k -> new ArrayList<>());

            productsByCategory.add(product);
        });

        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.entrySet().forEach(entry -> log.info(entry.toString()));
    }

    private void validateProductParameters(String category, String name) {
        if (category == null || category.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isProductByNameAndCategory(String name, String category) {
        return products.stream().anyMatch(product -> checkProductName(product, name)
                && checkProductCategory(product, category));
    }

    private Product findProduct(String name, String category) {
        return products.stream().filter(product -> checkProductName(product, name)
                && checkProductCategory(product, category)).findFirst().orElseThrow(ProductNotFoundException::new);
    }

    private boolean checkProductName(Product product, String name) {
        return product.getName().equalsIgnoreCase(name);
    }

    private boolean checkProductCategory(Product product, String category) {
        return product.getCategory().equalsIgnoreCase(category);
    }

    private void addInGroupedProducts(Product product) {
        if (!groupedProducts.containsKey(product.getCategory())) {
            groupedProducts.put(product.getCategory(), new ArrayList<>());
        }

        List<Product> productByCategory = groupedProducts.get(product.getCategory());
        if (!isProductIdInList(product.getId(), productByCategory)) {
            productByCategory.add(product);
        }
    }

    private void removeFromGroupedProducts(Product product) {
        List<Product> productByCategory = groupedProducts.get(product.getCategory());
        productByCategory.remove(product);
    }

    private boolean isProductIdInList(int id, List<Product> products) {
        return products.stream().anyMatch(product -> product.getId() == id);
    }
}
