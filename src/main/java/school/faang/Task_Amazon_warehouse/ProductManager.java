package school.faang.Task_Amazon_warehouse;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class ProductManager {
    private static Set<Product> products = new HashSet<>();
    private static Map<Category, List<Product>> categoryMap = new HashMap<>();

    public static void addProduct(Category category, String name) {
        Product product = new Product(name, category);

        products.add(product);

        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public static void removeProduct(Category category, String name) {
        Product.validateName(name);
        Product.validateCategory(category);

        Product product = new Product(name, category);
        try {
            if (!categoryMap.containsKey(category)) {
                throw new IllegalArgumentException("Ошибка! Выбран не существующая категория");
            } else if (!categoryMap.get(category).contains(product)) {
                throw new IllegalArgumentException("Ошибка! товар не найден!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        products.remove(product);
        categoryMap.get(category).remove(product);
    }

    public static List<Product> findProductsByCategory(Category category) {

        Product.validateCategory(category);

        if (!categoryMap.containsKey(category)) {
            return new ArrayList<>();
        }
        return categoryMap.get(category);
    }

    public static Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {

        if (products.isEmpty()) {
            return categoryMap;
        }
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
        return categoryMap;
    }

    public static void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("-------------------------------------");
            System.out.println("Категория :" + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("-" + product);
            }
        }
    }

}