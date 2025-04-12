package amazon.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Integer randomId = 0;

    public void addProduct(Category category, String name) {
        this.randomId++;
        this.products.add(new Product(this.randomId, name, category));
    }

    public void removeProduct(int id, Category category, String name) {
        Product productForRemove = new Product(id, name, category);
        if (this.products.contains(productForRemove)) {
            this.products.remove(productForRemove);
        } else {
            throw new IllegalArgumentException("Product category " + category + " with name " + name + " not found!");
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsOnCategory = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getCategory() == category) {
                productsOnCategory.add(product);
            }
        }
        return productsOnCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return this.products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> categoryListEntry : groupProductsByCategory().entrySet()) {
            System.out.printf("Категория: %s %nПродукты: %n", categoryListEntry.getKey());
            for (Product product : categoryListEntry.getValue()) {
                System.out.printf("- %s %n", product.getName());
            }
            System.out.println();
        }
    }
}
