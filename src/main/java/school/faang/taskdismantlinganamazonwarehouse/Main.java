package school.faang.taskdismantlinganamazonwarehouse;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Data
public class Main {
    private static Map<String, List<Product>> productCategories = new HashMap<>();
    private static int IdCounter = 1;
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem("Электроника", "Телевизор");
        addItem("Электроника", "Смартфон");
        addItem("Бытовая техника", "Холодильник");
        addItem("Электроника", "Компьютер");
        addItem("Бытовая техника", "Стиральная машина");
        findItemsByCategory("Бытовая техника");
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            groupedProducts.putIfAbsent(category, new ArrayList<>());
            groupedProducts.get(category).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Categiry" + entry.getKey() + " - " + "product" + entry.getValue());
        }
    }

    public static void addItem(String category, String name) {
        Product product = new Product(IdCounter++, category, name);
        products.add(product);
        productCategories.putIfAbsent(category, new ArrayList<>());
        productCategories.get(category).add(product);
    }

    public static void removeItem(String category, String name) {
        if (productCategories.containsKey(category)) {
            List<Product> item = productCategories.get(category);
            boolean removed = item.removeIf(product -> product.getName().equals(name)
                    && product.getCategory().equals(category));
            if (removed) {
                products.removeIf(product -> product.getName().equals(name)
                        && product.getCategory().equals(category));
                System.out.println("Товар '" + name + "' был удален из категории '" + category + "'.");
            } else {
                System.out.println("Товар '" + name + "' не найден в категории '" + category + "'.");
            }
        } else {
            System.out.println("Категория '" + category + "' не найдена.");
        }
    }

    public static void findItemsByCategory(String category) {
        if (productCategories.containsKey(category)) {
            System.out.println("Товары в категории '" + category + "': " + productCategories.get(category));
        } else {
            System.out.println("Категория '" + category + "' не найдена.");
        }
    }

    public static void printAllItems() {
        if (productCategories.isEmpty()) {
            System.out.println("Нет товаров");
            return;
        }
        for (Map.Entry<String, List<Product>> entry : productCategories.entrySet()) {
            System.out.println("Категория " + entry.getKey() + " Товары " + entry.getValue());
        }
    }
}

