package school.faang.bjs2_85891;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int currentId = 0;

    public void addProduct(Product.Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println(product.getName() + " already exists in category " + product.getCategory());
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.println("Added product " + product);
    }

    public void removeProduct(Product.Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                products.remove(product);
                System.out.println("Removed product " + product);
                return;
            }
        }
        System.out.println("Product " + name + " in category " + category + ": does not exist.");
    }

    public List<String> findProductsByCategory(Product.Category category) {
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product.getName());
            }
        }
        return result;
    }

    public Map<Product.Category, List<Product>> groupProductsByCategory() {
        Map<Product.Category, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            if (!groupProducts.containsKey(product.getCategory())) {
                groupProducts.put(product.getCategory(), new ArrayList<>());
            }
            groupProducts.get(product.getCategory()).add(product);
        }
        return groupProducts;
    }

    public void printAllProducts() {
        Map<Product.Category, List<Product>> groupProducts = groupProductsByCategory();
        for (Map.Entry<Product.Category, List<Product>> entry : groupProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey() + "\nПродукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
