package school.faang.bjs2_86070;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> groupProduct = new HashMap<>();

    public void addProduct(Category category, String name) {
        validateName(name);
        validateCategory(category);
        Product product = new Product(category, name);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        validateName(name);
        validateCategory(category);
        Product product = new Product(category, name);
        if (products.contains(product)) {
            System.out.println("Удален продукт - " + product);
            products.remove(product);
            return;
        }
        System.out.println("Такого объекта нет - " + product);

    }

    public List<Product> findProductsByCategory(Category category) {
        validateCategory(category);
        List<Product> productList = new ArrayList();
        for (Product product : products) {
            if (Objects.equals(product.getCategory(), category)) {
                productList.add(product);
            }
        }
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        for (Product product : products) {
            groupProduct.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupProduct;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> group = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : group.entrySet()) {
            System.out.printf("%nКатегория: %s%nПродукты:%n", entry.getKey());
            for (Product product : group.get(entry.getKey())) {
                System.out.printf("- %s%n", product.getName());
            }
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private void validateCategory(Category category) {
        if (category == null || category.name().isBlank()) {
            throw new IllegalArgumentException("Категория не должна быть пустой");
        }
    }
}
