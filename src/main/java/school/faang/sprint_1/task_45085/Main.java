package school.faang.sprint_1.task_45085;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        System.out.println("Добавляем товары...");
        manager.addItem("Fruits", "Apple");
        manager.addItem("Fruits", "Banana");
        manager.addItem("Dairy", "Milk");
        manager.addItem("Dairy", "Cheese");
        manager.addItem("Vegetables", "Carrot");

        System.out.println("\nВсе товары:");
        manager.printAllItems();

        System.out.println("\nУдаляем товар Banana из категории Fruits:");
        manager.removeItem("Fruits", "Banana");
        manager.printAllItems();

        System.out.println("\nПробуем удалить товар Orange из категории Fruits:");
        manager.removeItem("Fruits", "Orange");

        System.out.println("\nПробуем удалить товар из категории Electronics:");
        manager.removeItem("Electronics", "TV");

        System.out.println("\nТовары в категории Dairy:");
        manager.findItemsByCategory("Dairy");

        System.out.println("\nТовары в категории Fruits:");
        manager.findItemsByCategory("Fruits");

        System.out.println("\nТовары в несуществующей категории Electronics:");
        manager.findItemsByCategory("Electronics");

        System.out.println("\nГруппировка товаров:");
        HashSet<Product> products = new HashSet<>(manager.getProductSet());
        var groupedProducts = manager.groupProductsByCategory(products);
        manager.printProductsByCategory(groupedProducts);

        manager.printAllItems();
    }
}
