package school.faang.bjs2_85951;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public ProductManager() {

    }

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    private List<Product> findProductsByCategory(Category category) {
        Map<Category, List<Product>> groupedProductsByCategory = groupProductsByCategory();
        return groupedProductsByCategory.computeIfAbsent(category, k -> new ArrayList<>());
    }

    private Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProductsByCategory = new HashMap<>();
        for (Product product : products) {
            List<Product> groupedProducts = groupedProductsByCategory.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<>());
            groupedProducts.add(product);
        }
        return groupedProductsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProductsByCategory = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProductsByCategory.entrySet()) {
            printProducts(entry.getKey(), entry.getValue());
        }
    }

    public void printProductsByCategory(Category category) {
        List<Product> groupedProducts = findProductsByCategory(category);
        printProducts(category, groupedProducts);
    }

    private void printProducts(Category category, List<Product> group) {
        System.out.println("Категория: " + category);
        System.out.println("Продукты:");
        for (Product product : group) {
            System.out.println("- " + product.getName());
        }
        System.out.println();
    }
}
