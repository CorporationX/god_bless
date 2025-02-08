package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private static int id = 1;

    private final Set<Product> productSet = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        Product product = new Product(id++, name, category);
        for (Product p : productSet) {
            if (product.getName().equals(p.getName()) && product.getCategory().equals(p.getCategory())) {
                throw new IllegalArgumentException("Duplicate: product: " + p.getName());
            }
        }
        productSet.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        Iterator<Product> iterator = productSet.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                iterator.remove();
            }
        }

        List<Product> products = categoryMap.get(category);
        if (products != null) {
            products.removeIf(p -> p.getName().equals(name));

            if (products.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (!categoryMap.containsKey(category)) {
            return null;
        }
        return categoryMap.get(category);
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> newCategoryMap = new HashMap<>();
        for (Product product : productSet) {
            newCategoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            newCategoryMap.get(product.getCategory()).add(product);
        }
        return newCategoryMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.printf("Категория: " + entry.getKey() + "\n" + "Продукты:" + "\n");
            for(Product product: entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        }
    }
}
