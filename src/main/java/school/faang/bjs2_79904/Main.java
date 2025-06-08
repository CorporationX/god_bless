package school.faang.bjs2_79904;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Добавление продуктов
        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-shirt");

        System.out.println("Все продукты после добавления:");
        manager.printAllProducts();

        System.out.println("Все продукты после добавления:");

        // Поиск продуктов по категории
        System.out.println("\nПродукты в категории ELECTRONICS:");
        List<Product> electronics = manager.findProductByCategory(Category.ELECTRONICS);
        electronics.forEach(p -> System.out.println("- " + p.getName()));

        // Удаление продукта
        System.out.println("\nУдаляем продукт 'Bread' из категории FOOD");
        boolean removed = manager.removeProduct(Category.FOOD, "Bread");
        System.out.println(removed ? "Продукт удален" : "Продукт не найден");

        System.out.println("\nВсе продукты после удаления:");
        manager.printAllProducts();

        // Группировка продуктов по категориям
        System.out.println("\nГруппировка продуктов по категориям:");
        Map<Category, List<Product>> productsByCategory = manager.groupProductsByCategory();
        productsByCategory.forEach((category, products) -> {
            System.out.println(category + ": " + products.size() + " товаров");
        });
    }
}
