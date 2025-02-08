package school.faang.amazonestorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        Product product = new Product(getRandomId(), name, category);
        for (Product p : products) {
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                throw new IllegalArgumentException("Duplicate product name: " + name);
            }
        }
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        boolean isRemoved = false;
        for (Product p : products) {
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                products.remove(p);
                isRemoved = true;
                break;
            }
        }
        for (Product p : categoryMap.get(category)) {
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                categoryMap.get(category).remove(p);
                if (categoryMap.get(category).isEmpty()) {
                    categoryMap.remove(category);
                }
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            throw new IllegalArgumentException("Product " + name + " was not found.");
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
        for (Product p : products) {
            newCategoryMap.putIfAbsent(p.getCategory(), new ArrayList<>());
            newCategoryMap.get(p.getCategory()).add(p);
        }
        return newCategoryMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey() + "\n Продукты:");
            for (Product p : entry.getValue()) {
                System.out.println(" - " + p.getName());
            }
            System.out.println();
        }

    }

    private int getRandomId() {
        Random rand = new Random();
        return rand.nextInt(1, 100);

    }


}
