package school.faang.task_58962;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int currentId = 1;

    public boolean addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Product with the same name " +
                        "already exists in the category");
                return false;
            }
        }
        int id = currentId++;
        Product product = new Product(id, name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, event -> new ArrayList<>()).add(product);
        return true;
    }

    public void removeProduct(Category category, String name) {
        if(name == null || name.isBlank()) {
            System.out.println("Name is null or blank");
            return;
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                if (categoryMap.containsKey(category)) {
                    categoryMap.get(category).remove(product);
                }
                iterator.remove();
                System.out.println("Product: " + name + " delete.");
                return;
            }
        }
        System.out.println("Product not found.");
    }


    public List<Product> findProduct(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Product product : products) {
            productsByCategories.computeIfAbsent(product.getCategory(), event -> new ArrayList<>()).add(product);
        }
        categoryMap = productsByCategories;
        System.out.println(categoryMap);
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
