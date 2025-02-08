package school.faang.Task_Amazon_warehouse;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. ТЕСТИРУЕМ ДОБАВЛЕНИЕ ПРОДУКТОВ
        ProductManager.addProduct(Category.ELECTRONICS, "Laptop");
        ProductManager.addProduct(Category.ELECTRONICS, "Phone");
        ProductManager.addProduct(Category.BOOKS, "Java Book");
        ProductManager.addProduct(Category.CLOTHING, "T-Shirt");
        ProductManager.addProduct(Category.CLOTHING, "Jeans");

        // 2. ВЫВОД ПРОДУКТОВ ДО УДАЛЕНИЯ
        System.out.println("Перед удалением:");
        ProductManager.printAllProducts();

        // 3. ТЕСТИРУЕМ УДАЛЕНИЕ ПРОДУКТА
        ProductManager.removeProduct(Category.ELECTRONICS, "Phone");

        System.out.println("\nПосле удаления продукта 'Phone' из ELECTRONICS:");
        ProductManager.printAllProducts();

        // 4. ТЕСТИРУЕМ ПОИСК ПРОДУКТОВ ПО КАТЕГОРИИ
        System.out.println("\nПродукты в категории BOOKS:");
        ProductManager.findProductsByCategory(Category.BOOKS)
                .forEach(System.out::println);

        // 5. ПРОВЕРКА УДАЛЕНИЯ НЕСУЩЕСТВУЮЩЕГО ПРОДУКТА
        System.out.println("\nПопытка удалить несуществующий продукт 'Tablet' из ELECTRONICS:");
        ProductManager.removeProduct(Category.ELECTRONICS, "Tablet");  // Ничего не изменится
        ProductManager.printAllProducts();

        // 6. ПРОВЕРКА УДАЛЕНИЯ ВСЕХ ПРОДУКТОВ ИЗ КАТЕГОРИИ
        ProductManager.removeProduct(Category.CLOTHING, "T-Shirt");
        ProductManager.removeProduct(Category.CLOTHING, "Jeans");
        System.out.println("\nПосле удаления всех продуктов из CLOTHING:");
        ProductManager.printAllProducts();

        // 7. ТЕСТИРУЕМ ГРУППИРОВКУ ПРОДУКТОВ
        System.out.println("\nГруппировка новых продуктов по категориям:");
        ProductManager.groupProductsByCategory(createProducts());
        ProductManager.printAllProducts();

        // 8. ТЕСТИРУЕМ ПОИСК В НОВЫХ КАТЕГОРИЯХ
        System.out.println("\nПродукты в категории FOOD:");
        ProductManager.findProductsByCategory(Category.FOOD)
                .forEach(System.out::println);
    }

    // Метод для создания набора продуктов для группировки
    public static Set<Product> createProducts() {
        return Set.of(
                new Product("Computer", Category.ELECTRONICS),
                new Product("Keyboard", Category.ELECTRONICS),
                new Product("Blender", Category.ELECTRONICS),
                new Product("Cake", Category.FOOD),
                new Product("Water", Category.FOOD)
        );
    }
}
