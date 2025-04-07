package school.faang.storage_amazon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Orange");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "PC");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.CLOTHING, "T-Shirt");
        productManager.addProduct(Category.OTHER, "Car");

        System.out.println("\nВсе продукты:");
        productManager.printAllProducts();

        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.removeProduct(Category.FOOD, "Tomato");
        productManager.removeProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("\nПродукты в категории FOOD:");
        List<Product> products = productManager.findProductsByCategory(Category.FOOD);
        products.forEach(System.out::println);
        System.out.println("\nПродукты в категории CLOTHING:");
        products = productManager.findProductsByCategory(Category.CLOTHING);
        products.forEach(System.out::println);

        System.out.println("\nГруппировка продуктов по категориям:");
        Map<Category, List<Product>> productsByCategory = productManager.groupProductsByCategory();
        productsByCategory.forEach(
                (k, v) -> System.out.printf("%s: %s\n",
                        k, v.stream().map(Product::getName).collect(Collectors.joining(", ")))
        );

        System.out.println("\nФинальный список продуктов:");
        productManager.printAllProducts();
    }
}
