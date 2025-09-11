package school.faang.bjs2_86035;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        System.out.println("=== ТЕСТИРОВАНИЕ СКЛАДА AMAZON ===\n");

        System.out.println("1. ДОБАВЛЕНИЕ ТОВАРОВ:");
        addTestProducts(manager);

        System.out.println("\n2. ВЫВОД ВСЕХ ТОВАРОВ:");
        manager.printAllProducts();

        System.out.println("\n3. ПОИСК ПО КАТЕГОРИИ:");
        testCategorySearch(manager);

        System.out.println("\n4. ТЕСТ ДУБЛИКАТОВ:");
        testDuplicateProducts(manager);

        System.out.println("\n5. ТЕСТ УДАЛЕНИЯ:");
        testProductRemoval(manager);

        System.out.println("\n6. ФИНАЛЬНЫЙ СПИСОК:");
        manager.printAllProducts();
    }

    private static void addTestProducts(ProductManager manager) {
        manager.addProduct(Category.FOOD, "Orange");
        manager.addProduct(Category.FOOD, "Croissant");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Phone");
        manager.addProduct(Category.CLOTHING, "Shoes");
        manager.addProduct(Category.CLOTHING, "Dress");
        manager.addProduct(Category.OTHER, "Book");
        manager.addProduct(Category.OTHER, "Pen");
    }

    private static void testCategorySearch(ProductManager manager) {
        System.out.println("Товары категории FOOD:");
        manager.findProductsByCategory(Category.FOOD).forEach(System.out::println);

        System.out.println("\nТовары категории ELECTRONICS:");
        manager.findProductsByCategory(Category.ELECTRONICS).forEach(System.out::println);

        System.out.println("\nТовары категории OTHER:");
        manager.findProductsByCategory(Category.OTHER).forEach(System.out::println);
    }

    private static void testDuplicateProducts(ProductManager manager) {
        System.out.println("Попытка добавить дубликат (Orange в FOOD):");
        manager.addProduct(Category.FOOD, "Orange");

        System.out.println("Попытка добавить дубликат (Laptop в ELECTRONICS):");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
    }

    private static void testProductRemoval(ProductManager manager) {
        System.out.println("Удаляем существующий товар (Orange из FOOD):");
        boolean removed1 = manager.removeProduct(Category.FOOD, "Orange");
        System.out.println("Результат удаления: " + (removed1 ? "Успешно" : "Не удалось"));

        System.out.println("\nПытаемся удалить несуществующий товар (Bread из FOOD):");
        boolean removed2 = manager.removeProduct(Category.FOOD, "Bread");
        System.out.println("Результат удаления: " + (removed2 ? "Успешно" : "Не удалось"));
    }
}