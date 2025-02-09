package school.faang.bjs22_56885;

import java.util.*;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    int generateId = 1;

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
    }

    public void addProduct(Category category, String name) {
        validateName(name);
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Товар уже добавлен в категорию: " + category);
                return;
            }
        }
        Product productNew = new Product(generateId, name, category);
        products.add(productNew);
        for (Product product : products) {
            if (product.getCategory().equals(category))  {
                categoryMap.putIfAbsent(category, new ArrayList<>());
                categoryMap.get(category).add(product);
            }
        }
        generateId++;
    }

    public void removeProduct(Category category, String name) {
        validateName(name);
        List<Product> productsList = categoryMap.get(category);
        if (productsList != null) {
            productsList.removeIf(product -> product.getName().equals(name));
        }
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));

    }

    public void findProductsByCategory(Category category) {
        List<Product> products = categoryMap.get(category);
        if (products == null || products.isEmpty()) {
            System.out.println(" Категория " + category + " пустая");
        } else {
            for (Product product : products) {
                System.out.println("- " + product);
            }
        }
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
    }

    protected void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты: ");
            entry.getValue().forEach(System.out::println);
        }
    }
}
