package school.faang.bjs279923;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        var productData = new Product(name, category);
        var hasProduct = this.products.contains(productData);
        if (hasProduct) {
            System.out.println("The product already exists");
            return;
        }
        var productToAdd = new Product(IdGenerator.generateId(), name, category);
        this.products.add(productToAdd);
        System.out.printf("The product was added successfully: %s\n", productToAdd);
    }

    public boolean removeProduct(Category category, String name) {
        var removingProduct = new Product(name, category);
        return this.products.remove(removingProduct);
    }

    public List<Product> findProductsByCategory(Category category) {
        return this.products
                .stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return this.products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        var productsByCategory = this.groupProductsByCategory();
        productsByCategory.forEach((category, products) -> {
            System.out.printf("Category: %s\n", category);
            System.out.println("Products:");
            products.stream().map(Product::getName).forEach(name -> System.out.printf("- %s\n", name));
        });
    }
}
