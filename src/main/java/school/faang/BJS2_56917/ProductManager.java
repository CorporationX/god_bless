package school.faang.BJS2_56917;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ProductManager {
    private static final Set<Product> products = new HashSet<>();
    private static final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(1);

    private static void addProduct(Category category, String name) {
        Product newProduct = new Product(counter.getAndIncrement(), name, category);
        products.add(newProduct);
        categoryMap.computeIfAbsent(category, (k -> new ArrayList<>())).add(newProduct);
    }

    private static void removeProduct(Category category, String name) {
        if (category == null) {
            System.out.println("⚠️ Category cannot be null.");
            return;
        }

        Product newProduct = new Product(counter.getAndIncrement(), name, category);

        if (!products.contains(newProduct)) {
            System.out.printf("⚠️ Продукт \"%s\" в категории \"%s\" не найден!%n", name, category);
            return;
        }

        products.remove(newProduct);
        categoryMap.get(category).remove(newProduct);
    }

    private static List<Product> findProductsByCategory(Category category) {
        if (category == null) {
            System.out.println("⚠️ Category cannot be null.");
            return new ArrayList<>();
        }

        if (!categoryMap.containsKey(category)) {
            System.out.printf("Такой категория продуктов нет %s%n", category);
            return new ArrayList<>();
        }

        System.out.printf("Категория: %s%n", category);
        categoryMap.get(category).forEach(product -> {
            System.out.printf("Продукт:%n"
                            + "ID: %d%n"
                            + "Name: %s%n",
                    product.getId(), product.getName());
        });
        return categoryMap.get(category);
    }

    private static void groupProductsByCategory() {
        // этот метод я добаил только иза задания в нем нет нужды так как и так уже все группируется автомаический
        categoryMap.clear();

        products.forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), (k) -> new ArrayList<>()).add(product);
        });
    }

    private static void printAllProducts() {
        categoryMap.forEach((key, value) -> {
            System.out.printf("Категория: %s%n", key);
            value.forEach(product -> {
                System.out.printf("Продукты:");
                System.out.printf("- %s%n", product.getName());
            });
            System.out.printf("-------------------%n");
        });
    }

    public static void main(String[] args) {
        // FOOD (2 продукта)
        groupProductsByCategory();
        addProduct(Category.FOOD, "Hamburger");
        addProduct(Category.FOOD, "Pizza");

        // ELECTRONICS (2 продукта)
        addProduct(Category.ELECTRONICS, "Laptop");
        addProduct(Category.ELECTRONICS, "Smartphone");

        // CLOTHING (2 продукта)
        addProduct(Category.CLOTHING, "T-Shirt");
        addProduct(Category.CLOTHING, "Jeans");

        // OTHER (2 продукта)
        addProduct(Category.OTHER, "Book");
        addProduct(Category.OTHER, "Toy");
        printAllProducts();

        System.out.print("вызов метода groupProductsByCategory" + "\n");
        groupProductsByCategory();
        printAllProducts();


        findProductsByCategory(Category.CLOTHING);
        removeProduct(Category.CLOTHING, "Jeans");
        printAllProducts();
    }
}
