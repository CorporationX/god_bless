package school.faang.amazon;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    private int productId;

    public boolean addProduct(Category category, String name) {
        return products.add(new Product(generateId(), name, category));
    }

    public boolean removeProduct(Category category, String name) {
        return products.removeIf(product -> product.getName().equals(name) && product.getCategory() == category);
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .toList();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> categoryListEntry : groupProductsByCategory().entrySet()) {
            System.out.printf("Категория: %s\nПродукты:\n", categoryListEntry.getKey());
            categoryListEntry.getValue()
                    .forEach(product -> System.out.println(String.format("- %s", product.getName())));
        }
    }

    private int generateId() {
        return productId++;
    }
}