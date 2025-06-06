package school.faang.module1.bjs2_79853;

import lombok.Data;

import java.util.*;

@Data
public class ProductManager {

    private final Set<Product> products = new HashSet<>();

    public boolean addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                return false;
            }
        }
        return products.add(new Product(name, category));
    }

    public boolean removeProduct(Category category, String name) {
        return products.removeIf(product ->
                product.getName().equals(name) && product.getCategory() == category
        );
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), category -> new ArrayList<>()).add(product);
        }
        return productsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();
        grouped.forEach((category, productList) -> {
            System.out.println("Категория: " + category);
            System.out.println("Продукты: ");
            productList.forEach(product -> System.out.println(" - " + product.getName()));
            System.out.println();
        });
    }
}