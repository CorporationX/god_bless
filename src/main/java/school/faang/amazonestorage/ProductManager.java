package school.faang.amazonestorage;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private static int idCounter = 1;

    public void addProduct(Category category, String name) {
        validationName(name);
        Product newProduct = new Product(idCounter++, name, category);
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                throw new IllegalArgumentException("Duplicate product name: " + name);
            }
        }
        products.add(newProduct);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(newProduct);
    }

    public void removeProduct(Category category, String name) {
        validationName(name);
        boolean isRemoved = products.removeIf(product -> isEqualProduct(name, category, product));
        if (isRemoved) {
            List<Product> productList = categoryMap.get(category);
            productList.removeIf(product -> isEqualProduct(name, category, product));
            if (productList.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (!categoryMap.containsKey(category)) {
            return new ArrayList<>();
        }
        return categoryMap.get(category);
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> newCategoryMap = new HashMap<>();
        for (Product p : products) {
            newCategoryMap.putIfAbsent(p.getCategory(), new ArrayList<>());
            newCategoryMap.get(p.getCategory()).add(p);
        }
        return newCategoryMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println(MessageFormat.format("Категория: {0} \nПродукты:", entry.getKey()));
            for (Product p : entry.getValue()) {
                System.out.println(" - " + p.getName());
            }
            System.out.println();
        }

    }

    private void validationName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
    }

    private boolean isEqualProduct(String name, Category category, Product product) {
        return product.getName().equals(name)
                && product.getCategory().equals(category);
    }
}
