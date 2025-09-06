package school.faang.java_collection.bjs2_85891;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int currentId = 0;

    public void addProduct(Category category, String name) {
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

    public void removeProduct(Category category, String name) {
        Product toRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("Удален товар: " + toRemove);
        } else {
            System.out.println("Товар '" + name + "' в категории '" + category + "' не найден.");
        }
    }


    public List<String> findProductsByCategory(Category category) {
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product.getName());
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            if (!groupProducts.containsKey(product.getCategory())) {
                groupProducts.put(product.getCategory(), new ArrayList<>());
            }
            groupProducts.get(product.getCategory()).add(product);
        }
        return groupProducts;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey() + "\nПродукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
