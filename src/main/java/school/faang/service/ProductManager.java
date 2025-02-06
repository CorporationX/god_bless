package school.faang.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<String>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(name);
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(value -> value.getName().equals(name) && value.getCategory()==category);
    }

    public void printAllProducts() {
        for (Product value : products) {
            System.out.println(value.getId() + " " + value.getCategory() + " " + value.getName());
        }
        System.out.println("------------------");
        System.out.println(categoryMap);
    }
}
