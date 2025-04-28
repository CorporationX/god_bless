package school.faang.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        this.products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        this.products.remove(product);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> groupedProducts = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getCategory() == category) {
                groupedProducts.add(product);
            }
        }
        return groupedProducts;
    }

    public Map<Category, List<Product>> groupedByCategory() {

        Map<Category, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : this.products) {
            Category category = product.getCategory();
            if (!groupedProducts.containsKey(category)) {
                groupedProducts.put(category, new ArrayList<>());
            }
            groupedProducts.get(category).add(product);
        }
        return groupedProducts;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupedByCategory();

        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.printf("Category of product %s\n", entry.getKey());
            System.out.printf("Products :\n");

            for (Product product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();
        }
    }
}
