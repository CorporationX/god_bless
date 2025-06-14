package school.faang.amazon;

import java.util.*;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
    }

    public boolean removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.contains(product)) {
            products.remove(product);
            return true;
        }
        return false;
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productList.add(product);
            }
        }
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productByCategory = new HashMap<>();
        for (Product product : products) {
            productByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}

