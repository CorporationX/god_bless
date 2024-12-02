package school.faang.task_45086;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    private static HashSet<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        addItem("Категория1", "Название1");
        addItem("Категория2", "Название2");
        addItem("Категория3", "Название3");
        addItem("Категория1", "Название1");
        addItem("Категория43", "Название12");
        addItem("Категория43", "Название123");
        printAllItems();
        removeItem("Категория2", "Название2");
        printAllItems();
        findItemsByCategory("Категория1");
        HashMap<String, List<Product>> groupedProducts = groupProductsByCategory(PRODUCTS);
        printProductsByCategory(groupedProducts);
    }

    public static void addItem(String category, String name) {
        int id = new Random().nextInt(0, 100);
        Product product = new Product(id, name, category);
        PRODUCTS.add(product);
    }

    public static void removeItem(String category, String name) {
        for (Product product : PRODUCTS) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                PRODUCTS.remove(product);
                return;
            }
        }
        System.out.println("Такого товара или категории нет");
    }

    public static void findItemsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : PRODUCTS) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        for (Product product : productsByCategory) {
            System.out.println(product);
        }
        if (productsByCategory.isEmpty()) {
            System.out.println("Товары по категории " + category + " не найдены");
        }
    }

    private static void printAllItems() {
        for (Product product : PRODUCTS) {
            System.out.println(product);
        }
        System.out.println("=========================");
    }

    private static void printAllItems(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            if (!groupedProducts.containsKey(category)) {
                groupedProducts.put(category, new ArrayList<>());
            }
            groupedProducts.get(category).add(product);
        }
        return groupedProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey());
            List<Product> products = groupedProducts.get(entry.getKey());
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
