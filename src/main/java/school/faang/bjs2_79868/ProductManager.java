package school.faang.bjs2_79868;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ProductManager {
    private static final Set<Product> products = new HashSet<>();
    private final Map<Category, Map<String, Product>> productsNamesByCategory = new HashMap<>();


    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Товар с таким названием уже существует в категории " + category + "!");
                return;
            }
        }

        Product product = new Product(name, category);
        products.add(product);
        productsNamesByCategory.computeIfAbsent(category, k -> new HashMap<>()).put(name, product);
    }

    public void removeProduct(Category category, String name) {
        if (productsNamesByCategory.containsKey(category)) {
            Product productToRemove = productsNamesByCategory.get(category).get(name);
            products.remove(productToRemove);
            productsNamesByCategory.get(category).remove(name);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return new ArrayList<>(productsNamesByCategory.getOrDefault(category, new HashMap<>()).values());
    }

    public static Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    public static void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты: ");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
