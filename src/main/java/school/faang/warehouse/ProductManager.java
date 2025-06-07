package school.faang.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(category, name);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getCategory() == category && product.getName().equals(name)) {
                products.remove(product);
                break;
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productOfCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                productOfCategory.add(product);
            }
        }
        return productOfCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupCategory = new HashMap<>();
        for (Product product : products) {
            if (!groupCategory.containsKey(product.getCategory())) {
                groupCategory.put(product.getCategory(), new ArrayList<>());
            }
            groupCategory.get(product.getCategory()).add(product);
        }
        return groupCategory;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategory().entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты: ");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}
