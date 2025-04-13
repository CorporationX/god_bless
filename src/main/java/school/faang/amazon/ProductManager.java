package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(IdGenerator.getId(), name, category);
        boolean check = products.add(product);
        if (!check) {
            throw new IllegalArgumentException("Такой товар уже существует");
        }
    }

    public void removeProduct(Category category, String name) {
        products.removeIf((prod) -> prod.name().equals(name) && prod.category().equals(category));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsFromCategory = new ArrayList<>();
        products.forEach(product -> {
            if (product.category() == category) {
                productsFromCategory.add(product);
            }
        });
        return productsFromCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Product product: products) {
            productsByCategories.putIfAbsent(product.category(), new ArrayList<>());
            productsByCategories.get(product.category()).add(product);
        }
        return productsByCategories;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategory().entrySet()) {
            System.out.println("Категория: " + entry.getKey() + "\nПродукты:");
            entry.getValue().forEach(product -> System.out.println(" - " + product.name()));
            System.out.println();
        }
    }
}