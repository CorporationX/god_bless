package school.faang.task_45118;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem(2, "Морковь", "Овощи");
        addItem(3, "Капуста", "Овощи");
        addItem(4, "Яблоки", "Фрукты");
        addItem(5, "Груши", "Фрукты");
        addItem(6, "Бананы", "Фрукты");
        addItem(7, "Курица", "Мясо");
        addItem(8, "Говядина", "Мясо");
        addItem(9, "Свинина", "Мясо");
        addItem(10, "Рыба", "Морепродукты");
        addItem(11, "Креветки", "Морепродукты");
        addItem(12, "Лосось", "Морепродукты");

        findItemsByCategory("Рубашка");
        findItemsByCategory("Фрукты");

        printAllItems();
        removeItem(6, "Фрукты", "Яблоко");
        printAllItems();

        groupProductsByCategory((HashSet<Product>) products);
        printProductsByCategory(groupProductsByCategory((HashSet<Product>) products));
    }


    private static void addItem(int id, String name, String category) {
        products.add(new Product(id, name, category));
    }

    private static void removeItem(int id, String category, String name) {
        if (products.contains(new Product(id, name, category))) {
            products.remove(new Product(id, name, category));
        } else {
            System.out.println("Такого товара нет");
        }
    }

    private static void findItemsByCategory(String category) {
        boolean flag = false;
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println(product.getId() + " " + product.getCategory() + " " + product.getName());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Такой категории нет");
        }
    }


    public static void printAllItems() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product.getId() + ", " + product.getName());
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> group = new HashMap<>();
        for (Product product : products) {
            if (group.containsKey(product.getCategory())) {
                group.get(product.getCategory()).add(product);
            } else {
                group.put(product.getCategory(), new ArrayList<>());
                group.get(product.getCategory()).add(product);
            }
        }
        return group;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Product product : entry.getValue()) {
                System.out.println("name: " + product.getName());
            }
        }
    }
}
