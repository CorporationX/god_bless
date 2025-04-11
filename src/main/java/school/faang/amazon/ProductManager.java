package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Такой товар уже существует в данной категории");
                return;
            }
            if (product.getName().equals(name)) {
                System.out.println("Товар с таким именем существует, но в другой катогории");
                return;
            }
        }
        Product product = new Product(name, category);
        products.add(product);
        Product.setId();
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsFromCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                productsFromCategory.add(product);
            }
        }
        return productsFromCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Category category : Category.values()) {
            List<Product> productsByCategory = findProductsByCategory(category);
            if (!productsByCategory.isEmpty()) {
                productsByCategories.put(category, findProductsByCategory(category));
            }
        }
        return productsByCategories;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategory().entrySet()) {
            System.out.println("Категория: " + entry.getKey() + "\nПродукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}