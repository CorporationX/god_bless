package school.faang.bjs2_86026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        final Product productToAdd = new Product(name, category);
        if (products.contains(productToAdd)) {
            System.out.println("Set products already contains product " + name);
        } else {
            products.add(productToAdd);
        }
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(nextProduct ->
                nextProduct.getCategory().equals(category) && nextProduct.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        final List<Product> products = groupProductsByCategory().get(category);
        return products == null
                ? new ArrayList<>()
                : products;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        final Map<Category, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            groupProducts.computeIfAbsent(
                    product.getCategory(),
                    key -> new ArrayList<>()
            ).add(product);
        }
        return groupProducts;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> groupProducts : groupProductsByCategory().entrySet()) {
            System.out.println("Категория: " + groupProducts.getKey());
            System.out.println("Продукты:");
            for (Product product : groupProducts.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}