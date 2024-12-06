package school.faang.task_45104;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final HashSet<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        addProducts();
        findItemsByCategory("Молочные продукты");
        removeItem("Овощи", "Баклажан");
        printAllItems();

        HashMap<String, List<Product>> productsByCategory = new HashMap<>();
        productsByCategory = groupProductsByCategory(PRODUCTS);
        printProductsByCategory(productsByCategory);

    }

    private static void printAllItems() {
        System.out.println("Вывод всех товаров в каждой категории:");
        for (Product product : PRODUCTS) {
            System.out.println(String.format("Product:%s, category:%s", product.getName(), product.getCategory()));
        }
    }

    private static void printProductsByCategory(HashMap<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println(String.format("Category:%s", entry.getKey()));
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
        }
    }

    private static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productsByCategory;
    }

    private static void removeItem(String category, String name) {
        boolean isExist = false;
        Iterator<Product> iterator = PRODUCTS.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                iterator.remove();
                System.out.println(String.format("Продукт '%s' из категории %s найден и удален", name, category));
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println(String.format("Продукт %s с категорией %s не найден", name, category));
        }
    }

    private static void findItemsByCategory(String category) {
        List<Product> products = PRODUCTS.stream().filter(cat -> cat.getCategory().equals(category)).
                collect(Collectors.toList());
        if (products.isEmpty()) {
            System.out.println(String.format("По категории '%s' продуктов не найдено", category));
            return;
        }
        System.out.println(String.format("Найдены следующие продукты категории '%s'", category));
        System.out.println(products);
    }

    private static void addItem(String category, String name) {
        PRODUCTS.add(new Product(name, category));
    }

    private static void addProducts() {
        addItem("Молочные продукты", "Молоко");
        addItem("Молочные продукты", "Сыр");
        addItem("Молочные продукты", "Сливки");
        addItem("Мясные продукты", "Курица");
        addItem("Мясные продукты", "Говядина");
        addItem("Фрукты", "Банан");
        addItem("Овощи", "Баклажан");
    }
}
