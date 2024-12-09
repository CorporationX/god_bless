package school.faang.sprint1.bjs_45155;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Main {
    private static Set<Product> products = initializeSet();
    private static Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

    public static void main(String[] args) {
        // тестирование методов addItem, printAllItems, findItemsByCategory, printProductsByCategory
        addItem("Автомобильные товары", "Зеркало заднего вида");
        printAllItems();
        findItemsByCategory("Автомобильные товары");
        // не совсем понял, в чем должно быть отличие между методами printAllItems и этим
        printProductsByCategory(groupedProducts);
        System.out.println("fdfsdfsdfsdfsf");

        // тестирование метода removeItem
        removeItem("Автомобильные товары", "Зеркало заднего вида");
        printAllItems();
        findItemsByCategory("Автомобильные товары");
    }

    private static void addItem(String category, String name) {
        if (category.isEmpty() || category == null || name.isEmpty() || name == null) {
            throw new NoSuchElementException("Введенные данные некорректные");
        }

        products.add(new Product(products.size() + 1, name, category));
        groupedProducts = groupProductsByCategory(products);
    }

    private static void removeItem(String category, String name) {
        Product removedProduct = null;

        if (groupedProducts.containsKey(category)) {
            List<Product> categoryProducts = groupedProducts.get(category);
            for (Product product : categoryProducts) {
                if (product.getName().equals(name)) {
                    removedProduct = product;
                }
            }

            if (removedProduct == null) {
                throw new NoSuchElementException("Такого товара нет в данной категории!");
            }

            categoryProducts.remove(removedProduct);

            if (groupedProducts.get(category).size() == 0) {
                groupedProducts.remove(category);
            }
        } else {
            throw new NoSuchElementException("Такая категория не была добавлена");
        }
    }

    private static void findItemsByCategory(String category) {
        if (!groupedProducts.containsKey(category)) {
            throw new NoSuchElementException("Такая категория не была добавлена");
        } else {
            List<Product> categoryProducts = groupedProducts.get(category);
            System.out.println("\nТовары в категории " + category + ": ");
            for (Product product : categoryProducts) {
                System.out.println(product.getName() + "\n");
            }
        }
    }

    private static void printAllItems() {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
            System.out.println("-------------");
        }
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
            System.out.println("-------------");
        }
    }

    private static Set<Product> initializeSet() {
        Set<Product> products = new HashSet<>();

        String[][] productData = {
                {"1", "Губка для тела", "Гигиена"},
                {"2", "Компьютерная мышь", "Электроника"},
                {"3", "Телефон", "Электроника"},
                {"4", "Кухонный нож", "Бытовые товары"},
                {"5", "Чипсы", "Снэки"}
        };

        for (String[] product : productData) {
            int id = Integer.parseInt(product[0]);
            String name = product[1];
            String category = product[2];

            products.add(new Product(id, name, category));
        }

        return products;
    }
}
