package school.faang.bjs22_56885;

import java.util.*;

public class ProductManager {
    private static final Set<Product> products = new HashSet<>();
    private static final Map<Category, List<Product>> categoryMap = new HashMap<>();
    int generateId = 1;

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
    }

    public void addProduct(Category category, String name) {
        validateName(name);
        Product productNew = new Product(generateId++, name, category);
        if (products.contains(productNew)) {
            throw new IllegalArgumentException("Продукт с таким именем уже существует");
        }
        products.add(productNew);
        categoryMap.computeIfAbsent(category, v -> new ArrayList<>()).add(productNew);
    }

    public void removeProduct(Category category, String name) {
        validateName(name);
        List<Product> productsList = categoryMap.get(category);
        if (productsList != null) {
            boolean removed = productsList.removeIf(product -> product.getName().equals(name));
            if (removed) {
                products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));

            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return Collections.unmodifiableList(categoryMap.getOrDefault(category, new ArrayList<>()));
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        products.forEach(p -> categoryMap.computeIfAbsent(p.getCategory(), v -> new ArrayList<>()));
    }

    protected void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты: ");
            entry.getValue().forEach(System.out::println);
        }
    }
}
