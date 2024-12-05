package school.faang.task_45105;

import lombok.Getter;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class ProductStorage {
    private final Set<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        products.add(new Product(name, category));
    }

    public void removeItem(String category, String name) {
        boolean removed = products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));

        if (!removed) {
            throw new RuntimeException("Product not found");
        }
    }

    public List<Product> findItemsByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    public void printAllItems() {
        System.out.println("Start of printing products...");
        if (products.isEmpty()) {
            System.out.println("There are no products in this storage");
        }
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("End of printing products");
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            groupedProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {

        if (MapUtils.isEmpty(groupedProducts)) {
            System.out.println("There are no products in this storage");
        }

        for (Map.Entry<String, List<Product>> categoriesEntrySet : groupedProducts.entrySet()) {
            System.out.println("Category name: " + categoriesEntrySet.getKey());
            System.out.println("Products names:");
            for (Product product : categoriesEntrySet.getValue()) {
                System.out.println(product);
            }
        }
    }
}
