package school.faang.task_45129;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem(1, "Картофель", "Овощи");
        addItem(2, "Морковь", "Овощи");
        addItem(4, "Апельсин", "Фрукты");
        addItem(5, "Манго", "Фрукты");
        addItem(6, "Яблоко", "Фрукты");
        addItem(7, "Форель", "Рыба");
        findItemsByCategory("Овощи");
        removeItem(1, "Картофель", "Овощи");
        printAllItems();
        printProductsByCategory(groupProductsByCategory(products));
    }

    public static void addItem(int id, String name, String category) {
        products.add(new Product(id, name, category));
    }

    public static void removeItem(int id, String name, String category) {
        if (products.contains(new Product(id, name, category))) {
            products.remove(new Product(id, name, category));
        } else {
            System.out.println("Данный продукт отсутсвует!");
        }
    }

    public static void findItemsByCategory(String category) {
        int total = 0;
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println("id: " + product.getId() + ", name: " + product.getName());
                total++;
            }
        }
        if (total == 0) {
            System.out.println("Данная категория продуктов отсутсвует!");
        }
    }

    public static void printAllItems() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println("id: " + product.getId() + ", name: " + product.getName());
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> mapProduct = new HashMap<>();
        for (Product product : products) {
            if (mapProduct.containsKey(product.getCategory())) {
                mapProduct.get(product.getCategory()).add(product);
            } else {
                mapProduct.put(product.getCategory(), new ArrayList<>());
                mapProduct.get(product.getCategory()).add(product);
            }
        }
        return mapProduct;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Product product : entry.getValue()) {
                System.out.println("id: " + product.getId() + ", name: " + product.getName());
            }
        }
    }
}
