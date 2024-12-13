package school.faang.task_43518;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Getter
@Slf4j
@NoArgsConstructor
public class ProductManager implements ProductManageable {
    private final Map<Category, List<Product>> productsMap = new HashMap<>();

    @Override
    public void addItem(Category category, String name) {
        Product product = new Product(name, category);
        List<Product> productsList = productsMap
                .computeIfAbsent(category, k -> new ArrayList<>());
        productsList.add(product);
    }

    @Override
    public void removeItem(Category category, String name) throws NoSuchElementException {
        List<Product> products = getProductsByCategory(category);
        boolean removed = products.removeIf((p) ->
                Objects.equals(p.getName(), name));

        if (!removed) {
            String message = "Product not found: " + name;
            log.error(message);
            throw new NoSuchElementException(message);
        }
    }

    @Override
    public void findItemsByCategory(Category category) throws NoSuchElementException {
        List<Product> products = getProductsByCategory(category);
        printAllItemsByCategory(category, products);
    }

    @Override
    public void printAllItems() {
        productsMap.forEach(this::printAllItemsByCategory);
    }

    public Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Category, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            List<Product> productList = groupedProducts
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            productList.add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<Category, List<Product>> groupedProducts) {
        List<Category> categories = groupedProducts.keySet()
                .stream()
                .sorted(Comparator.comparing(Enum::name))
                .toList();
        categories.forEach(category ->
                printAllItemsByCategory(category, groupedProducts.get(category)));
    }

    private void printAllItemsByCategory(Category category, List<Product> products) {
        System.out.println(category + ": ");
        products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(product -> System.out.println("\t" + product));
    }

    private List<Product> getProductsByCategory(Category category) throws NoSuchElementException {
        return Optional.ofNullable(productsMap.get(category))
                .orElseThrow(() -> {
                    String message = "Category not found: " + category;
                    log.error(message);
                    return new NoSuchElementException(message);
                });
    }
}

