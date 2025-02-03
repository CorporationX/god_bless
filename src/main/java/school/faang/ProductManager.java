package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Product.Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Product.Category category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public boolean removeProduct(Product.Category category, String name) {
        if (categoryMap.containsKey(category)) {
            List<Product> productList = categoryMap.get(category);
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    iterator.remove();
                    products.remove(product);
                    return true;
                }
            }
        }
        return false;
    }

    List<Product> findProductsByCategory(Product.Category category) {
        return categoryMap.get(category);
    }

    public static Map<Product.Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Product.Category, List<Product>> productCategories = new HashMap<>();
        for (Product product : products) {
            productCategories.putIfAbsent(product.getCategory(), new ArrayList<>());
            productCategories.get(product.getCategory()).add(product);
        }
        return productCategories;
    }

    public void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            List<Product> productList = entry.getValue();
            System.out.printf("Категория: %s\nПродукты:\n", entry.getKey());
            for (Product product : productList) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();
        }
    }
}
