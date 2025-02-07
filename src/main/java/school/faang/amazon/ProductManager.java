package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {
    private static final AtomicInteger currentId = new AtomicInteger(0);

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        checkCategoryProduct(category);
        checkNameProduct(name);
        Product newProduct = new Product(currentId.incrementAndGet(), name, category);
        products.add(newProduct);
        categoryMap.computeIfAbsent(category, newCategory -> new ArrayList<>())
                .add(newProduct);
    }

    public boolean removeProduct(Category category, String name) {
        checkCategoryProduct(category);
        checkNameProduct(name);
        for (var product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                products.remove(product);
                categoryMap.get(category).remove(product);
                return true;
            }
        }
        return false;
    }

    public List<Product> findProductsByCategory(Category category) {
        checkCategoryProduct(category);
        if (categoryMap.containsKey(category)) {
            return categoryMap.get(category);
        } else {
            return new ArrayList<>();
        }
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        for (var product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), newProduct -> new ArrayList<>())
                    .add(product);
        }
    }

    public void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            System.out.printf("Категория: %s \nПродукты: ", entry.getKey());
            printListProductsName(categoryMap.get(entry.getKey()));
            System.out.println("\n");
        }
    }

    public void printListProductsName(List<Product> products) {
        for (var product : products) {
            System.out.print("\n- " + product.getName());
        }
    }

    public void checkNameProduct(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }

    public void checkCategoryProduct(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Категория не должна быть null");
        }
    }
}