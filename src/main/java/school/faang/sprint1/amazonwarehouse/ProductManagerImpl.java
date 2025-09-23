package school.faang.sprint1.amazonwarehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManagerImpl implements ProductManager {

    private final Set<Product> products = new HashSet<>();
    private int nextId = 1;

    @Override
    public Product addProduct(Category category, String name) {
        validateProductData(category, name);

        Product product = new Product(generateId(), name, category);
        products.add(product);

        return product;
    }

    @Override
    public boolean removeProduct(Category category, String name) {
        validateProductData(category, name);
        return products.removeIf(product ->
            product.getCategory().equals(category)
                && product.getName().equalsIgnoreCase(name));
    }

    @Override
    public List<Product> findProductsByCategory(Category category) {
        validateCategory(category);
        return products.stream()
            .filter(product -> product.getCategory().equals(category))
            .toList();
    }

    @Override
    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
    }

    @Override
    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        groupedProducts.forEach((category, products) -> {
            System.out.println("Category: " + category);
            System.out.println("Products: ");
            products.forEach(product -> System.out.println("\t - " + product.getName()));
            System.out.println();
        });
    }

    private int generateId() {
        return nextId++;
    }

    private void validateProductData(Category category, String name) {
        validateCategory(category);
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
    }
}
