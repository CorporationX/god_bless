package school.faang.task_43518;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String FOOD = "Еда";
    private static final String CHEMICALS = "Бытовая химия";
    private static final String BEAUTY = "Красота";

    private static int id = 1;
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem(FOOD, "Тортик");
        addItem(FOOD, "Пицца");
        addItem(FOOD, "Суши");
        addItem(CHEMICALS, "Доместос");
        addItem(CHEMICALS, "Fairy");
        addItem(BEAUTY, "Гель для умывания лица");
        addItem(BEAUTY, "Помада для губ");

        findItemsByCategory(FOOD);
        System.out.println();

        removeItem(CHEMICALS, "Доместос");

        printAllItems();
        System.out.println();

        printProductsByCategory(groupProductsByCategory(products));
    }

    public static void addItem(String category, String name) {
        if (category.isBlank() || name.isBlank()) {
            throw new IllegalArgumentException("Категория и название не должны быть пустыми!");
        }
        products.add(new Product(id++, category, name));
    }

    public static void removeItem(String category, String name) {
        boolean isFounded = false;
        if (category.isBlank() || name.isBlank()) {
            throw new IllegalArgumentException("Категория и название не должны быть пустыми!");
        }
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                products.remove(product);
                isFounded = true;
                break;
            }
        }
        if (!isFounded) {
            System.out.println("Продукт не найден");
        }
    }

    public static void findItemsByCategory(String category) {
        boolean isFounded = false;
        if (category.isBlank()) {
            throw new IllegalArgumentException("Категория не может быть пустой!");
        }
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println(product);
                isFounded = true;
            }
        }
        if (!isFounded) {
            System.out.println("Товаров с такой категорией нет!");
        }
    }

    public static void printAllItems() {
        if (products.isEmpty()) {
            System.out.println("Продуктов нет!");
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> productsByCategory : groupedProducts.entrySet()) {
            System.out.println(productsByCategory.getKey());
            for (Product product : productsByCategory.getValue()) {
                System.out.println(product);
            }
            System.out.println();
        }
    }
}
