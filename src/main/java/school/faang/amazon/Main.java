package school.faang.amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");
        manager.addProduct(Category.OTHER, "Book");

        System.out.println("=== Все продукты после добавления ===");
        manager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Apple");
        System.out.println("=== После удаления Apple ===");
        manager.printAllProducts();

        System.out.println("=== Поиск в категории ELECTRONICS ===");
        manager.findByCategory(Category.ELECTRONICS).forEach(System.out::println);

        System.out.println("=== Группировка по категориям ===");
        manager.groupProductsByCategory().forEach((category, products) -> {
            System.out.println(category + " -> " + products);
        });
    }
}