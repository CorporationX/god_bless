package school.faang.sprint.first.amazon.manager;

import lombok.NonNull;
import school.faang.sprint.first.amazon.model.Category;
import school.faang.sprint.first.amazon.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {
    private static final AtomicInteger ID_COUNT = new AtomicInteger(1);
    private final Set<Product> allProducts = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product productForAdd = new Product(ID_COUNT.getAndIncrement(), name, category);
        allProducts.add(productForAdd);
        categoryMap.computeIfAbsent(category, products -> new ArrayList<>()).add(productForAdd);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        findProductsByCategory(category).stream()
                .filter(product -> product.getName().equals(name))
                .findAny().ifPresent(productForRemove -> {
                    allProducts.remove(productForRemove);

                    List<Product> productsForCategory = categoryMap.get(category);
                    if (productsForCategory != null) {
                        productsForCategory.remove(productForRemove);
                    }
                });
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        List<Product> productList = categoryMap.getOrDefault(category, new ArrayList<>());
        productList.retainAll(allProducts);

        return productList;
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> tempMap = new HashMap<>();
        for (var product : allProducts) {
            tempMap.computeIfAbsent(product.getCategory(), products -> new ArrayList<>()).add(product);
        }

        categoryMap = tempMap;
    }

    public void printAllProducts() {
        StringBuilder stringBuilder = new StringBuilder();

        if (categoryMap.isEmpty()) {
            System.out.println("Пока тут пусто");
            return;
        }

        for (var entry : categoryMap.entrySet()) {
            stringBuilder
                    .append("Категория: ")
                    .append(entry.getKey())
                    .append("\r\n")
                    .append("Продукты: ")
                    .append("\r\n");

            for (var product : entry.getValue()) {
                stringBuilder
                        .append("- ")
                        .append(product.getName())
                        .append("\r\n");
            }

            stringBuilder.append("\r\n");
        }

        System.out.println(stringBuilder);
    }
}
