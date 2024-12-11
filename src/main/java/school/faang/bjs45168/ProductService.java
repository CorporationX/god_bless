package school.faang.bjs45168;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class ProductService {
    private final Set<Product> products = new HashSet<>();
    private final Map<String, List<Product>> categories = new HashMap<>();
    private final Map<String, Product> nameToProductMap = new HashMap<>();
    private int productIdAutoIncrement;

    public void addItem(String category, String name) {
        Product product = new Product(productIdAutoIncrement, name, category);
        products.add(product);
        categories.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        nameToProductMap.put(name, product);
        productIdAutoIncrement++;
    }

    public void removeItem(String category, String name) {
        Product product = nameToProductMap.get(name);
        if (product == null) {
            System.out.println("Product with name " + name + " not found!");
        }
        if (!categories.containsKey(category)) {
            System.out.println("Category " + category + " not found!");
        }
        products.remove(product);
        categories.get(category).remove(product);
        nameToProductMap.remove(name);
    }

    public List<Product> findItemsByCategory(String category) {
        var categoryProducts = categories.get(category);
        if (categoryProducts == null) {
            System.out.println("Category " + category + " not found!");
            return null;
        }
        return categoryProducts;
    }

    public void printAllItems() {
        for (var product : products) {
            System.out.println(product);
        }
    }

    public Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> categories = new HashMap<>();
        for (var product : products) {
            categories.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return categories;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var pair : groupedProducts.entrySet()) {
            System.out.println("\n" + pair.getKey() + " category:");
            for (var product : pair.getValue()) {
                System.out.println(product);
            }
        }
    }
}
