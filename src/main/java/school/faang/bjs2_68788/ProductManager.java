package school.faang.bjs2_68788;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    public Set<Product> findProductsByCategory(Category category) {
        Set<Product> returnedProducts = new HashSet<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                returnedProducts.add(product);
            }
        }
        return returnedProducts;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> returnedProducts = new HashMap<>();
        for (Product product : products) {
            returnedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return returnedProducts;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategory().entrySet()) {
            System.out.printf("Категория: %s\n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
        }
    }

}
