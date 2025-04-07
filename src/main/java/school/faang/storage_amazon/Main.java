package school.faang.storage_amazon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProductManager pManager = new ProductManager();

        pManager.addProduct(Category.FOOD, "Orange");
        pManager.addProduct(Category.FOOD, "Apple");
        pManager.addProduct(Category.FOOD, "Bread");
        pManager.addProduct(Category.ELECTRONICS, "PC");
        pManager.addProduct(Category.ELECTRONICS, "Smartphone");
        pManager.addProduct(Category.CLOTHING, "T-Shirt");
        pManager.addProduct(Category.OTHER, "Car");

        System.out.println("\nВсе продукты:");
        pManager.printAllProducts();

        pManager.removeProduct(Category.FOOD, "Apple");
        pManager.removeProduct(Category.FOOD, "Tomato");
        pManager.removeProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("\nПродукты в категории FOOD:");
        List<Product> products = pManager.findProductsByCategory(Category.FOOD);
        products.forEach(System.out::println);
        System.out.println("\nПродукты в категории CLOTHING:");
        products = pManager.findProductsByCategory(Category.CLOTHING);
        products.forEach(System.out::println);

        System.out.println("\nГруппировка продуктов по категориям:");
        Map<Category, List<Product>> productsByCategory = pManager.groupProductsByCategory();
        productsByCategory.forEach(
                (k, v) -> System.out.printf("%s: %s\n", k, v.stream().map(Product::getName).collect(Collectors.joining(", ")))
        );

        System.out.println("\nФинальный список продуктов:");
        pManager.printAllProducts();
    }
}
