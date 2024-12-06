package school.faang.task_45151;

import java.util.*;

public class Main {
    private static int productIdCounter = 1; // Счeтчик для айди
    private static HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {
        // добавление товаров для демонстрации функционала
        addItem("Электроника", "Ноут");
        addItem("Электроника", "Телефон");
        addItem("Домовые принадлежности", "Швабра");
        addItem("Фурнитура", "Стульчик");
        addItem("Фурнитура", "Стол");

        // удаляем стол
        removeItem("Фурнитура", "Стол");

        // ищем товар по категории
        findItemsByCategory("Электроника");

        // вывод товаров
        printAllItems();


        System.out.println("____ВЫВОД ТОВАРОВ ПО КАТЕГОРИЯМ____");
        //групировка продуктов
        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        //вывод товаров по категориям (после групировки)
        printProductsByCategory(groupedProducts);
    }

    public static void addItem(String category, String name) {
        Product newProduct = new Product(productIdCounter++, name, category);
        if (products.add(newProduct)) {
            System.out.println("Продукт добавлен: " + newProduct);
        } else {
            System.out.println("Продукт уже существует: " + newProduct);
        }
    }

    public static void removeItem(String category, String name) {
        boolean removed = products.removeIf(product ->
                product.getCategory().equals(category) && product.getName().equals(name));
        if (removed) {
            System.out.println("Продукт удален: " + name + " из категории " + category);
        } else {
            System.out.println("Не найден продукт .");
        }
    }

    public static void findItemsByCategory(String category) {
        List<Product> items = new ArrayList<>(); //
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                items.add(product);
            }
        }
        if (items.isEmpty()) {
            System.out.println("пусто в  " + category);
        } else {
            System.out.println("Продукты в категории " + category + ": " + items);
        }
    }

    public static void printAllItems() {
        if (products.isEmpty()) {
            System.out.println("Нет продуктов");
        } else {
            System.out.println("Все продукты:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            System.out.println("No products grouped by category.");
        } else {
            for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
                System.out.println("Категория: " + entry.getKey());
                for (Product product : entry.getValue()) {
                    System.out.println("  " + product);
                }
            }
        }
    }
}
