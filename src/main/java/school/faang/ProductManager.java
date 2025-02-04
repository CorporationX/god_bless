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
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public boolean addProduct(Category category, String name) {
        Product product = new Product(category, name);
        if (products.contains(product)) {
            return false;
        }
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
        return true;
    }

    public boolean removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                if (categoryMap.containsKey(category)) {
                    categoryMap.get(category).remove(product);
                }
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Product> findProductsByCategory(Category category) {
        if (!categoryMap.containsKey(category)) {
            return new ArrayList<>();
        }
        return categoryMap.get(category);
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for(Product product : products) {
            productsByCategories.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsByCategories.get(product.getCategory()).add(product);
        }
        categoryMap = productsByCategories;
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
