package school.faang.module1.task45152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Set<Product> products = new HashSet<>();
    static Map<String, List<Product>> productCategory = new HashMap<>();

    public static void main(String[] args) {
        addItem("name1", "category1");
        addItem("name2", "category1");
        addItem("name3", "category2");
        addItem("name4", "category3");
        System.out.println(productCategory);
        findItemsByCategory("category5");
        printAllItems();
        groupProductsByCategory(products);
    }

    public static void addItem(String name, String category) {
        Product product = new Product(name, category);
        //Скопипастил кусочек кода, можно подсказку как работает?
        //Ищет нужную категорию, если ее нет, то то создает ее(ключом), а в значение создает List и добавляет product
        //Если ключ есть, то просто add(product) в существующий List?
        productCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        if (category == null) {
            System.out.println("Такой категории нет");
            return;
        }
        //Не понятно как удалять, если просто передать name и category, то с рандомным id не удалится объект
        //Просьба подсказать
        Product product = new Product(name, category);
        productCategory.get(category).remove(product);
    }

    public static void findItemsByCategory(String category) {
        if (productCategory.get(category) == null) {
            System.out.println("Такой категории нет");
        } else {
            System.out.println(productCategory.get(category));
        }
    }

    public static void printAllItems() {
        products.forEach(System.out::println);
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        for (Product product : products) {
            productCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return (HashMap<String, List<Product>>) productCategory;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

