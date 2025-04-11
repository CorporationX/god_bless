package amazon.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        int randomId = ThreadLocalRandom.current().nextInt(1, 10);
        this.products.add(new Product(randomId, name, category));
    }

    public void removeProduct(int id, Category category, String name) {
        Product productForRemove = new Product(id, name, category);
        if (this.products.contains(productForRemove)) {
            this.products.remove(productForRemove);
        } else {
            System.out.printf("Product on category %s with name %s is not find!", category, name);
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
        Map<Category, List<Product>> groupedListsByCategory = new HashMap<>();
        for (Product product : this.products) {
            groupedListsByCategory.putIfAbsent(product.getCategory(),
                    findProductsByCategory(product.getCategory()));
        }
        return groupedListsByCategory;
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
