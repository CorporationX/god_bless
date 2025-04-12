package amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int productId = 1;

    public void addProduct(Category category, String name) {
        int id = productId++;
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("категория " + entry.getKey());
            System.out.println("продукты: ");
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product.getName());
            }
        }
    }
}
